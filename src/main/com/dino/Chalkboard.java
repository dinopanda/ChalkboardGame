package main.com.dino;

import main.com.dino.board.BoardLayoutParser;
import main.com.dino.board.MainWindow;
import main.com.dino.entity.Box;
import main.com.dino.entity.GridEntity;
import main.com.dino.entity.Item;
import main.com.dino.entity.Robot;
import main.com.dino.grid.IconGrid;

import java.util.List;

/**
 * Main class for Chalkboard.
 *
 * This application is intended to be used to
 * teach the basics of computer science.
 */
public class Chalkboard {
    private static int GRID_ROWS = 7;
    private static int GRID_COLS = 7;

    public static void main(String args[]) {
        System.out.println("Chalkboard Starting...");

        BoardLayoutParser boardLayoutParser = new BoardLayoutParser();
        List<GridEntity> gridEntities = boardLayoutParser.parseBoardFile("testLayout.txt");

        // Create default window
        MainWindow mainWindow = new MainWindow("Chalkboard V1");

        // Call setup function
        List<GridEntity> entities = setup(mainWindow, gridEntities);
        ScratchPad scratchPad = new ScratchPad(entities);

        // Add KeyListener to the main window
        mainWindow.addKeyListener(scratchPad);

        // Run Program
        scratchPad.run();

        System.out.println("Waiting for Chalkboard to close...");
    }

    /**
     * Handle any custom setup here.
     *
     * Store all entities into gridEntities List to be used for
     * ScratchPad access later.
     */
    private static List<GridEntity> setup(MainWindow mainWindow, List<GridEntity> gridEntities) {
        IconGrid iconGrid = new IconGrid(GRID_ROWS, GRID_COLS, mainWindow.getSize());
        mainWindow.addPanel(iconGrid);
        iconGrid.revalidate();

        for (int i = 0; i < gridEntities.size(); i++) {
            GridEntity gridEntity = gridEntities.get(i);

            if (gridEntity instanceof Robot) {
                iconGrid.addEntityToGrid((Robot) gridEntity);
            } else if (gridEntity instanceof Box) {
                iconGrid.addEntityToGrid((Box) gridEntity);
            } else if (gridEntity instanceof Item) {
                iconGrid.addEntityToGrid((Item) gridEntity);
            }
        }

        mainWindow.revalidate();

        return gridEntities;
    }
}
