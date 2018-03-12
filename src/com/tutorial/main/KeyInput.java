package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            //Key events for Player
            if (tempObject.id == ID.Player){
                if (key == KeyEvent.VK_W)
                    tempObject.setVelY(-2);
                if (key == KeyEvent.VK_S)
                    tempObject.setVelY(2);
                if (key == KeyEvent.VK_A)
                    tempObject.setVelX(-2);
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(2);
            }
            //Key events for Player2
            if (tempObject.id == ID.Player2){
                if (key == KeyEvent.VK_UP)
                    tempObject.setVelY(-3);
                if (key == KeyEvent.VK_DOWN)
                    tempObject.setVelY(3);
                if (key == KeyEvent.VK_LEFT)
                    tempObject.setVelX(-3);
                if (key == KeyEvent.VK_RIGHT)
                    tempObject.setVelX(3);
            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            //Key events for Player
            if (tempObject.id == ID.Player) {
                if (key == KeyEvent.VK_W)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_S)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_A)
                    tempObject.setVelX(0);
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(0);
            }
            //Key events for Player2
            if (tempObject.id == ID.Player2) {
                if (key == KeyEvent.VK_UP)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_DOWN)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_LEFT)
                    tempObject.setVelX(0);
                if (key == KeyEvent.VK_RIGHT)
                    tempObject.setVelX(0);
            }
        }
    }
}
