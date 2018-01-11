/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.treemap;

public class Rect {
    public double x, y, w, h;
//    public String label;

    public Rect() {
        this(0,0,1,1);
    }

    public Rect(Rect r) {
        setRect(r.x, r.y, r.w, r.h);
    }

    public Rect(double x, double y, double w, double h) {
        setRect(x, y, w, h);
    }

    public double aspectRatio() {
        return Math.max(w/h, h/w);
    }

    public void setRect(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "X: "+(int) Math.round(x)+"\tY: "+(int) Math.round(y)+"\tW: "+(int) Math.round(w)+"\tH: "+(int) Math.round(h);
    }
    
    
}