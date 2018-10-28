package com.codecool.snake.model;

import com.codecool.snake.model.common.GameEntityType;

class EnemyEntity extends Entity {
    EnemyEntity(){
        super();
        setEntityType(GameEntityType.ENEMY);
    }
}
