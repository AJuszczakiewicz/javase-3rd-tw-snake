package com.codecool.snake.view;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ModelObserver;
import com.codecool.snake.controller.Controller;
import com.codecool.snake.model.AbstractGameEntity;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class GameView extends Pane implements ModelObserver {
    private static HashMap<GameEntityType, Image> costumes;
    private HashMap<String, ImageView> entitiesOnScene;
    private Scene scene;

    public GameView(Stage primaryStage){
        attachViewToStage(primaryStage);
    }


    @Override
    public void updateOnSpawn(AbstractGameEntity spawnEntity) {
        switch (spawnEntity.getGameEntityType()){
            case ENEMY:
                EntityView enemy = new EntityView(costumes.get(GameEntityType.ENEMY));
                entitiesOnScene.put(spawnEntity.toString(), enemy);
                getChildren().add(enemy);
                break;
            case POWERUP:
                EntityView powerup = new EntityView(costumes.get(GameEntityType.POWERUP));
                entitiesOnScene.put(spawnEntity.toString(), powerup);
                getChildren().add(powerup);
                break;
            case SNAKE:
                SnakeView snake = new SnakeView(costumes.get(GameEntityType.SNAKE), costumes.get(GameEntityType.SNAKETAIL));
                entitiesOnScene.put(spawnEntity.toString(), snake);
                getChildren().add(snake);
        }
    }

    @Override
    public void updateOnDestroy(AbstractGameEntity destroyedEntity) {
        ImageView entity = entitiesOnScene.get(destroyedEntity.toString());
        entitiesOnScene.remove(entity);
        getChildren().remove(entity);
    }

    public void attachViewToStage(Stage stage){
        scene = new Scene(this, 1000, 700);

        stage.setScene(scene);
        stage.show();
    }

    public void attachInputToController(Controller controller){
        //TODO
    }

    private static void loadCostumes(){
        costumes = new HashMap<>();
        costumes.put(GameEntityType.SNAKE, new Image("snake_head.png"));
        costumes.put(GameEntityType.ENEMY, new Image("simple_enemy.png"));
        costumes.put(GameEntityType.POWERUP, new Image("powerup_berry.png"));
        costumes.put(GameEntityType.SNAKETAIL, new Image("snake_body.png"));
    }
}
