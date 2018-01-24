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

/**
 *
 * @author Anderson Soares
 */
public class ManagerGlyph {
    /**
     * This method is invoked on the JavaFX thread.
     * Responsable for return the JFXPanel with glyphs
     * @param fxPanel
     * @return The JFXPanel with glyphs
     */
    public static JFXPanel getPanelFx(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
        return fxPanel;
    }
    
    private static Scene createScene() {
        //Creating a Group object  
        Group root = new Group();
        root.getChildren().add(TrianguloGlyph.createSVG());
        root.getChildren().add(QuadradoGlyph.createSVG());
        Scene scene = new Scene(root, Color.ALICEBLUE);
        
        return scene;
    }
}
