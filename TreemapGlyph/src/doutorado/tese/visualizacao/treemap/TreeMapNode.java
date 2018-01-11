/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.treemap;

import doutorado.tese.organize.QuickSort;
import doutorado.tese.util.Coluna;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/**
 *
 * @author Anderson Soares
 */
public abstract class TreeMapNode {

    double size;
    Rect bounds;
    int classificationOrder = 0;
    int depth;
    TreeMapNode paiLevel;
    boolean raiz;
    protected String label;
    boolean isUseLabel = false;
    private boolean hasChildren;
    protected HashMap<Coluna, String> mapaDetalhesItem;
    protected Rect bordaInterna;
//    int borderWidth = 2;
//    int drawIniY = 20;//x inicial para desenhar
    ArrayList<TreeMapNode> itemsFilhos;

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public double getSize() {
        return size;
    }

    public void setSize(Coluna colunaTamanho) {
        this.size = 0;
    }

    public Rect getBounds() {
        return bounds;
    }

    public void setBounds(Rect bounds) {
        this.bounds = bounds;
    }

    public void setBounds(double x, double y, double w, double h) {
        bounds.setRect(x, y, w, h);
    }

    public int getClassificationOrder() {
        return classificationOrder;
    }

    public void setClassificationOrder(int classificationOrder) {
        this.classificationOrder = classificationOrder;
    }

    /**
     * @return the paiLevel
     */
    public TreeMapNode getPaiLevel() {
        return paiLevel;
    }

    /**
     * @param paiLevel the paiLevel to set
     */
    public void setPaiLevel(TreeMapNode paiLevel) {
        this.paiLevel = paiLevel;
    }

    /**
     * @return the raiz
     */
    public boolean isRaiz() {
        return raiz;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the mapaDetalhesItem
     */
    public HashMap<Coluna, String> getMapaDetalhesItem() {
        return mapaDetalhesItem;
    }

    /**
     * @param mapaDetalhesItem the mapaDetalhesItem to set
     */
    public void setMapaDetalhesItem(HashMap<Coluna, String> mapaDetalhesItem) {
        this.mapaDetalhesItem = mapaDetalhesItem;
    }

    /**
     * Verifica o tamanho da fonte do label (rotulo) em relacao ao retangulo do
     * Nodo
     *
     * @param g2d
     * @param text
     * @param textWidth
     * @param nodeWidth
     * @param fontSize
     * @return Retorna um vetor onde [0] - labelWidth; [1] - fontSize
     */
    public int[] verifyFontCanvasSize(Graphics2D g2d, String text, int textWidth, int nodeWidth, int fontSize) {
        while (textWidth >= (nodeWidth - 2)) {
            fontSize = fontSize - 1;
//		canvas:attrFont(fontFamily, fontSize, fontStyle);
            g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
            textWidth = (int) Math.round(g2d.getFontMetrics().getStringBounds(text, g2d).getCenterX());
//                labelWidth = canvas:measureText(label);
        }
        return new int[]{textWidth, fontSize};
    }

    public abstract ArrayList<TreeMapNode> getItemsFilhos();

    public abstract void inserirFilhos(Queue<String> hierarquia, TreeMapNode item, TreeMapNode pai);

    public abstract void paint(Graphics2D g);

//    public void redefinirBorda() {
//        int x = (int) Math.round(this.bounds.x) + this.borderWidth;
//        int y = (int) Math.round(this.bounds.y) + this.drawIniY;
//        int width = (int) Math.round(this.bounds.w) - (2 * this.borderWidth);
//        int height = (int) Math.round(this.bounds.h) - this.drawIniY - this.borderWidth;
//        setBordaInterna(new Rect(x, y, width, height));
//    }

    /**
     * @return the hasChildren
     */
    public boolean isHasChildren() {
//        System.out.println(this);
        if (this.getItemsFilhos().size() > 0) {
            return hasChildren = true;
        } else {
            return hasChildren = false;
        }
    }

    public ArrayList<TreeMapNode> organize() {
        if (this.isHasChildren()) {
            for (TreeMapNode filho : this.getItemsFilhos()) {
                filho.organize();
            }
            QuickSort.sortDescending(this.getItemsFilhos());
//            this.bubbleSort(this.getItemsFilhos());
        }
        return this.getItemsFilhos();
    }

    /**
     * @return the bordaInterna
     */
    public Rect getBordaInterna() {
        return bordaInterna;
    }

    /**
     * @param bordaInterna the bordaInterna to set
     */
    public void setBordaInterna(Rect bordaInterna) {
        this.bordaInterna = bordaInterna;
    }

    @Override
    public String toString() {
        return "[Label: " + label + " Pai: " + paiLevel.label + " Size: " + size; //To change body of generated methods, choose Tools | Templates.
    }

}
