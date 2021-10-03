package main.com.dino.board;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Class to handle Keyboard Events.
 */
public class KeyboardInput extends KeyAdapter {

    /**
     * Constructors
     */
    public KeyboardInput () {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        System.out.println("Key Pressed Event!");
        if (key == KeyEvent.VK_W) {
            // we can enter this piece of code
            System.out.println("Key W");
        }
        if (key == KeyEvent.VK_A) {
            System.out.println("Key A");
        }
        if (key == KeyEvent.VK_S) {
            System.out.println("Key S");
        }
        if (key == KeyEvent.VK_D) {
            System.out.println("Key D");
        }
    }
}
