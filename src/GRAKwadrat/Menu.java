package GRAKwadrat;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Menu extends GameScreen{

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
            if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 2 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.PlayerChoice;
            }
            if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 4 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.ScoreBoard;
            }
            if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 6 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Help;
            }
            if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 8 * rectHeight, rectWidth, rectHeight)) {
                System.exit(1);
            }
        }
    }

    public void tick(){

    }

    public void render(Graphics g){

        int menuWidth;

        //Napis menu
        g.setFont(large);
        g.setColor(Color.WHITE);
        menuWidth = g.getFontMetrics().stringWidth("Menu");
        g.drawString("Menu", (Game.currentWidth - menuWidth)/2, Game.currentHeight /10);

        //Opcje wyboru
        g.setColor(Color.black);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 2*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 4*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 6*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 8*rectHeight, rectWidth, rectHeight);

        //Tekst wyboru, w wyskości - Game.currentHeight/48 bierze się stąd, że czcionka ma wyskoość 20 (10 = 20 / 2)
        //Nie wiesz skąd się bierze? Napisz se dzbanie algorytm żeby było idealne wyśrodkowane
        g.setColor(Color.white);
        g.setFont(medium);

        draw("Graj teraz!", 3, g);
        draw("Najlepsze wyniki", 5, g);
        draw("Pomocy!", 7, g);
        draw("Wyjdź", 9, g);


    }
}
