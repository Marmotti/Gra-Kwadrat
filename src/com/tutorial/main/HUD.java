package com.tutorial.main;

import java.awt.*;


public class HUD {

    private static int level = 1;
    private static float score = 0;
    private static float points = 0;
    private static int HEALTH = 100;

    public void tick(){
        Game.clamp(HEALTH, 0, 100);
        score++;
        points += 0.002;
    }
    public void render(Graphics g){

        //Healthbar
        g.setColor(Color.gray);;
        g.fillRect(Game.WIDTH/2 - 50, Game.HEIGHT - Game.HEIGHT/5, 100, 20);
        g.setColor(Color.green);
        g.fillRect(Game.WIDTH/2 - 50, Game.HEIGHT - Game.HEIGHT/5, HEALTH, 20);
        g.setColor(Color.white);
        g.drawRect(Game.WIDTH/2 - 50, Game.HEIGHT - Game.HEIGHT/5, 100, 20);

        //Renderowanie statystyk
        g.drawString("Level: " + level,8, 12 );
        g.drawString("Score: " + ((int) score/10), 8, 24);
        g.drawString("Points: " + ((int) points), 8, 36);

    }
    //Settery i gettery
    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        HUD.level = level;
    }

    public static float getScore() {
        return score;
    }

    public static void setScore(int score) {
        HUD.score = score;
    }

    public static float getPoints() {
        return points;
    }

    public static void setPoints(float points) {
        HUD.points = points;
    }

    public static int getHEALTH() {
        return HEALTH;
    }

    public static void setHEALTH(int HEALTH) {
        HUD.HEALTH = HEALTH;
    }
}
