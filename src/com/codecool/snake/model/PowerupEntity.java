package com.codecool.snake.model;

import com.codecool.snake.model.common.GameEntityType;

class PowerupEntity extends Entity {
    PowerupEntity() {
        super();
        setEntityType(GameEntityType.POWERUP);
    }
}
