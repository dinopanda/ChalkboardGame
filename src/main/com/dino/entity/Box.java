package main.com.dino.entity;

import main.com.dino.entity.properties.Direction;
import main.com.dino.grid.Grid;

/**
 * This class represents a Box that can either be movable or immovable.
 */
public class Box extends Icon {
    private static final String BOX_ICON_PATH = "block.png";
    private static final String MOVABLE_BOX_ICON_PATH = "movableBlock.png";

    /**
     * Constructors.
     */
    /**
     * Constructor for immovable box.
     */
    public Box(Grid grid, int row, int col) {
        super (grid, row, col, BOX_ICON_PATH);
    }

    /**
     * Constructor for movable box.
     */
    public Box(Grid grid, int row, int col, boolean isMovable) {
        super (grid, row, col, MOVABLE_BOX_ICON_PATH,
                Direction.DOWN, isMovable, false);
    }
}
