package GRAKwadrat;

import java.awt.*;
import java.awt.event.MouseEvent;


public class Help extends GameScreen {

    private Game game;
    private Handler handler;


    public Help(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (game.gameState == STATE.Help) {
            if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 8 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.PlayerChoice;
            }
            else if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 10 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Menu;
            }
            else if (mouseOver(mx, my, (Game.currentWidth - rectWidth)/2, Game.currentHeight /10 +12*rectHeight, rectWidth, rectHeight)){
                System.exit(1);
            }
        }
    }

    public void tick(){

    }


    public void render (Graphics g){
        g.setColor(Color.black);
        g.setFont(medium);
        draw("Ten okrąg, taki okrąg, nazywamy okręgiem krzywiznoooowym", 1, g);

        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 8*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 10*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 12*rectHeight, rectWidth, rectHeight);

        g.setColor(Color.white);
        draw("Graj!", 9, g);
        draw("Powrót", 11, g);
        draw("Wyjdź", 13, g);
    }
}
