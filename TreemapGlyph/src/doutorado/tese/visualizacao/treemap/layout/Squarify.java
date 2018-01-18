/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.treemap.layout;

import doutorado.tese.visualizacao.treemap.Rect;
import doutorado.tese.visualizacao.treemap.TreeMapNode;
import java.util.List;

/**
 *
 * @author Anderson Soares
 */
public class Squarify {

    public void squarify(TreeMapNode treemapLevel) {
        List<TreeMapNode> arrayItems = treemapLevel.getChildren();

        if (treemapLevel.isHasChildren()) {
            int start = 0;
            int end = treemapLevel.getChildren().size();
            Rect rectangle = treemapLevel.getBordaInterna();

            int a = 0;
            int mid = 0;
            int totalSlice = 0;
            int b = 0;
            int q = 0;
            double total = treemapLevel.getSize();

            while (start <= end) {
                if ((end - start) < 2) {
                    totalSlice = this.sum(arrayItems, start, end);
                    this.sliceLayout(arrayItems, start, end, totalSlice, rectangle);
                    break;
                }
                a = (int) Math.round(arrayItems.get(start).getSize() / total);
                mid = start;
                b = a;

                if (rectangle.w < rectangle.h) {
                    while (mid < end) {
                        double aspect = this.normAspect(rectangle.h, rectangle.w, a, b);
                        q = (int) Math.round(arrayItems.get(start).getSize() / total);
                        if (this.normAspect(rectangle.h, rectangle.w, a, b + q + (q / 2)) > aspect) {
                            break;
                        }
                        mid = mid + 1;
                        b = b + q;
                    }
                    totalSlice = this.sum(arrayItems, start, mid);
                    Rect r = new Rect(rectangle.x, rectangle.y, rectangle.w, rectangle.h);
                    this.sliceLayout(arrayItems, start, mid, totalSlice, r);
                    rectangle = new Rect(rectangle.x, rectangle.y + (rectangle.h * b), rectangle.w, rectangle.h * (1 - b));
                } else {
                    while (mid < end) {
                        double aspect = this.normAspect(rectangle.w, rectangle.h, a, b);                        
                        q = (int) Math.round(arrayItems.get(start).getSize() / total);
                        if (this.normAspect(rectangle.w, rectangle.h, a, b + q + (q / 2)) > aspect) {
                            break;
                        }
                        mid = mid + 1;
                        b = b + q;
                    }
                    totalSlice = this.sum(arrayItems, start, mid);
                    Rect r = new Rect(rectangle.x, rectangle.y, rectangle.w * b, rectangle.h);
                    this.sliceLayout(arrayItems, start, mid, totalSlice, r);
                    rectangle = new Rect(rectangle.x + (rectangle.w * b), rectangle.y, rectangle.w * (1 - b), rectangle.h);
                }
                total = total - totalSlice;
                start = mid + 1;
            }
        }
    }

    private int sum(List<TreeMapNode> items, int _start, int _end) {
        int sumValuesItems = 0;//essa varia ira armazenar a soma dos valores dos items
        for (int i = _start; i < _end; i++) {
            sumValuesItems += items.get(i).getSize();
        }

        return sumValuesItems;
    }

    private void sliceLayout(List<TreeMapNode> items, int start, int end, int totalSlice, Rect rectangleBounds) {
        boolean vertical = false;
        int aSlice = 0;
        int bSlice = 0;
        TreeMapNode treemapNode = null;

//        if (rectangleBounds.w > rectangleBounds.h) {//nodo na horizontal
//            vertical = false;//-->horizontal == true
//        } else {
//            vertical = true;//-->horizontal == false
//        }
        vertical = rectangleBounds.w <= rectangleBounds.h;
        for (int i = start; i < end; i++) {
            treemapNode = items.get(i);
            bSlice = (int) Math.round(treemapNode.getSize() / totalSlice);
            if (vertical) {
                treemapNode.getBounds().x = rectangleBounds.x;
                treemapNode.getBounds().w = rectangleBounds.w;
                treemapNode.getBounds().y = rectangleBounds.y + (rectangleBounds.h * aSlice);
                treemapNode.getBounds().h = rectangleBounds.h * bSlice;
            } else {
                treemapNode.getBounds().x = rectangleBounds.x + (rectangleBounds.w * aSlice);
                treemapNode.getBounds().w = rectangleBounds.w * bSlice;
                treemapNode.getBounds().y = rectangleBounds.y;
                treemapNode.getBounds().h = rectangleBounds.h;
            }
            aSlice += bSlice;

            if (treemapNode.isHasChildren()) {
//                treemapNode.redefinirBorda();
                squarify(treemapNode);
            }
        }
    }

    private double normAspect(double big, double small, int a, int b) {
        double normA = this.aspect(big, small, a, b);
        if (normA < 1) {
            return 1 / normA;
        }
        return normA;
    }

    private double aspect(double big, double small, int a, int b) {
        return (big * b) / (small * a / b);
    }
}
