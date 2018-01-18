/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.treemap;

import java.util.List;

/**
 * Implements the Squarified Treemap layoutSquarifiedTreemap published by Mark
 * Bruls, Kees Huizing, and Jarke J. van Wijk
 *
 * Squarified Treemaps https://www.win.tue.nl/~vanwijk/stm.pdf
 *
 */
public class TreeMapLayout implements Layout {

    private int mid = 0;
    int borderWidth = 4;
    int drawIniY = 20;//x inicial para desenhar

    @Override
    public void layoutSquarifiedTreemap(TreeMapNode pai) {
        pai.setBordaInterna(redefinirBorda(pai.bounds));
        layout(pai, 0, pai.getChildren().size() - 1, pai.getBordaInterna());
    }

    public void layout(TreeMapNode pai, int start, int end, Rect dimensoes) {
        List<TreeMapNode> items = pai.getChildren();
        if (start > end) {
            return;
        }
        if (start == end) {
            items.get(start).setBounds(dimensoes);
            if (items.get(start) instanceof TreeMapLevel) {
                items.get(start).setBordaInterna(redefinirBorda(items.get(start).getBounds()));
//                layoutRow(items.get(start).getItemsFilhos(), 0, items.get(start).getItemsFilhos().size() - 1, items.get(start).getBordaInterna(), true);
                layout(items.get(start), 0, items.get(start).getChildren().size() - 1, items.get(start).getBordaInterna());
            }
        }
        this.mid = start;
        while (mid < end) {
            double a = highestAspect(items, start, mid, dimensoes);
            double b = highestAspect(items, start, mid + 1, dimensoes);
            if (a > b) {
                mid++;
            } else {
                if (start != end) {
                    Rect sobraRect = layoutRow(items, start, mid, dimensoes, true);
                    layout(pai, mid + 1, end, sobraRect);
                }else{
                    layout(pai, mid + 1, end, dimensoes);
                }
            }
        }
    }

    public Rect redefinirBorda(Rect bounds) {
        int x = (int) Math.round(bounds.x) + borderWidth;
        int y = (int) Math.round(bounds.y) + drawIniY;
        int width = (int) Math.round(bounds.w) - (2 * borderWidth);
        int height = (int) Math.round(bounds.h) - drawIniY - borderWidth;
        return new Rect(x, y, width, height);
    }

    public double highestAspect(List<TreeMapNode> items, int start, int end, Rect bounds) {
        layoutRow(items, start, end, bounds, false);
        double max = Double.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (items.get(i).getBounds().aspectRatio() > max) {
                max = items.get(i).getBounds().aspectRatio();
            }
        }
        return max;
    }

    /**
     *
     * @param items
     * @param start
     * @param end
     * @param dimenssoesPai
     * @param podeCalcularItens
     * @return Retorna quanto irá sobrar de espaço desenhavel para os proximos
     * nodos
     */
    public Rect layoutRow(List<TreeMapNode> items, int start, int end, Rect dimenssoesPai, boolean podeCalcularItens) {
        boolean isHorizontal = dimenssoesPai.w > dimenssoesPai.h;
        double areaTotal = dimenssoesPai.w * dimenssoesPai.h; //totalSize(items, 0, items.length-1);
        double rowSize = totalSize(items, start, end);
        double rowRatio = rowSize / areaTotal;
        double offset = 0;

        for (int i = start; i <= end; i++) {
            Rect retangulo = new Rect();
            double ratio = items.get(i).getSize() / rowSize;

            if (isHorizontal) {
                retangulo.x = dimenssoesPai.x;
                retangulo.w = dimenssoesPai.w * rowRatio;
                retangulo.y = dimenssoesPai.y + dimenssoesPai.h * offset;
                retangulo.h = dimenssoesPai.h * ratio;
            } else {
                retangulo.x = dimenssoesPai.x + dimenssoesPai.w * offset;
                retangulo.w = dimenssoesPai.w * ratio;
                retangulo.y = dimenssoesPai.y;
                retangulo.h = dimenssoesPai.h * rowRatio;
            }
            items.get(i).setBounds(retangulo);
            if (items.get(i) instanceof TreeMapLevel) {
                if (podeCalcularItens) {
                    items.get(i).setBordaInterna(redefinirBorda(items.get(i).getBounds()));
                    layout(items.get(i), 0, items.get(i).getChildren().size() - 1, items.get(i).getBordaInterna());
                    this.mid = start;
                }
            }
            offset += ratio;
        }
        if (isHorizontal) {
            return new Rect(dimenssoesPai.x + dimenssoesPai.w * rowRatio, dimenssoesPai.y, dimenssoesPai.w - dimenssoesPai.w * rowRatio, dimenssoesPai.h);
        } else {//desenha o retangulo na vertical
            return new Rect(dimenssoesPai.x, dimenssoesPai.y + dimenssoesPai.h * rowRatio, dimenssoesPai.w, dimenssoesPai.h - dimenssoesPai.h * rowRatio);
        }
    }

    public static double totalSize(List<TreeMapNode> items) {
        return totalSize(items, 0, items.size() - 1);
    }

    public static double totalSize(List<TreeMapNode> items, int start, int end) {
        double sum = 0;

        for (int i = start; i <= end; i++) {
            sum += items.get(i).getSize();
        }
        return sum;
    }

}
