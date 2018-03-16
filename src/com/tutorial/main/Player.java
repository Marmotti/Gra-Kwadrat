package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();
    Handler handler;

    public Player(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    public void tick(){
        x += velX;
        y += velY;
        //Zabronienie graczowi wyjścia poza okno; dlaczego wartości 48 i 68 px? Bo tak działa xD, sprawdzone empirycznie
        x = Game.clamp ((int)x, 0, Game.WIDTH - 48);
        y = Game.clamp ((int)y, 0, Game.HEIGHT - 68);

        Color tempColor;
        tempColor = new Color(1);

        if (id == ID.Player){
            tempColor = Color.white;
        }
        if (id == ID.Player2){
            tempColor = Color.black;
        }

        handler.addObject(new BasicTrail(x, y, ID.TrailOval, tempColor, 32, 32,0.15, handler ));

        collision();

    }

    private void collision(){
        for (int i=0; i< handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.id == ID.BasicEnemy || tempObject.id == ID.QuickEnemy || tempObject.id == ID.BallChaser){
                if(getBounds().intersects(tempObject.getBounds())){
                    //Collision code
                    HUD.setHEALTH(HUD.getHEALTH() - 1);
                }
            }
        }
    }
    public void render(Graphics g){
        if(id == ID.Player) {
            g.setColor(Color.white);
            g.fillOval((int)x, (int)y, 32, 32);
        }
        else if(id == ID.Player2)
            g.setColor(Color.black);
            g.fillOval((int)x, (int)y, 32, 32);

    }
}
