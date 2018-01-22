/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.fx;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author thermo
 */
public class TrianguloGlyph {
    /**
     * Specify the SVG path to create a triangulo glyph
     * @return 
     */    
    public static SVGPath createSVG(){
        SVGPath svgPath = new SVGPath();

        String path = "M 100 100 L 300 100 L 200 300 z";

        //Setting the SVGPath in the form of string 
        svgPath.setContent(path);
        return svgPath;
    }
    
}
