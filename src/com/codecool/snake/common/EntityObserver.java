package com.codecool.snake.common;

import com.codecool.snake.model.AbstractGameEntity;

public interface EntityObserver {
    void updateOnChange(AbstractGameEntity changedEntity);
}
