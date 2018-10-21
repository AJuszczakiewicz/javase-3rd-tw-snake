package com.codecool.snake.app;

import com.codecool.snake.view.GameView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameView view = new GameView(primaryStage);
    }
}
