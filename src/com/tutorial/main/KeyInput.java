package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    private boolean[][] keyDown = new boolean[2][4];

    public KeyInput(Handler handler){
        this.handler = handler;
    for (int i = 0; i<=3; i++){
     keyDown[0][i] = false;
     keyDown[1][i] = false;
    }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            //Key events for Player
            if (tempObject.id == ID.Player){
                if (key == KeyEvent.VK_W){tempObject.setVelY(-2);   keyDown[0][0] = true;}
                if (key == KeyEvent.VK_S){tempObject.setVelY( 2);   keyDown[0][1] = true;}
                if (key == KeyEvent.VK_A){tempObject.setVelX(-2);   keyDown[0][2] = true;}
                if (key == KeyEvent.VK_D){tempObject.setVelX( 2);   keyDown[0][3] = true;}
            }
            //Key events for Player2
            if (tempObject.id == ID.Player2){
                if (key == KeyEvent.VK_UP){tempObject.setVelY(-2);      keyDown[1][0] = true;}
                if (key == KeyEvent.VK_DOWN){tempObject.setVelY( 2);    keyDown[1][1] = true;}
                if (key == KeyEvent.VK_LEFT){tempObject.setVelX(-2);    keyDown[1][2] = true;}
                if (key == KeyEvent.VK_RIGHT){tempObject.setVelX( 2);   keyDown[1][3] = true;}
            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            //Key events for Player
            if (tempObject.id == ID.Player){
                if (key == KeyEvent.VK_W){keyDown[0][0] = false;}
                if (key == KeyEvent.VK_S){keyDown[0][1] = false;}
                if (key == KeyEvent.VK_A){keyDown[0][2] = false;}
                if (key == KeyEvent.VK_D){keyDown[0][3] = false;}
                //Vertical
                if (!keyDown[0][0] && !keyDown[0][1])
                    tempObject.velY = 0;
                //Horizontal
                if (!keyDown[0][2] && !keyDown[0][3])
                    tempObject.velX = 0;
            }
            //Key events for Player2
            if (tempObject.id == ID.Player2){
                if (key == KeyEvent.VK_UP){keyDown[1][0] = false;}
                if (key == KeyEvent.VK_DOWN){keyDown[1][1] = false;}
                if (key == KeyEvent.VK_LEFT){keyDown[1][2] = false;}
                if (key == KeyEvent.VK_RIGHT){keyDown[1][3] = false;}
                //Vertical
                if (!keyDown[1][0] && !keyDown[1][1])
                    tempObject.velY = 0;
                //Horizontal
                if (!keyDown[1][2] && !keyDown[1][3])
                    tempObject.velX = 0;
            }
        }
    }
}