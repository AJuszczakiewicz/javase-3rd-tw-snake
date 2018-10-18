package com.codecool.snake.common;

import com.codecool.snake.model.AbstractGameEntity;

public interface ModelObserver {
    void updateOnSpawn(AbstractGameEntity spawnEntity);
    void updateOnDestroy(AbstractGameEntity destroyedEntity);
}
