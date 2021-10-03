package main.com.dino.entity;

import main.com.dino.entity.properties.Direction;
import main.com.dino.entity.properties.Stats;
import main.com.dino.grid.Grid;

/**
 * Robot class controllable by:
 * - code
 * - input
 *   - keyboard
 *   - mouse
 */
public class Robot extends Icon {
    private static final String STITCH_ROBOT_ICON_PATH = "robotStitch.png";

    private final Stats stats;

    /**
     * Constructors.
     */
    public Robot(String name, Grid grid, int row, int col) {
        super(name, grid, row, col,
                STITCH_ROBOT_ICON_PATH, Direction.DOWN, true, true);
        this.stats = new Stats(100, 100, 100, 100, 100);
    }

    public Robot(Grid grid, int row, int col) {
        super(grid, row, col,
                STITCH_ROBOT_ICON_PATH, Direction.DOWN, true, true);
        this.stats = new Stats(100, 100, 100, 100, 100);
    }

    public String toString() {
        String str = "Robot["
                + "\n\tname: " + this.getName()
                + "\n\trowLoc: " + this.getRow()
                + "\n\tcolLoc: " + this.getCol()
                + "\n\tmovable: " + this.getMovable()
                + "\n\tpassable: " + this.getIsPassable()
                + "\n\tmain.com.dino.grid: " + this.getGrid().getName()
                + "\n\tpath: " + this.getPath()
                + "\n\tURL: " + this.getPath()
                + "\n\tstats:" + this.stats
                + "]";

        return str;
    }
}
