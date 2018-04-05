package GRAKwadrat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    private int up[]= new int[2];
    private int down[]= new int[2];
    private int left[]= new int[2];
    private int right[]= new int[2];

    public KeyInput(Handler handler){
        this.handler = handler;
    for (int i = 0; i<2; i++){
     up[i] = 0;
     down[i] = 0;
     left[i] = 0;
     right[i] = 0;
    }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            //Key events for Player
            if (tempObject.id == ID.Player){
                if (key == KeyEvent.VK_W){up[0] = 2;   }
                if (key == KeyEvent.VK_S){down[0] = 2; }
                if (key == KeyEvent.VK_A){left[0] = 2; }
                if (key == KeyEvent.VK_D){right[0] = 2;}
                tempObject.setVelX(right[0] - left[0]);
                tempObject.setVelY(   down[0] - up[0]);
            }
            //Key events for Player2
            if (tempObject.id == ID.Player2){
                if (key == KeyEvent.VK_UP)   {up[1] = 2;   }
                if (key == KeyEvent.VK_DOWN) {down[1] = 2; }
                if (key == KeyEvent.VK_LEFT) {left[1] = 2; }
                if (key == KeyEvent.VK_RIGHT){right[1] = 2;}
                tempObject.setVelX(right[1] - left[1]);
                tempObject.setVelY(down[1] - up[1]   );
            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            //Key events for Player
            if (tempObject.id == ID.Player){
                if (key == KeyEvent.VK_W){up[0] = 0;   }
                if (key == KeyEvent.VK_S){down[0] = 0; }
                if (key == KeyEvent.VK_A){left[0] = 0; }
                if (key == KeyEvent.VK_D){right[0] = 0;}
                tempObject.setVelX(right[0] - left[0]);
                tempObject.setVelY(   down[0] - up[0]);
            }
            //Key events for Player2
            if (tempObject.id == ID.Player2){
                if (key == KeyEvent.VK_UP){up[1] = 0;      }
                if (key == KeyEvent.VK_DOWN){down[1] = 0;  }
                if (key == KeyEvent.VK_LEFT){left[1] = 0;  }
                if (key == KeyEvent.VK_RIGHT){right[1] = 0;}
                tempObject.setVelX(right[1] - left[1]);
                tempObject.setVelY(   down[1] - up[1]);
            }
        }
    }
}