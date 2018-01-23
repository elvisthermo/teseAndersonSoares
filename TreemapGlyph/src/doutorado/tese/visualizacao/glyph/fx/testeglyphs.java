package doutorado.tese.visualizacao.glyph.fx;

import doutorado.tese.visualizacao.glyph.GlyphEstrela;
import doutorado.tese.visualizacao.glyph.Glyphs;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class testeglyphs {

    private static void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Glyphs prototipo");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(500, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });
    }

    private static void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }
    
    private static Scene createScene() {
        Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root);


        Glyphs glyph01 = new Glyphs(20,50,50,50,"1");
        Glyphs glyph02 = new Glyphs(80,50,50,50,"2");
        Glyphs glyph03 = new Glyphs(150,50,50,50,"3");
        Glyphs glyph04 = new Glyphs(210,50,50,50,"4");
     
        GlyphEstrela star = new GlyphEstrela(280,10);
        
        root.getChildren().add(glyph01.montar());
        root.getChildren().add(glyph02.montar());
        root.getChildren().add(glyph03.montar());
        root.getChildren().add(glyph04.montar());  
        root.getChildren().add(star.montar());  

        
         

        return (scene);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}