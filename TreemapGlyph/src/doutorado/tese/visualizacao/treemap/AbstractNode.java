/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.treemap;

import doutorado.tese.util.Coluna;

/**
 *
 * Interface representing an object that can be placed
 * in a treemap layout.
 * <p>
 * The properties are:
 * <ul>
 * <li> size: corresponds to area in map.</li>
 * <li> classificationOrder: the sort order of the item. </li>
 * <li> depth: the depth in hierarchy. </li>
 * <li> bounds: the bounding rectangle of the item in the map.</li>
 * </ul>
 *
 */
public interface AbstractNode
{
//    public double getSize();
//    public void   setSize(double size);
//    public Rect   getBounds();
//    public void   setBounds(Rect bounds);
//    public void   setBounds(double x, double y, double w, double h);
//    public int    getClassificationOrder();
//    public void   setClassificationOrder(int order);
//    public int    getDepth();
//    public void   setDepth(int depth);
//    TreeMapLevel getPaiLevel();
 //    AbstractNode[] configureNode();
//    void setPaiLevel(TreeMapLevel paiLevel);
    boolean isFolha();
//    void setValue(Coluna coluna);//o mesmo que size
//    boolean isRaiz();
    /**
     * Get the list of items in this model.
     *
     * @return An array of the AbstractNode objects in this MapModel.
     */
//    AbstractNode[] getItemsFilhos();
//    void setItemsFilhos(AbstractNode[] filhos);
}
