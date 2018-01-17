/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import doutorado.tese.visualizacao.treemap.TreeMapItem;
import doutorado.tese.visualizacao.treemap.TreeMapLevel;
import doutorado.tese.visualizacao.treemap.TreeMapNode;

/**
 *
 * @author Anderson Soares
 */
public class TreeTesta {

    public static void main(String[] args) {
//        TMModel_Node<String, Object> root = createTree();
//        printTree(root, " ");
        TMTreeMapItemModelNode<TreeMapNode> root = createTree2();
        printTree2(root, "\t");
    }

    private static TMModel_Node<String, Object> createTree() {
        TMModel_Node<String, Object> root = new TMModel_Node<>("root", 0);

        TMModel_Node<String, Object> node1 = root.addChild(new TMModel_Node<String, Object>("node 1", 10));

        TMModel_Node<String, Object> node11 = node1.addChild(new TMModel_Node<String, Object>("node 11", 8));
        TMModel_Node<String, Object> node111 = node11.addChild(new TMModel_Node<String, Object>("node 111", 7));
        TMModel_Node<String, Object> node112 = node11.addChild(new TMModel_Node<String, Object>("node 112", 6));

        TMModel_Node<String, Object> node12 = node1.addChild(new TMModel_Node<String, Object>("node 12", 5));

        TMModel_Node<String, Object> node2 = root.addChild(new TMModel_Node<String, Object>("node 2", 5));

        TMModel_Node<String, Object> node21 = node2.addChild(new TMModel_Node<String, Object>("node 21",7));
        TMModel_Node<String, Object> node211 = node2.addChild(new TMModel_Node<String, Object>("node 22", 6));
        return root;
    }

    public static <T, V> void printTree(TMModel_Node<T, V> node, String appender) {
        System.out.println(appender + node.getData() + "\t"+node.getValue());
        node.getChildren().forEach(each -> printTree(each, appender + appender));
    }
    
    private static TMTreeMapItemModelNode<TreeMapNode> createTree2() {
        TreeMapLevel l_root = new TreeMapLevel();
        l_root.setSize(0d);
        l_root.setLabel("Root");
        TreeMapLevel l_node1 = new TreeMapLevel();
        l_node1.setSize(10d);
        l_node1.setLabel("Gasolina");
        TreeMapLevel l_node2 = new TreeMapLevel();
        l_node2.setSize(5d);
        l_node2.setLabel("Diesel");
        TreeMapLevel l_node11 = new TreeMapLevel();
        l_node11.setSize(8d);        
        l_node11.setLabel("Tracao - sim");
        TreeMapLevel l_node12 = new TreeMapLevel();
        l_node12.setSize(5d);
        l_node12.setLabel("Tracao - nao");
        TreeMapLevel l_node21 = new TreeMapLevel();
        l_node21.setSize(7d);
        l_node21.setLabel("Tracao - nao");
        TreeMapItem i_node111 = new TreeMapItem();
        i_node111.setSize(7d);
        TreeMapItem i_node112 = new TreeMapItem();
        i_node112.setSize(6d);
        TreeMapItem i_node211 = new TreeMapItem();
        i_node211.setSize(6d);
        
        TMTreeMapItemModelNode<TreeMapNode> root = new TMTreeMapItemModelNode<>(l_root);

        TMTreeMapItemModelNode<TreeMapNode> node1 = root.addChild(new TMTreeMapItemModelNode<>(l_node1));

        TMTreeMapItemModelNode<TreeMapNode> node11 = node1.addChild(new TMTreeMapItemModelNode<>(l_node11));
        TMTreeMapItemModelNode<TreeMapNode> node111 = node11.addChild(new TMTreeMapItemModelNode<>(i_node111));
        TMTreeMapItemModelNode<TreeMapNode> node112 = node11.addChild(new TMTreeMapItemModelNode<>(i_node112));

        TMTreeMapItemModelNode<TreeMapNode> node12 = node1.addChild(new TMTreeMapItemModelNode<>(l_node12));

        TMTreeMapItemModelNode<TreeMapNode> node2 = root.addChild(new TMTreeMapItemModelNode<>(l_node2));

        TMTreeMapItemModelNode<TreeMapNode> node21 = node2.addChild(new TMTreeMapItemModelNode<>(l_node21));
        TMTreeMapItemModelNode<TreeMapNode> node211 = node21.addChild(new TMTreeMapItemModelNode<>(i_node211));
        return root;
    }
    
    public static void printTree2(TMTreeMapItemModelNode<TreeMapNode> item, String appender) {
        System.out.println(appender+item.getNodo().getLabel()+" - "+item.getNodo().getSize());
        item.getChildren().forEach(each -> printTree2(each, appender + appender));
    }
}
