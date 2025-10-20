/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7real;

import javafx.application.Application;
import javafx.stage.Stage;

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
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        
        Scene scene = new Scene(grid, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Yep");
        stage.show();
    }
    
}

