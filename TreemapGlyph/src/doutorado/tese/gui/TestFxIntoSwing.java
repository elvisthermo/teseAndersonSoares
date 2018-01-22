package doutorado.tese.gui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TestFxIntoSwing {
    private static void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Swing and JavaFX");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(250, 350);
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
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    public static JFXPanel getPanelFx(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        System.out.println("Recebendo o fxPanel");
        Scene scene = createScene();
        fxPanel.setScene(scene);
        return fxPanel;
    }
    
    private static Scene createScene() {
        System.out.println("Criando a cena...");
        SVGPath svgPath = new SVGPath();

        String path = "M 100 100 L 300 100 L 200 300 z";

        //Setting the SVGPath in the form of string 
        svgPath.setContent(path);

        //Creating a Group object  
//        Group root = new Group(svgPath);
        Group root = new Group();
        root.getChildren().add(svgPath);
        Scene scene = new Scene(root, Color.ALICEBLUE);
        
        return scene;
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