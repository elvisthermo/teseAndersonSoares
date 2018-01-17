/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import net.bouthier.treemapAWT.TMModelNode;
import net.bouthier.treemapAWT.TMModelUpdater;

/**
 *
 * @author Anderson Soares
 * @param <TreeMapNode>
 */
public class TMTreeMapItemModelNode<TreeMapNode> implements TMModelNode {

    private TMModelUpdater updater = null; // the updater for this node
    private final List<TMTreeMapItemModelNode<TreeMapNode>> children;
    private TreeMapNode nodo = null;
    private TMTreeMapItemModelNode<TreeMapNode> parent = null;

    public TMTreeMapItemModelNode(TreeMapNode nodo) {
        this.children = new ArrayList<>();
        this.nodo = nodo;
    }

    public TMTreeMapItemModelNode<TreeMapNode> addChild(TMTreeMapItemModelNode<TreeMapNode> child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<TMTreeMapItemModelNode<TreeMapNode>> children) {
        for (TMTreeMapItemModelNode<TreeMapNode> node : children) {
            node.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<TMTreeMapItemModelNode<TreeMapNode>> getChildren() {
        return children;
    }

    public Vector<TMTreeMapItemModelNode<TreeMapNode>> parseList2Vector(List<TMTreeMapItemModelNode<TreeMapNode>> list) {
        Vector<TMTreeMapItemModelNode<TreeMapNode>> v = new Vector<TMTreeMapItemModelNode<TreeMapNode>>();
        for (TMTreeMapItemModelNode<TreeMapNode> node : list) {
            v.add(node);
        }
        return v;
    }

    @Override
    public Object getRoot() {
        if (this.getParent() == null) {
            return this;
        }
        return this.getParent().getRoot();
    }

    @Override
    public Enumeration children(Object node) {
        TMTreeMapItemModelNode<TreeMapNode> n = (TMTreeMapItemModelNode<TreeMapNode>) node;
        Vector v = parseList2Vector(n.getChildren());
        return v.elements();
    }

    @Override
    public boolean isLeaf(Object node) {
        boolean leaf = false;
        TMTreeMapItemModelNode<TreeMapNode> n = (TMTreeMapItemModelNode<TreeMapNode>) node;
        if (n.getChildren().isEmpty()) {
            return true;
        }
        return leaf;
    }

    @Override
    public void setUpdater(TMModelUpdater updater) {
        this.updater = updater;
    }

    public TreeMapNode getNodo() {
        return nodo;
    }

    public void setNodo(TreeMapNode nodo) {
        this.nodo = nodo;
    }

    public TMTreeMapItemModelNode<TreeMapNode> getParent() {
        return parent;
    }

    public void setParent(TMTreeMapItemModelNode<TreeMapNode> parent) {
        this.parent = parent;
    }

}
