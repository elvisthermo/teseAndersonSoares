/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.gui;

import doutorado.tese.visualizacao.treemap.treemapAPI.TMModel_Draw;
import doutorado.tese.visualizacao.treemap.treemapAPI.TMModel_Size;
import doutorado.tese.io.ManipuladorArquivo;
import doutorado.tese.util.Coluna;
import doutorado.tese.util.Flags;
import doutorado.tese.visualizacao.treemap.Rect;
import doutorado.tese.visualizacao.treemap.TreeMapItem;
import doutorado.tese.visualizacao.treemap.TreeMapLevel;
import doutorado.tese.visualizacao.treemap.TreeMapNode;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Queue;
import net.bouthier.treemapAWT.TMModelNode;
import net.bouthier.treemapAWT.TMOnDrawFinished;
import net.bouthier.treemapAWT.TMNodeModel;
import net.bouthier.treemapAWT.TMThreadModel;
import net.bouthier.treemapAWT.TMUpdater;
import net.bouthier.treemapAWT.TMUpdaterConcrete;
import net.bouthier.treemapAWT.TMView;
import net.bouthier.treemapAWT.TreeMap;

/**
 *
 * @author Anderson Soares
 */
public class VisualizationsArea {

    private final ManipuladorArquivo manipulador;
    private Queue<String> hierarquiaFila;
    private String labelColumn = "";
    private TreeMapNode root;
    //variaveis para a API do Treemap
    private TMModelNode modelTree = null; // the model of the demo tree
    private TreeMap treeMap = null; // the treemap builded
    private TMView view = null;

    public VisualizationsArea(int w, int h, ManipuladorArquivo manipulador,
            String itemTamanho, String[] itensHierarquia, String itemLegenda,
            List<String> variaveisStarGlyph) {
        this.manipulador = manipulador;
        this.hierarquiaFila = new LinkedList<>();

        Rectangle rect = new Rectangle(0, 0, w, h);
        root = new TreeMapLevel(new Rect(rect.x, rect.y, rect.width, rect.height));//TMModelNode
        root.setPaiLevel(null);
        root.setRaiz(true);
        root.setLabel("ROOT");

        modelTree = createTree(itensHierarquia, itemTamanho, itemLegenda);
//        printTree(model, "\t");
        treeMap = new TreeMap(modelTree);

        TMModel_Size cSize = new TMModel_Size();
        TMModel_Draw cDraw = new TMModel_Draw();

        this.view = treeMap.getView(cSize, cDraw);

        this.view.getAlgorithm().setBorderSize(15);
        this.view.setBounds(rect);
        TMOnDrawFinished listener = (new TMOnDrawFinished() {
            @Override
            public void onDrawFinished(String t) {
                teste(t);
            }
        });
        TMThreadModel.listener = listener;
        TMUpdaterConcrete.listener = listener;

    }

    public void teste(String t) {
        TMNodeModel m = this.view.getAlgorithm().getRoot();//TMNodeMode
        if (m != null) {
            Rectangle area = m.getArea();
            System.out.println("veio daqui: " + t);
            System.out.println("x:" + m.getArea().x + "y:" + m.getArea().y + "w:" + m.getArea().width + "h:" + m.getArea().height);
        }
    }

    public void setHierarchy(String[] hierarquia) {
        for (TreeMapItem treeMapItem : manipulador.getItensTreemap()) {
            hierarquiaFila.addAll(Arrays.asList(hierarquia));
            root.inserirFilhos(hierarquiaFila, treeMapItem, root);
        }
    }

    public void setSizeColumn(Coluna column) {
        this.root.setSize(column);
        this.root.organize();
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
                } else {
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
        System.out.println(appender + nodo.getLabel() + " - " + nodo.getSize());
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
