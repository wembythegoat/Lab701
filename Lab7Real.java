/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7real;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
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
        VBox root = new VBox(50);
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(50, 50, 400, 400);
        rectangle.setStroke(Color.RED);
        rectangle.setFill(null);
        
        Circle circle = new Circle(50, 50, 25);
        circle.setFill(Color.BLACK);
        circle.setStroke(Color.BLACK);
        circle.setTranslateX(100);
        circle.setTranslateY(100);
        
        Path path = new Path();
        path.getElements().add(new MoveTo(50, 50)); // M
        path.getElements().add(new LineTo(450, 50)); // N
        path.getElements().add(new LineTo(450, 450)); // P
        path.getElements().add(new LineTo(50, 450)); // Q
        path.getElements().add(new LineTo(50, 50)); // M

        PathTransition pt = new PathTransition();
        pt.setCycleCount(1);
        pt.setDuration(Duration.seconds(20));
        pt.setPath(path);
        pt.setNode(circle);

        Ellipse ellipse = new Ellipse(250, 250, 50, 25);
        ellipse.setFill(Color.DARKBLUE);
        pane.getChildren().addAll(ellipse, circle, rectangle);
        
        FadeTransition fade = new FadeTransition(Duration.seconds(3), ellipse);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setAutoReverse(true);
        fade.setCycleCount(2);
        
        ScaleTransition scale = new ScaleTransition(Duration.seconds(2), ellipse);
        scale.setToX(2.0);
        scale.setToY(2.0);
        scale.setAutoReverse(true);
        scale.setCycleCount(2);
        
        RotateTransition rotate = new RotateTransition(Duration.seconds(4), ellipse);
        rotate.setFromAngle(0.0);
        rotate.setByAngle(360.0);
        rotate.setCycleCount(1);
        
        TranslateTransition move = new TranslateTransition(Duration.seconds(2.75), ellipse);
        move.setToY(-100);
        move.setAutoReverse(true);
        move.setCycleCount(2);
        
        SequentialTransition seq = new SequentialTransition(fade, scale, rotate, move);
        
        Button start = new Button("Start");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");
        
        start.setOnAction(e -> {
           pt.play();
           seq.play();
        });
        
        reset.setOnAction(e -> {
           pt.stop();
           pt.jumpTo(Duration.ZERO);
           pt.play();
           
           ellipse.setScaleX(1);
           ellipse.setScaleY(1);
           
           ellipse.setRotate(0);
           
           ellipse.setTranslateX(0);
           ellipse.setTranslateY(0);
           
           seq.playFromStart();
        });
        
        exit.setOnAction(e -> {
           pt.pause(); 
           seq.pause();
        });
        
        HBox hbox = new HBox(15);
        hbox.getChildren().addAll(start, reset, exit);
        
        root.getChildren().addAll(pane, hbox);

        hbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 575);
        stage.setScene(scene);
        stage.setTitle("Path animation");
        stage.show();
    }

}





