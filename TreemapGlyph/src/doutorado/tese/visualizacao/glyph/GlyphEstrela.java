/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.glyph;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

/**
 *
 * @author thermo
 */
public class GlyphEstrela {
    public float setx;
    public float sety;
    
    Group root ;

    public GlyphEstrela(float x, float y) {
    this.setx = x;
    this.sety = y;
    
     SVGPath svgPath = new SVGPath();       
       
      String path = "M 100,10 L 40,198 L 190,78 L 10,78 L160,198 Z";
      
      Translate translate = new Translate();       
      
     
      translate.setX(setx); 
      translate.setY(sety); 
       
      svgPath.getTransforms().addAll(translate);
      
      Scale scale = new Scale();  
      scale.setX(0.3); 
      scale.setY(0.3); 
      
       
      scale.setPivotX(50); 
      scale.setPivotY(50); 
       
      svgPath.setFill(Color.web("#f0f8ff",1.0));
      svgPath.setStrokeWidth(2);
      svgPath.setStroke(Color.DARKSLATEBLUE);
            
           
      svgPath.setContent(path);  
      svgPath.getTransforms().addAll(scale); 
      root = new Group(svgPath); 
               
      
    
    }
    //<path xmlns="http://www.w3.org/2000/svg" id="path66" d="m 51.315749,245.95152 -1.839637,24.07046 z" style="fill:none;stroke:#000000;stroke-width:0.26458332px;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1"/>
   // d="m 51.315749,245.95152 -1.839637,24.07046 z"
    
   //100,10 40,198 190,78 10,78 160,198
    public Group montar() {
        return root;

    }

    
    
}
