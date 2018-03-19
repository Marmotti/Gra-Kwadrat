package com.tutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreBoard extends MouseAdapter{

    private Game game;

    int rectWidth = 180;
    int rectHeight = 30;

    public ScoreBoard(Game game) {
        this.game = game;
    }

    public boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else
                return false;
        } else
            return false;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (game.gameState == STATE.Scores) {
            if (mouseOver(mx, my, (Game.WIDTH - rectWidth) / 2, Game.HEIGHT / 10 + 10*rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Menu;
            }
            else if (mouseOver(mx, my, (Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 +12*rectHeight, rectWidth, rectHeight)){
                System.exit(1);
            }
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    public void tick(){

    }


    public void render (Graphics g){
        int choiceWidth;

        Font tut = new Font("arial", 3, Game.HEIGHT/24);
        Font topScores = new Font("arial", 1, (5 * Game.HEIGHT )/48);

        g.setColor(Color.black);
        g.setFont(topScores);
        choiceWidth = g.getFontMetrics().stringWidth("Najlepsze Wyniki:");
        g.drawString("Najlepsze Wyniki:", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + rectHeight - Game.HEIGHT/48);

        g.setFont(tut);
        choiceWidth = g.getFontMetrics().stringWidth("1. Świst Analog");
        g.drawString("1. Świst Analog", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 3*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("2. Świst Bojówkarz");
        g.drawString("2. Świst Bojówkarz", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 4*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("3. ");
        g.drawString("3. ", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 5*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("4. ");
        g.drawString("4. ", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 6*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("5. ");
        g.drawString("5. ", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 7*rectHeight - Game.HEIGHT/48);


        g.fillRect((Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 + 10*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 + 12*rectHeight, rectWidth, rectHeight);

        g.setColor(Color.white);
        choiceWidth = g.getFontMetrics().stringWidth("Powrót");
        g.drawString("Powrót", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 11*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("Wyjdź");
        g.drawString("Wyjdź", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 13*rectHeight - Game.HEIGHT/48);
    }
}
