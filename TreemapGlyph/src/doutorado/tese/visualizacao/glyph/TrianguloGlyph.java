package doutorado.tese.visualizacao.glyph;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;


public class TrianguloGlyph {
    
    public static float width;
    public static float height;
    public static float x;
    public static float y;

    public TrianguloGlyph(float width, float height, float x, float y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;      
    }

    public static SVGPath createSVG(float width, float height, float x, float y){
        
        Scale scale = new Scale();

        scale.setX(0.3);
        scale.setY(0.3);
        
        Translate translate = new Translate();
        translate.setX(x); 
        translate.setY(y); 
        
        
        SVGPath svgPath = new SVGPath();

        String path = "M 100 100 L 300 100 L 200 300 z";
        
        scale.setPivotX(width); 
        scale.setPivotY(height); 
        svgPath.getTransforms().addAll(scale); 
        svgPath.getTransforms().addAll(translate);
        svgPath.setContent(path);
        return svgPath;
    }
    
}
