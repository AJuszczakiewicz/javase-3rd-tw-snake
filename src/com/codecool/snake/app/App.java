package com.codecool.snake.app;
import com.codecool.snake.controller.Controller;
import com.codecool.snake.controller.FrameControlLoop;


import com.codecool.snake.model.GameModel;
import com.codecool.snake.view.GameView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class App extends Application{
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> System.out.println("Hello World!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);


        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        GameModel model = new GameModel();
        GameView view = new GameView();
        Controller controller = new Controller(model, view);
        FrameControlLoop gameLoop = new FrameControlLoop(controller);

        primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> gameLoop.stop());
        (new Thread(gameLoop)).start();

    }


}