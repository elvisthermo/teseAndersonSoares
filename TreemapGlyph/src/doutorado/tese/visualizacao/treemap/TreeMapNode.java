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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import net.bouthier.treemapAWT.TMModelNode;
import net.bouthier.treemapAWT.TMModelUpdater;

/**
 *
 * @author Anderson Soares
 */
public abstract class TreeMapNode implements TMModelNode{

    double size;
    Rect bounds;
    int classificationOrder = 0;
    int depth;
    TreeMapNode paiLevel;
    private boolean raiz;
    private String label;
    private boolean useLabel = false;
    private boolean hasChildren;
    protected HashMap<Coluna, String> mapaDetalhesItem;
    protected Rect bordaInterna;
//    int borderWidth = 2;
//    int drawIniY = 20;//x inicial para desenhar
//    ArrayList<TreeMapNode> itemsFilhos;
    private TMModelUpdater updater = null; // the updater for this node
    protected List<TreeMapNode> children;
//    private TreeMapNode nodo = null;
    private TreeMapNode parent = null;

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
    
    public void setSize(Double tamanho) {
        this.size = tamanho;
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

    public void setRaiz(boolean raiz) {
        this.raiz = raiz;
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

    public abstract void inserirFilhos(Queue<String> hierarquia, TreeMapNode item, TreeMapNode pai);

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
        if (this.getChildren().size() > 0) {
            return hasChildren = true;
        } else {
            return hasChildren = false;
        }
    }

    public List<TreeMapNode> organize() {
        if (this.isHasChildren()) {
            for (TreeMapNode filho : this.getChildren()) {
                filho.organize();
            }
            QuickSort.sortDescending(this.getChildren());
//            this.bubbleSort(this.getItemsFilhos());
        }
        return this.getChildren();
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
        return "[Label: " + getLabel() + " Pai: " + paiLevel.getLabel() + " Size: " + size; //To change body of generated methods, choose Tools | Templates.
    }
    
    //Metodos para criar uma arvore
    public TreeMapNode addChild(TreeMapNode child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<TreeMapNode> children) {
        for (TreeMapNode node : children) {
            node.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<TreeMapNode> getChildren() {
        return children;
    }

    public Vector<TreeMapNode> parseList2Vector(List<TreeMapNode> list) {
        Vector<TreeMapNode> v = new Vector<TreeMapNode>();
        for (TreeMapNode node : list) {
            v.add(node);
        }
        return v;
    }
    
    public TreeMapNode getParent() {
        return parent;
    }

    public void setParent(TreeMapNode parent) {
        this.parent = parent;
    }
    
    //Metodos implementados da interface 
    @Override
    public Object getRoot() {
        if (this.getParent() == null) {
            return this;
        }
        return this.getParent().getRoot();
    }

    @Override
    public Enumeration children(Object node) {
        TreeMapNode n = (TreeMapNode) node;
        Vector v = parseList2Vector(n.getChildren());
        return v.elements();
    }

    @Override
    public boolean isLeaf(Object node) {
        boolean leaf = false;
        TreeMapNode n = (TreeMapNode) node;
        if (n.getChildren().isEmpty()) {
            return true;
        }
        return leaf;
    }

    @Override
    public void setUpdater(TMModelUpdater updater) {
        this.updater = updater;
    }

    /**
     * @return the useLabel
     */
    public boolean isUseLabel() {
        return useLabel;
    }

    /**
     * @param useLabel the useLabel to set
     */
    public void setUseLabel(boolean useLabel) {
        this.useLabel = useLabel;
    }
}
