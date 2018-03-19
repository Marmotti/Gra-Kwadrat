package com.tutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Tutorial extends MouseAdapter {

    private Game game;
    private Handler handler;

    int rectWidth = 180;
    int rectHeight = 30;

    public Tutorial(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
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
        if (game.gameState == STATE.Help) {
            if (mouseOver(mx, my, (Game.WIDTH - rectWidth) / 2, Game.HEIGHT / 10 + 8 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Menu;
            }
            else if (mouseOver(mx, my, (Game.WIDTH - rectWidth) / 2, Game.HEIGHT / 10 + 10 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new Player(0, Game.HEIGHT / 2 - 32, ID.Player2, handler));
                handler.addObject(new QuickBoi(64, 64, ID.QuickEnemy, handler));
                handler.addObject(new BallChaser(128, 64, ID.BallChaser, handler));
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
        g.setFont(tut);
        g.setColor(Color.black);
        choiceWidth = g.getFontMetrics().stringWidth("Ten okrąg, taki okrąg, nazywamy okręgiem krzywiznoooowym");
        g.drawString("Ten okrąg, taki okrąg, nazywamy okręgiem krzywiznoooowym", (Game.WIDTH - choiceWidth)/2, 20);

        g.fillRect((Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 + 8*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 + 10*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 + 12*rectHeight, rectWidth, rectHeight);

        g.setColor(Color.white);
        choiceWidth = g.getFontMetrics().stringWidth("Powrót");
        g.drawString("Powrót", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 9*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("Graj!");
        g.drawString("Graj!", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 11*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("Wyjdź");
        g.drawString("Wyjdź", (Game.WIDTH - choiceWidth)/2, Game.HEIGHT/10 + 13*rectHeight - Game.HEIGHT/48);
    }
}
