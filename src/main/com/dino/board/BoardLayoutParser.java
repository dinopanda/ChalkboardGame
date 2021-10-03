package main.com.dino.board;

import main.com.dino.entity.Box;
import main.com.dino.entity.GridEntity;
import main.com.dino.entity.Item;
import main.com.dino.entity.Robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will read a file of a known format and place the objects on the
 * board.
 */
public class BoardLayoutParser {

    /**
     * Constructor
     */
    public BoardLayoutParser() {

    }

    public List<GridEntity> parseBoardFile(String fileName) {
        try {
            URL filePath = getClass().getClassLoader().getResource("main/resources/layouts/" + fileName);
            BufferedReader reader = new BufferedReader( new FileReader(filePath.getPath().replace("%20", " ")));

            String line;

            // Expected row column size on first line
            line = reader.readLine();
            // 7,7
            String rc[] = line.split(",");
            int rowSize = Integer.parseInt(rc[0]);
            int colSize = Integer.parseInt(rc[1]);

            System.out.println("Row:Column size " + rowSize + ", " + colSize);

            // Read until EOF
            int row = 0;
            List<GridEntity> gridEntities = new ArrayList<>();
            while((line = reader.readLine()) != null) {

                String columns[] = line.split(" ");
                for (int col = 0; col < columns.length; col++) {
                    if (columns[col].equals("R")) {
                        // Add robot
                        System.out.println("R: " + row + "," + col);

                        Robot robot = new Robot("stitch", null, row, col);
                        gridEntities.add(robot);
                    } else if (columns[col].equals("B")) {
                        // Add box
                        System.out.println("B: " + row + "," + col);

                        Box box = new Box(null, row, col);
                        gridEntities.add(box);
                    } else if (columns[col].equals("P")) {
                        // Add movable box
                        System.out.println("P: " + row + "," + col);

                        Box movableBox = new Box(null, row, col, true);
                        gridEntities.add(movableBox);
                    } else if (columns[col].equals("I")) {
                        // Add item
                        System.out.println("I: " + row + "," + col);

                        Item item = new Item(null, row, col);
                        gridEntities.add(item);
                    }
                }

                row++;
            }

            reader.close();

            return gridEntities;
        } catch (IOException e) {
            // do something
            System.out.println("IOExecption: " + e.getMessage());
        }

        return null;
    }
}
