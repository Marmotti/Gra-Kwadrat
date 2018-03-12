package com.tutorial.main;

import java.awt.*;

public class BasicEnemy extends GameObject {

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);

        velX = 1;
        velY = 1;
    }

    public void tick() {
        x += velX;
        y += velY;
        //Zabrania przeciwnikom wyjśc poza okno
        if(x <= 0 || x >= Game.WIDTH - 32)
            velX = -velX;
        if(y <= 0 || y >= Game.HEIGHT - 48)
            velY = -velY;
    }


    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
}
