package com.tutorial.main;

import java.awt.*;

public class BallChaser extends GameObject {
    private Handler handler;
    private GameObject player;
    private Color tempColor;
    public BallChaser(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        velX = 1;
        velY = 1;

        for (int i = 0; i < handler.object.size(); i++){
            this.handler = handler;

            if (handler.object.get(i).getId() == ID.Player && id == ID.BallChaser)
                player = handler.object.get(i);

            if (handler.object.get(i).getId() == ID.Player2 && id == ID.BallChaser2)
                player = handler.object.get(i);
        }
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;
        //Kod, dzięki któremu BallChser namierza gracza i leci w jego kierunku ze stałą prędkością
        float deltaX = player.getX() - x + 10;
        float deltaY = player.getY() - y + 10;
        float distance = ((float)(Math.sqrt(((player.getX() - x)*(player.getX() - x))+((player.getY() - y)*(player.getY() - y)))));

        velX = (float) ((1.0/distance) * deltaX);
        velY = (float) ((1.0/distance) * deltaY);

        //Zabrania przeciwnikom wyjśc poza okno
        if(x <= 0 || x >= Game.WIDTH - 32)
            velX = -velX;
        if(y <= 0 || y >= Game.HEIGHT - 48)
            velY = -velY;

        if (id == ID.BallChaser){
            tempColor = Color.cyan;
        }
        if (id == ID.BallChaser2){
            tempColor = Color.darkGray;
        }

        handler.addObject(new BasicTrail(x, y, ID.TrailRect, tempColor, 16, 16,0.05, handler ));
    }


    public void render(Graphics g) {
        g.setColor(tempColor);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
