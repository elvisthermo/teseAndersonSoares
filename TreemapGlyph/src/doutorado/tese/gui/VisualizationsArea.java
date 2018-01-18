/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.gui;

import Tree.TMModel_Draw;
import Tree.TMModel_Size;
import doutorado.tese.io.ManipuladorArquivo;
import doutorado.tese.util.Coluna;
import doutorado.tese.util.Flags;
import doutorado.tese.visualizacao.treemap.TreeMapItem;
import doutorado.tese.visualizacao.treemap.TreeMapLevel;
import doutorado.tese.visualizacao.treemap.TreeMapNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import net.bouthier.treemapAWT.TMModelNode;
import net.bouthier.treemapAWT.TMView;
import net.bouthier.treemapAWT.TreeMap;


/**
 *
 * @author Anderson Soares
 */
public class VisualizationsArea{

    private final ManipuladorArquivo manipulador;
    private Queue<String> hierarquiaFila;
    private String labelColumn = "";
    private TreeMapNode root;
    //variaveis para a API do Treemap
    private TMModelNode model = null; // the model of the demo tree
    private TreeMap treeMap = null; // the treemap builded
    private TMView view = null;

    public VisualizationsArea(int w, int h, ManipuladorArquivo manipulador, 
            String itemTamanho, String[] itensHierarquia, String itemLegenda,
            List<String> variaveisStarGlyph) {
        this.manipulador = manipulador;
        this.hierarquiaFila = new LinkedList<>();
        
        root = new TreeMapLevel();
        root.setPaiLevel(null);
        root.setRaiz(true);
        root.setLabel("ROOT");

        model = createTree(itensHierarquia, itemTamanho, itemLegenda);
//        printTree(model, "\t");
        treeMap = new TreeMap(model);
        
        TMModel_Size cSize = new TMModel_Size();
        TMModel_Draw cDraw = new TMModel_Draw();
        this.view = treeMap.getView(cSize, cDraw);
        this.view.setBounds(0, 0, w, h);
    }
    
    public void setHierarchy(String[] hierarquia) {
        for (TreeMapItem treeMapItem : manipulador.getItensTreemap()) {
            hierarquiaFila.addAll(Arrays.asList(hierarquia));
            root.inserirFilhos(hierarquiaFila, treeMapItem, root);
        }
    }
    
    public void setSizeColumn(Coluna column) {
        this.root.setSize(column);
//        this.root.organize();
    }
    
    public void setLabelColumn(Coluna column) {
        this.labelColumn = column.getName();
        setTreemapItemLabel(this.root.getChildren(), true);
    }

    public void setTreemapItemLabel(List<TreeMapNode> itemsFilhos, boolean isUseLabel) {
        itemsFilhos.forEach((filho) -> {
            if (filho instanceof TreeMapItem) {
                filho.setUseLabel(isUseLabel);
                if (filho.isUseLabel()) {
                    filho.setLabel(filho.getMapaDetalhesItem().get(ManipuladorArquivo.getColuna(labelColumn)));
                }else{
                    filho.setLabel("");
                }
            } else {
                TreeMapLevel level = (TreeMapLevel) filho;
                setTreemapItemLabel(level.getChildren(), isUseLabel);
            }
        });
    }

    private TreeMapNode createTree(String[] hierarquia, String itemTamanho, String itemLegenda) {
        setHierarchy(hierarquia);
        setSizeColumn(ManipuladorArquivo.getColuna(itemTamanho));
         if (!Flags.isShowLegenda()) {
            setTreemapItemLabel(root.getChildren(), false);
        } else {
            setLabelColumn(ManipuladorArquivo.getColuna(itemLegenda));
        }
        return root;
    }

    public void printTree(TMModelNode item, String appender) {
        TreeMapNode nodo = (TreeMapNode) item;
        System.out.println(appender+nodo.getLabel()+" - "+nodo.getSize());
        nodo.getChildren().forEach(each -> printTree(each, appender + appender));
    }
    
    /**
     * @return the treeMap
     */
    public TreeMap getTreeMap() {
        return treeMap;
    }

    /**
     * @return the view
     */
    public TMView getView() {
        return view;
    }
}
