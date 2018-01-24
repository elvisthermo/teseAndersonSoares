/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.treemap;

import doutorado.tese.io.ManipuladorArquivo;
import doutorado.tese.util.Coluna;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Simple Map Model
 *
 */
public class TreeMapLevel extends TreeMapNode {

    double totalArea;

    public TreeMapLevel(Rectangle rect) {
        this.bounds = rect;
        totalArea = bounds.width * bounds.height;
        children = new ArrayList<>();
        bordaInterna = rect;
    }

    public TreeMapLevel() {
        children = new ArrayList<>();
    }

    @Override
    public void inserirFilhos(Queue<String> hierarquia, TreeMapNode item, TreeMapNode pai) {
        TreeMapNode treeMapNode = null;
        if (hierarquia.isEmpty()) {
            pai.getChildren().add(item);
            item.setPaiLevel(pai);
        } else {
            for (TreeMapNode filho : pai.getChildren()) {
                if (filho.getLabel().equalsIgnoreCase(item.getMapaDetalhesItem().get(ManipuladorArquivo.getColuna(hierarquia.peek())))) {
                    treeMapNode = filho;
                    break;
                }
            }
            if (treeMapNode == null) {
                treeMapNode = new TreeMapLevel(bounds);
//                treeMapNode = new TreeMapLevel();
                treeMapNode.setLabel(item.getMapaDetalhesItem().get(ManipuladorArquivo.getColuna(hierarquia.peek())));
                pai.getChildren().add(treeMapNode);
                treeMapNode.setPaiLevel(pai);
            }
            if (!hierarquia.isEmpty()) {
                hierarquia.remove();
            }
            inserirFilhos(hierarquia, item, treeMapNode);
        }
    }

    /**
     * @return the folha
     */
    public boolean isFolha() {
        return !isHasChildren();
    }

    /**
     *
     * @param colunaTamanho
     */
    @Override
    public void setSize(Coluna colunaTamanho) {
        double sum = 0;
        for (TreeMapNode filhosIten : children) {
            filhosIten.setSize(colunaTamanho);
            sum += filhosIten.getSize();
            filhosIten.setPaiLevel(this);
            filhosIten.setDepth(this.getDepth() + 1);
        }
        this.size = sum;
    }

    @Override
    public double getSize() {
        return size;
    }

    private void calcularPosicaoLabel(Graphics2D g, TreeMapLevel level) {
        Point configLegenda = null;
        if (!level.getLabel().equalsIgnoreCase("")) {
            configLegenda = configLegenda(level, g);
            g.drawString(level.getLabel(), configLegenda.x, configLegenda.y);
        }
    }

    private Point configLegenda(TreeMapLevel level, Graphics2D g2d) {
        int fontSize = 14;
        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
        int[] tamanhoTexto = mensurarTexto(g2d, this.getLabel());

        if (tamanhoTexto[0] >= level.bounds.width) {
            int[] conf = verifyFontCanvasSize(g2d, this.getLabel(), tamanhoTexto[0], (int) Math.round(this.getBounds().width), fontSize);
            tamanhoTexto[0] = conf[0];
            fontSize = conf[1];
        }
        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
        tamanhoTexto = mensurarTexto(g2d, this.getLabel());

        int xTexto = (int) ((level.bounds.width / 2) + level.bounds.x) - (tamanhoTexto[0] / 2);
        int yTexto = (int) level.bounds.y + 15;//(int) Math.round(this.getBordaInterna().y) - 4;
        return new Point(xTexto, yTexto);
    }

    private int[] mensurarTexto(Graphics2D g2d, String texto) {
        int lWidth = (int) Math.round(g2d.getFontMetrics().getStringBounds(texto, g2d).getCenterX());
        int lHeight = (int) Math.round(g2d.getFontMetrics().getStringBounds(texto, g2d).getCenterY());
        return new int[]{lWidth, lHeight};
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
