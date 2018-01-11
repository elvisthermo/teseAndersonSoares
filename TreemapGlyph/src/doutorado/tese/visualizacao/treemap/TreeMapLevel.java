/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.treemap;

import doutorado.tese.io.ManipuladorArquivo;
import doutorado.tese.util.Coluna;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Simple Map Model
 *
 */
public class TreeMapLevel extends TreeMapNode {

    double totalArea;    

    public TreeMapLevel(Rect rect) {
        this.bounds = rect;
        totalArea = bounds.w * bounds.h;
        itemsFilhos = new ArrayList<>();
        bordaInterna = rect;
    }

    /**
     * Creates a Map Model instance based on the relative size of the mappable
     * itemsFilhos and the frame size.
     *
     * @param valoresItens Items representing relative areas
     * @param width Width of the display area
     * @param height Height of the display area
     */
    public TreeMapLevel(int[] valoresItens, int width, int height) {
        this.itemsFilhos = new ArrayList<>(valoresItens.length);
        totalArea = width * height;
        double sum = IntStream.of(valoresItens).sum();

        for (int i = 0; i < itemsFilhos.size(); i++) {
            itemsFilhos.add(new TreeMapItem(totalArea / sum * valoresItens[i], 0));
//            System.out.println(itemsFilhos[i]);
        }
    }
    /**
     * Creates a Map Model instance based on the relative size of the mappable
     * itemsFilhos and the frame size.
     *
     * @param filhosItens itens filhos desse MapLevel
     * @param bounds
     * @param raiz
     */
    public TreeMapLevel(TreeMapNode[] filhosItens, Rect bounds, boolean raiz) {
        setItemsFilhos(itemsFilhos);
        this.bounds = bounds;
        totalArea = bounds.w * bounds.h;
        this.raiz = raiz;
    }

    @Override
    public void inserirFilhos(Queue<String> hierarquia, TreeMapNode item, TreeMapNode pai) {
        TreeMapNode treeMapNode = null;
        if (hierarquia.isEmpty()) {
            pai.getItemsFilhos().add(item);
            item.setPaiLevel(pai);
        } else {
            for (TreeMapNode filho : pai.getItemsFilhos()) {
                if (filho.label.equalsIgnoreCase(item.getMapaDetalhesItem().get(ManipuladorArquivo.getColuna(hierarquia.peek())))) {
                    treeMapNode = filho;
                    break;
                }
            }
            if (treeMapNode == null) {
                treeMapNode = new TreeMapLevel(bounds);
                treeMapNode.label = item.getMapaDetalhesItem().get(ManipuladorArquivo.getColuna(hierarquia.peek()));
                pai.getItemsFilhos().add(treeMapNode);
                treeMapNode.setPaiLevel(pai);
            }
            if (!hierarquia.isEmpty()) {
                hierarquia.remove();
            }
            inserirFilhos(hierarquia, item, treeMapNode);
        }
    }

    public void setItemsFilhos(ArrayList<TreeMapNode> itemsFilhos) {
        this.itemsFilhos = itemsFilhos;
    }

    @Override
    public ArrayList<TreeMapNode> getItemsFilhos() {
        return itemsFilhos;
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
        for (TreeMapNode filhosIten : itemsFilhos) {
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
            g.drawString(level.label, configLegenda.x, configLegenda.y);
        }
    }

    private Point configLegenda(TreeMapLevel level, Graphics2D g2d) {
        int fontSize = 14;
        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
        int[] tamanhoTexto = mensurarTexto(g2d, this.label);

        if (tamanhoTexto[0] >= level.bounds.w) {
//            System.out.println(level.label+" - wTexto: "+tamanhoTexto[0]+" > "+level.bounds.w);
            int[] conf = verifyFontCanvasSize(g2d, this.label, tamanhoTexto[0], (int) Math.round(this.getBounds().w), fontSize);
            tamanhoTexto[0] = conf[0];
            fontSize = conf[1];
        }
        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
        tamanhoTexto = mensurarTexto(g2d, this.label);

        int xTexto = (int) ((level.bounds.w / 2) + level.bounds.x) - (tamanhoTexto[0] / 2);
        int yTexto = (int) level.bounds.y + 15;//(int) Math.round(this.getBordaInterna().y) - 4;
        return new Point(xTexto, yTexto);
    }

    private int[] mensurarTexto(Graphics2D g2d, String texto) {
        int lWidth = (int) Math.round(g2d.getFontMetrics().getStringBounds(texto, g2d).getCenterX());
        int lHeight = (int) Math.round(g2d.getFontMetrics().getStringBounds(texto, g2d).getCenterY());
        return new int[]{lWidth, lHeight};
    }

    @Override
    public void paint(Graphics2D g) {
        //desenhar nodo level
        g.drawRect((int) Math.round(this.bounds.x), (int) Math.round(this.bounds.y),
                (int) Math.round(this.bounds.w) - 1, (int) Math.round(this.bounds.h) - 1);

//        redefinirBorda();
        g.setColor(Color.black);
        //desenha a borda interna
        System.out.println("Label: "+this.getLabel()+"\t"+getBordaInterna());
        g.drawRect((int) Math.round(getBordaInterna().x), (int) Math.round(getBordaInterna().y),
                (int) Math.round(getBordaInterna().w), (int) Math.round(getBordaInterna().h));
        g.drawString("("+(int) Math.round(getBordaInterna().x)+","+(int) Math.round(getBordaInterna().y)+")", 
                (int) Math.round(getBordaInterna().x), (int) Math.round(getBordaInterna().y));
//        calcularPosicaoLabel(g, this);

        for (TreeMapNode itemsFilho : itemsFilhos) {
            itemsFilho.paint(g);
        }
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
