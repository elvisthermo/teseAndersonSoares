/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import doutorado.tese.visualizacao.treemap.TreeMapItem;
import doutorado.tese.visualizacao.treemap.TreeMapLevel;
import doutorado.tese.visualizacao.treemap.TreeMapNode;
import javax.swing.JFrame;
import net.bouthier.treemapAWT.TMModelNode;
import net.bouthier.treemapAWT.TMView;
import net.bouthier.treemapAWT.TreeMap;

/**
 *
 * @author Anderson Soares
 */
public class TreemapAPITeste {
    private static TMModelNode model   = null; // the model of the demo tree
    private static TreeMap 		   treeMap = null; // the treemap builded
    private static String 		   name    = "Teste Treemap API"; // name for this demo
    
    public static void printTree(TMModelNode item, String appender) {
        TMTreeMapItemModelNode<TreeMapNode> i = (TMTreeMapItemModelNode<TreeMapNode>) item;
        System.out.println(appender+i.getNodo().getLabel()+" - "+i.getNodo().getSize());
        i.getChildren().forEach(each -> printTree(each, appender + appender));
    }
    
    public static void main(String[] args) {
        model = createTree();
        printTree(model, "\t");
        treeMap = new TreeMap(model);

        TMModel_Size fSize = new TMModel_Size();
        TMModel_Draw fDraw = new TMModel_Draw();
        TMView view = treeMap.getView(fSize, fDraw);

        JFrame viewFrame = new JFrame(name);
        viewFrame.setContentPane(view);
        viewFrame.pack();
        viewFrame.setVisible(true);
        viewFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    private static TMTreeMapItemModelNode<TreeMapNode> createTree() {
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
        TreeMapItem l_node12 = new TreeMapItem();
        l_node12.setSize(5d);
        l_node12.setLabel("Tracao - Item");
        TreeMapLevel l_node22 = new TreeMapLevel();
        l_node22.setSize(7d);
        l_node22.setLabel("Tracao - outra");
        TreeMapItem i_node111 = new TreeMapItem();
        i_node111.setSize(7d);
        i_node111.setLabel("alfa-romeu");
        TreeMapItem i_node112 = new TreeMapItem();
        i_node112.setSize(6d);
        i_node112.setLabel("bmw");
        TreeMapItem i_node221 = new TreeMapItem();
        i_node221.setSize(6d);
        i_node221.setLabel("dodge");
        
        TMTreeMapItemModelNode<TreeMapNode> root = new TMTreeMapItemModelNode<>(l_root);

        TMTreeMapItemModelNode<TreeMapNode> node1 = root.addChild(new TMTreeMapItemModelNode<>(l_node1));//gasolina

        TMTreeMapItemModelNode<TreeMapNode> node11 = node1.addChild(new TMTreeMapItemModelNode<>(l_node11));//tracao - sim
        TMTreeMapItemModelNode<TreeMapNode> node111 = node11.addChild(new TMTreeMapItemModelNode<>(i_node111));//alfa-romeu
        TMTreeMapItemModelNode<TreeMapNode> node112 = node11.addChild(new TMTreeMapItemModelNode<>(i_node112));//bmw

        TMTreeMapItemModelNode<TreeMapNode> node12 = node1.addChild(new TMTreeMapItemModelNode<>(l_node12));//tracao - item

        TMTreeMapItemModelNode<TreeMapNode> node2 = root.addChild(new TMTreeMapItemModelNode<>(l_node2));//diesel

        TMTreeMapItemModelNode<TreeMapNode> node22 = node2.addChild(new TMTreeMapItemModelNode<>(l_node22));//tracao - null
        TMTreeMapItemModelNode<TreeMapNode> node221 = node22.addChild(new TMTreeMapItemModelNode<>(i_node221));//dodge
        return root;
    }
}
