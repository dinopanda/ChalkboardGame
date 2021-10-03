package main.com.dino.grid;

import main.com.dino.entity.GridEntity;
import main.com.dino.entity.properties.Direction;

/**
 * Interface for all Grids.
 */
public interface IGrid {
    public boolean move(GridEntity gridEntity, Direction direction);
}
