/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import doutorado.tese.visualizacao.treemap.Rect;
import java.awt.Graphics;

/**
 *
 * @author Anderson
 */
public class Estrela {

    private int[] xPoints;
    private int[] yPoints;
    private Rect rect;    

    public Estrela(Rect r) {
        this.rect = r;
    }

    public void paint(Graphics g) {
        montarEstrela();
        g.drawPolygon(xPoints, yPoints, xPoints.length);
    }

    public void montarEstrela() {
        int width = (int) Math.round(rect.w)- 1;
        int height = (int) Math.round(rect.h) - 1;

        int halfWidth = width / 2;
        int halfHeight = height / 2;
        int innerWidth = width / 8;
        int innerHeight = height / 8;
                
        halfWidth += rect.x;
        halfHeight += rect.y;

        xPoints = new int[9];
        yPoints = new int[9];

        xPoints[0] = halfWidth;
        yPoints[0] = (int)Math.round(rect.y);

        xPoints[1] = halfWidth - innerWidth;
        yPoints[1] = halfHeight - innerHeight;

        xPoints[2] = (int)Math.round(rect.x);
        yPoints[2] = halfHeight;

        xPoints[3] = halfWidth - innerWidth;
        yPoints[3] = halfHeight + innerHeight;

        xPoints[4] = halfWidth;
        yPoints[4] = height + (int)Math.round(rect.y);

        xPoints[5] = halfWidth + innerWidth;
        yPoints[5] = halfHeight + innerHeight;

        xPoints[6] = width + (int)Math.round(rect.x);
        yPoints[6] = halfHeight;

        xPoints[7] = halfWidth + innerWidth;
        yPoints[7] = halfHeight - innerHeight;

        xPoints[8] = halfWidth;
        yPoints[8] = (int)Math.round(rect.y);
    }
}
