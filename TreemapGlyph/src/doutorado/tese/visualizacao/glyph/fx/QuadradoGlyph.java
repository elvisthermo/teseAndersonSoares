/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph.fx;

import javafx.scene.shape.SVGPath;

/**
 *
 * @author Anderson Soares
 */
public class QuadradoGlyph {
    /**
     * Specify the SVG path to create a triangulo glyph
     * @return 
     */    
    public static SVGPath createSVG(){
        SVGPath svgPath = new SVGPath();

        String path = "M 0 0 L 50 100 L 50 300 z";

        //Setting the SVGPath in the form of string 
        svgPath.setContent(path);
        return svgPath;
    }
}
