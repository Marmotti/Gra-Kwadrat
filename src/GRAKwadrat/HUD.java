package GRAKwadrat;

import java.awt.*;


public class HUD {

    private static int level = 1;
    private static float score = 0;
    private static float points = 0;
    private static int HEALTH = 100;

    public void tick(){
        Game.clamp(HEALTH, 0, 100);

        if (HEALTH == 0)
            System.exit(1);
        score++;
        points += 0.002;

    }
    public void render(Graphics g){

        //Healthbar
        g.setColor(Color.gray);;
        g.fillRect(Game.currentWidth /2 - 50, Game.currentHeight - Game.currentHeight /5, (5*Game.currentWidth)/32, Game.currentHeight /24);
        g.setColor(Color.green);
        g.fillRect(Game.currentWidth /2 - 50, Game.currentHeight - Game.currentHeight /5, HEALTH, Game.currentHeight /24);
        g.setColor(Color.white);
        g.drawRect(Game.currentWidth /2 - 50, Game.currentHeight - Game.currentHeight /5, (5*Game.currentWidth)/32, Game.currentHeight /24);

        //Renderowanie statystyk
        g.drawString("Level: " + level,Game.currentWidth /80, Game.currentHeight /40);
        g.drawString("Score: " + ((int) score/10), Game.currentWidth /80, Game.currentHeight /20);
        g.drawString("Points: " + ((int) points), Game.currentWidth /80, 3*Game.currentHeight /40);

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
