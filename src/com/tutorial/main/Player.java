package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();

    public Player(int x, int y, ID id){
        super(x, y, id);

    }

    public void tick(){
        x += velX;
        y += velY;
        //Zabronienie graczowi wyjścia poza okno; dlaczego wartości 48 i 68 px? Bo tak działa xD, sprawdzone empirycznie
        x = Game.clamp (x, 0, Game.WIDTH - 48);
        y = Game.clamp (y, 0, Game.HEIGHT - 68);

    }
    public void render(Graphics g){
        if(id == ID.Player) {
            g.setColor(Color.white);
            g.fillRect(x, y, 32, 32);
        }
        else if(id == ID.Player2)
            g.setColor(Color.black);
            g.fillRect(x, y, 32, 32);

    }
}
