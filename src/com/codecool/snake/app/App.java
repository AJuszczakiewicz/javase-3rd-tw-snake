package com.codecool.snake.app;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import com.codecool.snake.controller.GameController;
import com.codecool.snake.controller.FrameControlLoop;
import com.codecool.snake.model.GameModel;
import com.codecool.snake.view.GameView;

public class App extends Application {


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Snake");

        GameView view = new GameView(primaryStage);
        GameModel model = new GameModel();
        model.addObserver(view);

        GameController gameController = new GameController(model, view);

        FrameControlLoop gameLoop = new FrameControlLoop(gameController);

        primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> gameLoop.stop());

        gameLoop.setDaemon(true);
        gameLoop.start();

    }

}
