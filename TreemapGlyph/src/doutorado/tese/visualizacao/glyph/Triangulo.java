/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import javax.swing.JLabel;

/**
 *
 * @author Elvis (LABVIS)
 */
public class Triangulo {
    
    public class Rect extends JLabel{
    public float widht;
    public float height;
    public float x;
    public float y;

    public Rect(float widht, float height, float x, float y) {
    
        this.widht = widht;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    
     @Override
    public void paint(Graphics g) {
       float x = 100,y = 200;
       AffineTransform tx1 = new AffineTransform();
        tx1.translate(200, 50);
        tx1.scale(0.5, 0.5);
        
        
        
       Graphics2D g2d = (Graphics2D) g;
       
                  
        g2d.setTransform(tx1);
        
       Polygon p = new Polygon();
		g.setColor(Color.red);
		p.addPoint(0, 50);
		p.addPoint(25, 0);
		p.addPoint(50, 50);
		g.fillPolygon(p);
        
        g2d.dispose();
    }
      public void DrawingRect(Graphics g) {

            
       
    }
    
    
    
    
     
                
        
}
}
