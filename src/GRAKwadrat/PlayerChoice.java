package GRAKwadrat;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PlayerChoice extends GameScreen {

    private Game game;
    private Handler handler;

    public static int nOfPlayers = 1;

    public PlayerChoice(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == STATE.PlayerChoice) {
            if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 4 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Game;
                nOfPlayers = 1;

                handler.addObject(new Player(Game.currentWidth / 2 - 32, Game.currentHeight / 2 - 32, ID.Player, handler));
                handler.addObject(new QuickBoi(64, 64, ID.QuickEnemy, handler));
                handler.addObject(new BallChaser(128, 64, ID.BallChaser, handler));

            }
            if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 6 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Game;
                nOfPlayers = 2;

                handler.addObject(new Player(Game.currentWidth / 2 - 32, Game.currentHeight / 2 - 32, ID.Player, handler));
                handler.addObject(new Player(0, Game.currentHeight / 2 - 32, ID.Player2, handler));
                handler.addObject(new QuickBoi(64, 64, ID.QuickEnemy, handler));
                handler.addObject(new BallChaser(128, 64, ID.BallChaser, handler));
            }
            if (mouseOver(mx, my, (Game.currentWidth - rectWidth) / 2, Game.currentHeight / 10 + 10 * rectHeight, rectWidth, rectHeight)) {
                game.gameState = STATE.Menu;
            }
        }
    }
    public void tick(){

    }

    public void render(Graphics g){

        g.setColor(Color.black);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 4*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 6*rectHeight, rectWidth, rectHeight);
        g.fillRect((Game.currentWidth - rectWidth)/2, Game.currentHeight /10 + 10*rectHeight, rectWidth, rectHeight);

        g.setFont(large);
        draw("Wybierz tryb gry: ",1, g);

        g.setColor(Color.white);
        g.setFont(medium);
        draw("Jeden gracz", 5, g);
        draw("Dwóch graczy", 7, g);
        draw("Powrót", 11, g);
    }

    public static int getnOfPlayers() {
        return nOfPlayers;
    }
}
