/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.gui;

import doutorado.tese.visualizacao.treemap.Rect;
import doutorado.tese.visualizacao.treemap.TreeMapLayout;
import doutorado.tese.visualizacao.treemap.TreeMapLevel;
import doutorado.tese.visualizacao.treemap.TreeMapNode;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * Simple application for testing the algorithm
 *
 */
public class TreemapTest extends Frame {

    TreeMapLayout algorithm;
    TreeMapLevel mapModel;

    public TreemapTest() {
        int w = 800;
        int h = 600;

        Rect bounds = new Rect(0, 0, w, h);
        algorithm = new TreeMapLayout();
        mapModel = new TreeMapLevel(new int[]{6, 6, 4, 3, 2, 2, 1}, w, h);
//        algorithm.layoutSquarifiedTreemap(mapModel, bounds);

        setBounds(100, 100, w, h);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        List<TreeMapNode> items = mapModel.getChildren();
        Rect rect;

        g.setColor(Color.black);

        for (int i = 0; i < items.size(); i++) {
            rect = items.get(i).getBounds();
            int a = (int) rect.x;
            int b = (int) rect.y;
            int c = (int) rect.w;
            int d = (int) rect.h;
            g.drawRect(a, b, c, d);
        }
    }

    static public void main(String[] args) {
        new TreemapTest();
    }
}
