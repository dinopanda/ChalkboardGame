package main.com.dino.entity;

import main.com.dino.entity.properties.Direction;
import main.com.dino.grid.Grid;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Abstract class to hold a Grid-ed entity.
 */
public abstract class GridEntity {
    private static final AtomicInteger INSTANCE_COUNTER = new AtomicInteger();

    private String name;
    private int rowLoc;
    private int colLoc;
    private boolean movable;
    private boolean isPassable;
    private Grid grid;

    /**
     * Constructors.
     */
    public GridEntity(String name, Grid grid, int rowLoc, int colLoc,
                      boolean movable, boolean isPassable) {
        this.name = name;
        this.grid = grid;
        this.rowLoc = rowLoc;
        this.colLoc = colLoc;
        this.movable = movable;
        this.isPassable = isPassable;
    }

    public GridEntity(Grid grid, int rowLoc, int colLoc, boolean movable,
                      boolean isPassable) {
        this(getDefaultName(), grid, rowLoc, colLoc, movable, isPassable);
    }

    public GridEntity(String name, Grid grid, int rowLoc, int colLoc) {
        this(name, grid, rowLoc, colLoc, false, false);
    }

    public GridEntity(Grid grid, int rowLoc, int colLoc) {
        this(getDefaultName(), grid, rowLoc, colLoc, false, false);
    }

    /**
     * Create default name with AtomicInteger.
     */
    public static String getDefaultName() {
        int instance = INSTANCE_COUNTER.incrementAndGet();
        return "GridEntity_" + instance;
    }

    /**
     * Move Function.
     */
    public boolean move(Direction direction) {
        return this.getMovable() ? this.getGrid().move(this, direction) : false;
    }

    /**
     * Getter and Setters.
     */
    public String getName() {
        return this.name;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public int getRow() {
        return this.rowLoc;
    }

    public int getCol() {
        return this.colLoc;
    }

    public boolean getMovable() {
        return this.movable;
    }

    public boolean getIsPassable() {
        return this.isPassable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setRow(int rowLoc) {
        this.rowLoc = rowLoc;
    }

    public void setCol(int colLoc) {
        this.colLoc = colLoc;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public void setIsPassable(boolean isPassable) {
        this.isPassable = isPassable;
    }

    public String toString() {
        String str = "GridEntity["
                + "\tname: " + this.name
                + "\trowLoc: " + this.rowLoc
                + "\tcolLoc: " + this.colLoc
                + "\tmovable: " + this.movable
                + "\tpassable: " + this.isPassable
                + "\tmain.com.dino.grid: " + this.grid.getName()
                + "]";

        return str;
    }
}
