package com.codecool.snake.view;

import com.codecool.snake.common.EntityObserver;
import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ModelObserver;
import com.codecool.snake.controller.Controller;
import com.codecool.snake.model.AbstractGameEntity;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.HashMap;


public class GameView extends Pane implements ModelObserver {
    private static HashMap<GameEntityType, Image> costumes;
    private HashMap<String, Group> entitiesOnScene = new HashMap<>();
    private Scene scene;
    private int WIDTH = 1000;
    private int HEIGHT = 700;

    public GameView(Stage primaryStage){
        attachViewToStage(primaryStage);
        loadCostumes();

    }


    @Override
    public void updateOnSpawn(AbstractGameEntity spawnEntity) {
        Group entity = new Group();
        switch (spawnEntity.getEntityType()){
            case ENEMY:
                entity = new EntityView(costumes.get(GameEntityType.ENEMY));
                break;
            case POWERUP:
                entity = new EntityView(costumes.get(GameEntityType.POWERUP));
                break;
            case SNAKE:
                entity = new SnakeView(costumes.get(GameEntityType.SNAKE), costumes.get(GameEntityType.SNAKETAIL));
                break;
        }

        spawnEntity.addObserver((EntityObserver) entity);
        entitiesOnScene.put(spawnEntity.toString(), entity);
        getChildren().add(entity);
    }

    @Override
    public void updateOnDestroy(AbstractGameEntity destroyedEntity) {
        Group entity = entitiesOnScene.get(destroyedEntity.toString());

        entitiesOnScene.remove(entity);
        getChildren().remove(entity);
    }

    private void attachViewToStage(Stage stage){
        scene = new Scene(this, WIDTH, HEIGHT);

        stage.setScene(scene);
        stage.show();
//        stage.setFocused(true);
        stage.requestFocus();
    }

    public void attachInputToController(Controller controller){
        //TODO
    }

    private void loadCostumes(){
        costumes = new HashMap<>();
        costumes.put(GameEntityType.SNAKE, new Image("snake_head.png"));
        costumes.put(GameEntityType.ENEMY, new Image("simple_enemy.png"));
        costumes.put(GameEntityType.POWERUP, new Image("powerup_berry.png"));
        costumes.put(GameEntityType.SNAKETAIL, new Image("snake_body.png"));
    }
}
