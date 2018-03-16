package com.tutorial.main;

import java.awt.*;

public class BallChaser extends GameObject {
    private Handler handler;
    private GameObject player;

    public BallChaser(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        velX = 1;
        velY = 1;

        for (int i = 0; i < handler.object.size(); i++){
            this.handler = handler;

            if (handler.object.get(i).getId() == ID.Player)
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

        handler.addObject(new BasicTrail(x, y, ID.TrailRect, Color.cyan, 16, 16,0.05, handler ));
    }


    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
