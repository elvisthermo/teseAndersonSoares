/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.treemap;

import doutorado.tese.util.Coluna;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/**
 * A simple implementation of the AbstractNode interface.
 */
public class TreeMapItem extends TreeMapNode {

//    AbstractNode[] itemsFilhos;
    private String columnLabel;

    public TreeMapItem(double size, int order) {
        this.size = size;
        this.classificationOrder = order;
        bounds = new Rect();
        this.mapaDetalhesItem = new HashMap<>();
        children = new ArrayList<>();
    }

    public TreeMapItem(double size, TreeMapLevel paiLevel) {
        this.size = size;
        this.paiLevel = paiLevel;
        bounds = new Rect();
        mapaDetalhesItem = new HashMap<>();
        children = new ArrayList<>();
    }

    public TreeMapItem() {
        this(1, 0);
    }

    /**
     * @return the folha
     */
    public boolean isFolha() {
        return getPaiLevel() != null;
    }

//    @Override
//    public String toString() {
//        return "Rect.Label:" + bounds.label + " - Size: " + getSize() + " - Order: " + getClassificationOrder() + " - Depth: " + getDepth();
//    }
    @Override
    public void setSize(Coluna colunaTamanho) {
        this.size = Double.parseDouble(mapaDetalhesItem.get(colunaTamanho));
    }

//    public void setSize(Double tamanho) {
//        this.size = tamanho;
//    }
    
    /**
     * @param coluna o obj coluna para definir o label
     */
    public void setLabel(Coluna coluna) {
        this.columnLabel = coluna.getName();
    }
    
//    @Override
//    public ArrayList<TreeMapNode> getItemsFilhos() {
//        return itemsFilhos;
//    }

    @Override
    public void inserirFilhos(Queue<String> hierarquia, TreeMapNode item, TreeMapNode pai) {
        throw new UnsupportedOperationException("A TreeMapItem can't have children.");
    }

    private Point centralizarLegenda(Rect rect, Graphics2D g2d) {
        int stringW = (int) Math.round(g2d.getFontMetrics().getStringBounds(this.getLabel(), g2d).getCenterX());
        int stringH = (int) Math.round(g2d.getFontMetrics().getStringBounds(this.getLabel(), g2d).getCenterY());
        int xTexto = (int) ((rect.w / 2) + rect.x) - stringW;
        int yTexto = (int) ((rect.h / 2) + rect.y) - stringH;
        return new Point(xTexto, yTexto);
    }

//    @Override
//    public void paint(Graphics2D g) {
//        System.out.println("Paint filhos" + this + "\t " + this.getBounds());
//        if (this.getPaiLevel().getLabel().equalsIgnoreCase("diesel")) {
//            g.setColor(Color.GREEN);
//            g.fillRect((int) Math.round(this.bounds.x) + 1, (int) Math.round(this.bounds.y) + 1,
//                    (int) Math.round(this.bounds.w) - 1, (int) Math.round(this.bounds.h) - 1);
//        } else {
//            g.setColor(Color.RED);
//            g.fillRect((int) Math.round(this.bounds.x) + 1, (int) Math.round(this.bounds.y) + 1,
//                    (int) Math.round(this.bounds.w) - 1, (int) Math.round(this.bounds.h) - 1);
//            g.setColor(Color.black);
//            g.drawString("("+(int) (Math.round(this.bounds.x) + 1)+","+(int) (Math.round(this.bounds.y) + 1)+")", 
//                (int) Math.round(this.bounds.x) + 1, (int)  Math.round(this.bounds.y) + 1);
//        }
//        g.setColor(Color.black);
//        g.drawRect((int) Math.round(this.bounds.x), (int) Math.round(this.bounds.y),
//                (int) Math.round(this.bounds.w), (int) Math.round(this.bounds.h));
////        if (this.isUseLabel) {
////            Point centro = centralizarLegenda(this.bounds, g);
////            g.drawString(this.label, centro.x, centro.y);
////        }
//    }

}
