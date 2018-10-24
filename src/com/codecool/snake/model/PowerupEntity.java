package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;

public class PowerupEntity extends AbstractGameEntity {
    public PowerupEntity() {
        super();

        setEntityType(GameEntityType.POWERUP);
    }
}
