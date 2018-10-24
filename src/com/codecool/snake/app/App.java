package com.codecool.snake.app;
import com.codecool.snake.controller.Controller;
import com.codecool.snake.controller.FrameControlLoop;


import com.codecool.snake.model.GameModel;
import com.codecool.snake.view.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class App extends Application {
public class App extends Application{
    int WIDTH = 800;
    int HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Snake");
        StackPane root = new StackPane();

        GameModel model = new GameModel();
        GameView view = new GameView(primaryStage);
        Controller controller = new Controller(model, view);
        FrameControlLoop gameLoop = new FrameControlLoop(controller);

        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();

        primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> gameLoop.stop());
        (new Thread(gameLoop)).start();

    }


}