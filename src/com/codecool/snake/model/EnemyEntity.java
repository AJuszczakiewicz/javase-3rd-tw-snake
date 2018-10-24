package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;

public class EnemyEntity extends AbstractGameEntity {
    public EnemyEntity(){
        super();

        setEntityType(GameEntityType.ENEMY);
    }
}
