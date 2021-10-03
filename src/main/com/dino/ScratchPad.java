package main.com.dino;

import main.com.dino.entity.GridEntity;
import main.com.dino.entity.Icon;
import main.com.dino.entity.Robot;
import main.com.dino.entity.properties.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.List;

/**
 * ScratchPad where "Scratch" like input is placed.
 *
 * Full control over the entities on the main.com.dino.board are present here.
 */
public class ScratchPad extends KeyAdapter {
    private List<GridEntity> entities;
    private Icon stitch;

    private boolean w_pressed = false;
    private boolean a_pressed = false;
    private boolean s_pressed = false;
    private boolean d_pressed = false;
    private boolean i_pressed = false;

    /**
     * Constructor.
     */
    public ScratchPad(List<GridEntity> entities) {
        this.entities = entities;
    }

    /**
     * Method called where user code is put.
     * This is the "Scratch" like section.
     */
    public void run() {
        // Find a specific main.com.dino.entity.
        for(int i = 0; i < entities.size(); i++) {
            if ("stitch".equals(entities.get(i).getName())) {
                this.stitch = (Icon) entities.get(i);
                break;
            }
        }

        // user input loop
        boolean isWhileRunning = true;
        while(isWhileRunning) {

            if (w_pressed) {
                stitch.move(Direction.UP);
            }
            if (a_pressed) {
                stitch.move(Direction.LEFT);
            }
            if (s_pressed) {
                stitch.move(Direction.DOWN);
            }
            if (d_pressed) {
                stitch.move(Direction.RIGHT);
            }
            if (i_pressed) {
                System.out.println((Robot)stitch);
            }

            try {
                Thread.sleep(70);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        System.out.println("Key Pressed Event!");
        if (key == KeyEvent.VK_W) {
            // we can enter this piece of code
            System.out.println("Key W - SP");
            // this.stitch.move(Direction.UP);
            w_pressed = true;
        }
        if (key == KeyEvent.VK_A) {
            System.out.println("Key A - SP");
            // this.stitch.move(Direction.LEFT);
            a_pressed = true;
        }
        if (key == KeyEvent.VK_S) {
            System.out.println("Key S - SP");
            // this.stitch.move(Direction.DOWN);
            s_pressed = true;
        }
        if (key == KeyEvent.VK_D) {
            System.out.println("Key D - SP");
            // this.stitch.move(Direction.RIGHT);
            d_pressed = true;
        }
        if (key == KeyEvent.VK_I) {
            System.out.println("Key I - SP");
            // this.stitch.move(Direction.RIGHT);
            i_pressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        System.out.println("Key Released Event!");
        if (key == KeyEvent.VK_W) {
            // we can enter this piece of code
            System.out.println("Key W Released - SP");
            // this.stitch.move(Direction.UP);
            w_pressed = false;
        }
        if (key == KeyEvent.VK_A) {
            System.out.println("Key A Released - SP");
            // this.stitch.move(Direction.LEFT);
            a_pressed = false;
        }
        if (key == KeyEvent.VK_S) {
            System.out.println("Key S Released - SP");
            // this.stitch.move(Direction.DOWN);
            s_pressed = false;
        }
        if (key == KeyEvent.VK_D) {
            System.out.println("Key D Released - SP");
            // this.stitch.move(Direction.RIGHT);
            d_pressed = false;
        }
        if (key == KeyEvent.VK_I) {
            System.out.println("Key I Released - SP");
            // this.stitch.move(Direction.RIGHT);
            i_pressed = false;
        }
    }
}
