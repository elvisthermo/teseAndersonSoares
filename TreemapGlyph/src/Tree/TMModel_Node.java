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
 * @param <T> nome do Nodo
 * @param <V> valor do Nodo
 */
public class TMModel_Node<T, V> implements TMModelNode {

    private TMModelUpdater updater = null; // the updater for this node
    private T data = null;
    private V value = null;
    private final List<TMModel_Node<T, V>> children;

    private TMModel_Node<T, V> parent = null;

    public TMModel_Node(T nomeNodo, V value) {
        this.children = new ArrayList<>();
        this.data = nomeNodo;
        this.value = value;
    }

    public TMModel_Node<T, V> addChild(TMModel_Node<T, V> child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<TMModel_Node<T, V>> children) {
        for (TMModel_Node<T, V> node : children) {
            node.setParent(this);
        }
        this.children.addAll(children);
//        children.forEach(each -> each.setParent(this));
//        this.children.addAll(children);
    }

    public List<TMModel_Node<T, V>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    private void setParent(TMModel_Node<T, V> parent) {
        this.parent = parent;
    }

    public TMModel_Node<T, V> getParent() {
        return parent;
    }

    @Override
    public Object getRoot() {
        if (this.getParent() == null) {
            return this;
        }
        return this.getParent().getRoot();
    }

    public Vector<TMModel_Node<T, V>> parseList2Vector(List<TMModel_Node<T, V>> list) {
        Vector<TMModel_Node<T, V>> v = new Vector<TMModel_Node<T, V>>();
        for (TMModel_Node<T, V> node : list) {
            v.add(node);
        }
        return v;
    }

    @Override
    public Enumeration children(Object node) {
        TMModel_Node<T, V> n = (TMModel_Node<T, V>) node;
        Vector v = parseList2Vector(n.getChildren());
        return v.elements();
    }

    @Override
    public boolean isLeaf(Object node) {
        boolean leaf = false;
        TMModel_Node<T, V> n = (TMModel_Node<T, V>) node;
        if (n.getChildren().isEmpty()) {
            return true;
        }
        return leaf;
    }

    @Override
    public void setUpdater(TMModelUpdater updater) {
          this.updater = updater;
    }
}
