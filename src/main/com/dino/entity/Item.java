package main.com.dino.entity;

import main.com.dino.grid.Grid;

/**
 * This class represent a generic Item that should be collectable.
 */
public class Item extends Icon {
    private static final String ITEM_ICON_PATH = "block.png";

    /**
     * Constructors.
     */
    /**
     * Constructor for immovable item.
     */
    public Item(Grid grid, int row, int col) {
        super (grid, row, col, true, ITEM_ICON_PATH);
    }
}
