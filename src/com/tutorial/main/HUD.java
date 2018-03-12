package com.tutorial.main;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;
    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(Game.WIDTH/2 - 50, Game.HEIGHT - Game.HEIGHT/5, 100, 20);
    }
}
