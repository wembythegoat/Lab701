/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7real;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

//  GitHub link: https://github.com/wembythegoat/Lab701.git

/**
 *
 * @author 2472557
 */
public class Lab7Real extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(50, 50, 400, 400);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        
        Circle circle = new Circle(50, 50, 25);
        circle.setFill(Color.BLACK);
        circle.setStroke(Color.BLACK);
        circle.setTranslateX(100);
        circle.setTranslateY(100);
        
        pane.getChildren().addAll(circle, rectangle);
        
        Path path = new Path();
        path.getElements().add(new MoveTo(50, 50)); // M
        path.getElements().add(new LineTo(450, 50)); // N
        path.getElements().add(new LineTo(450, 450)); // P
        path.getElements().add(new LineTo(50, 450)); // Q
        path.getElements().add(new LineTo(50, 50)); // M

        PathTransition pt = new PathTransition(Duration.seconds(8), path, circle);
        pt.setCycleCount(1);
        pt.setDuration(Duration.seconds(8));
        pt.setPath(path);
        pt.setNode(circle);
        //pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play(); // Start animation;

        Ellipse ellipse = new Ellipse(250, 250, 50, 25);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);
        pane.getChildren().addAll(ellipse);
        
        Button start = new Button("Start");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");

        Scene scene = new Scene(pane, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Path animation");
        stage.show();
    }

}




