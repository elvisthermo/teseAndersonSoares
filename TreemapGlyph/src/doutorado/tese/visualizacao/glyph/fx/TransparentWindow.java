package doutorado.tese.visualizacao.glyph.fx;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import static javafx.stage.StageStyle.TRANSPARENT;


public class TransparentWindow extends Application {
 
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Group  root  =  new  Group(); 
            Scene  scene  =  new  Scene(root);
            Label lbl = new Label("LABEL");
            Circle n =  new Circle(200,150,50);
            VBox p = new VBox(lbl);
 
            //make the background of the label white and opaque
            lbl.setStyle("-fx-background-color: rgba(255, 255, 255, 1);");
 
            //add some borders to visualise the element' locations
            lbl.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, null, null)));
            p.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
 
            
            
            
            

             root.getChildren().add(n);
             stage.setScene(scene);
 
 
            p.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        
            scene.setFill(null);
           
            stage.initStyle(TRANSPARENT);
 
            stage.setWidth(500);
            stage.setHeight(500);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}