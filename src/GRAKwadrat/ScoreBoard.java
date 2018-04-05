package GRAKwadrat;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ScoreBoard extends GameScreen{

    private Game game;

    public ScoreBoard(Game game) {
        this.game = game;
    }


    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (game.gameState == STATE.ScoreBoard) {
            if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 10*rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Menu;
            }
            else if (mouseOver(mx, my, (Game.currentWidth - rectWidth)/2, Game.currentHeight /10 +12*rectHeight, rectWidth, rectHeight)){
                System.exit(1);
            }
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    public void tick(){

    }


    public void render (Graphics g){

        g.setColor(Color.black);
        g.setFont(large);

        draw("Najlepsze Wyniki:", 1, g);

        g.setFont(medium);

        draw("1. Świst Analog", 3, g);
        draw("2. Świst Bojówkarz", 4, g);
        draw("3. Kulka Ciacho", 5, g);
        draw("4. Najsmutniejszy sułtan", 6, g);
        draw("5. Nikuśka 2004", 7, g);


        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 10*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 12*rectHeight, rectWidth, rectHeight);

        g.setColor(Color.white);

        draw ("Powrót", 11, g);
        draw("Wyjdź", 13, g);

    }
}
