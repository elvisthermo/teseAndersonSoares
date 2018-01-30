package doutorado.tese.visualizacao.glyph.fx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
 
public class PieChartGlphy extends Application {
 
    
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("teste exemplo");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("variavel_1", 25),
                new PieChart.Data("variavel_2", 25),
                new PieChart.Data("variavel_3", 25),
                new PieChart.Data("variavel_4", 25));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}