package com.example.fx_demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PsychedelicMickeyFX extends Application {
    @Override // Override method of start in the Application class
    public void start(Stage primaryStage) {
        // Creates the pane
        Pane pane = new Pane();

        // Create a few circles and set their properties
        Circle circle = new Circle();
        circle.setCenterX(200);
        circle.setCenterY(200);
        circle.setRadius(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.ORANGE);

        Circle circle1 = new Circle();
        circle1.setCenterY(95);
        circle1.setCenterX(95);
        circle1.setRadius(50);
        circle1.setStroke(Color.BLUE);
        circle1.setFill(Color.GREEN);

        Circle circle2 = new Circle();
        circle2.setCenterX(305);
        circle2.setCenterY(95);
        circle2.setRadius(50);
        circle2.setFill(Color.RED);
        circle2.setStroke(Color.PURPLE);
        pane.getChildren().addAll(circle1, circle2, circle); // Add circles to the pane

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
        RadialGradient g
                = RadialGradient.valueOf("radial-gradient(center 50% 50%, radius 50%,  cyan, violet 75%, magenta)");
        scene.setFill(g);
        primaryStage.setTitle("ShowCircleCentered"); // Set the stage title
        primaryStage.setResizable(false);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
