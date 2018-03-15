package com.tutorial.main;

import java.awt.*;

public class QuickBoi extends GameObject{
    private Handler handler;

    public QuickBoi(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        velX = 2;
        velY = 5;

        this.handler = handler;
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, 24, 24);
    }
    public void tick() {
        x += velX;
        y += velY;
        //Zabrania przeciwnikom wyjśc poza okno
        if(x <= 0 || x >= Game.WIDTH - 32)
            velX = -velX;
        if(y <= 0 || y >= Game.HEIGHT - 48)
            velY = -velY;

        handler.addObject(new BasicTrail(x, y, ID.TrailOval, Color.red, 24, 24,0.05, handler ));
    }


    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, 24, 24);
    }
}

