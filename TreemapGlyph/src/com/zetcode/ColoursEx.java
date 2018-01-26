package com.zetcode;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {
        
    public void doDrawing(Graphics g) {

        float x = 100, y = 200;
        AffineTransform tx1 = new AffineTransform();
        tx1.translate(80, 50);
        
        tx1.scale(0.5, 0.5);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setTransform(tx1);

        Polygon p = new Polygon();
        g.setColor(Color.PINK);
        p.addPoint(200,50);
        p.addPoint(300,50);
        p.addPoint(350, 150);
        p.addPoint(300, 250);
        p.addPoint(200, 250);

        
        p.addPoint(150, 150);


     
        
    

        
        
        g.fillPolygon(p);

        
        

        
        
        
         
        
      
        
    }

    @Override
    public void paintComponent(Graphics g) {
                
        super.paintComponent(g);
        doDrawing(g);
    }           
}

public class ColoursEx extends JFrame {

    public ColoursEx() {

        initUI();
    }

    private void initUI() {
        
        add(new Surface());
        
        setTitle("Colours");
        setSize(360, 300);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ColoursEx ex = new ColoursEx();
                ex.setVisible(true);
            }
        });
    }
}