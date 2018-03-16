package com.tutorial.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private static int nOfEnemies = 1;
    private int scoreKeep = 0;
    private Random r = new Random();

    public Spawn (Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    //Co tick tutaj dodajemy do scora, max 6 przeciwników
    public void tick(){
            scoreKeep++;

        if (scoreKeep >= 500){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
        }
        if (hud.getLevel() <= 6 && hud.getLevel() == nOfEnemies + 1){
            nOfEnemies++;
            if (nOfEnemies == 2)
                handler.addObject(new BallChaser(Game.clamp(r.nextInt(Game.WIDTH), 64, Game.WIDTH - 64), Game.clamp(r.nextInt(Game.HEIGHT), 64, Game.HEIGHT - 64), ID.BallChaser, handler));
            if (nOfEnemies == 4)
                handler.addObject(new QuickBoi(Game.clamp(r.nextInt(Game.WIDTH), 64, Game.WIDTH - 64), Game.clamp(r.nextInt(Game.HEIGHT), 64, Game.HEIGHT - 64), ID.QuickEnemy, handler));
            else
                handler.addObject(new BasicEnemy(Game.clamp(r.nextInt(Game.WIDTH), 64, Game.WIDTH - 64), Game.clamp(r.nextInt(Game.HEIGHT), 64, Game.HEIGHT - 64), ID.BasicEnemy, handler));
        }

    }
}
