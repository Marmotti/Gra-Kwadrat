package com.tutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter{

    //Wielkośc okienek wyboru
    int rectWidth = 180;
    int rectHeight = 30;

    private Game game;
    private Handler handler;

    public Menu (Game game, Handler handler){
        this.game = game;
        this.handler = handler;

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == STATE.Menu) {
            if (mouseOver(mx, my, (Game.WIDTH - rectWidth) / 2, Game.HEIGHT / 10 + 2 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new Player(0, Game.HEIGHT / 2 - 32, ID.Player2, handler));
                handler.addObject(new QuickBoi(64, 64, ID.QuickEnemy, handler));
                handler.addObject(new BallChaser(128, 64, ID.BallChaser, handler));
            }
            if (mouseOver(mx, my, (Game.WIDTH - rectWidth) / 2, Game.HEIGHT / 10 + 4 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Scores;
            }
            if (mouseOver(mx, my, (Game.WIDTH - rectWidth) / 2, Game.HEIGHT / 10 + 6 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Help;
            }
            if (mouseOver(mx, my, (Game.WIDTH - rectWidth) / 2, Game.HEIGHT / 10 + 8 * rectHeight, rectWidth, rectHeight)) {
                System.exit(1);
            }
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    public boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else
                return false;
        }else
                return false;
    }
    public void tick(){

    }

    public void render(Graphics g){

        int menuWidth;
        int choiceWidth;
        //Wielkośc okienek wyboru, deklarowane wcześniej, ale są tu żeby zapamiętać
        //int rectWidth = 180;
        //int rectHeight = 30;

        //Czcionki
        //Dlaczego takie? Bo są ładne i pasują
        Font menu1 = new Font("arial", 1, (5 * Game.HEIGHT )/48);
        Font choice = new Font ("arial", 2, Game.HEIGHT/24);

        //Napis menu
        g.setFont(menu1);
        g.setColor(Color.WHITE);
        menuWidth = g.getFontMetrics().stringWidth("Menu");
        g.drawString("Menu", (Game.WIDTH - menuWidth)/2, Game.HEIGHT/10);

        //Opcje wyboru
        g.setColor(Color.black);
        g.fillRect((Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 + 2*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 + 4*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 + 6*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.WIDTH - rectWidth)/2, Game.HEIGHT/10 + 8*rectHeight, rectWidth, rectHeight);
        //Tekst wyboru, w wyskości - Game.HEIGHT/48 bierze się stąd, że czcionka ma wyskoość 20 (10 = 20 / 2)
        //Nie wiesz skąd się bierze? Napisz se dzbanie algorytm żeby było idealne wyśrodkowanie
        g.setColor(Color.lightGray);
        g.setFont(choice);
        choiceWidth = g.getFontMetrics().stringWidth("Graj teraz!");
        g.drawString("Graj teraz!", (Game.WIDTH  - choiceWidth)/2, Game.HEIGHT/10 + 3*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("Najlepsze wyniki");
        g.drawString("Najlepsze wyniki", (Game.WIDTH  - choiceWidth)/2, Game.HEIGHT/10 + 5*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("Pomocy!");
        g.drawString("Pomocy!", (Game.WIDTH  - choiceWidth)/2, Game.HEIGHT/10 + 7*rectHeight - Game.HEIGHT/48);
        choiceWidth = g.getFontMetrics().stringWidth("Wyjdź");
        g.drawString("Wyjdź", (Game.WIDTH  - choiceWidth)/2, Game.HEIGHT/10 + 9*rectHeight - Game.HEIGHT/48);


    }
}
