package GRAKwadrat;

import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class GameScreen extends MouseAdapter{
    protected int rectWidth = (9*Game.currentWidth)/32;
    protected int rectHeight = Game.currentHeight /16;

    protected Font large = new Font("arial", 1, (5 * Game.currentHeight)/48);
    protected Font medium = new Font ("arial", 2, Game.currentHeight /24);

    public abstract void tick();

    protected boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else
                return false;
        } else
            return false;
    }

    public void mousePressed(MouseEvent e) {

    }

    public  void draw(String s, int linia, Graphics g){
        int choiceWidth = g.getFontMetrics().stringWidth(s);
        g.drawString(s, (Game.currentWidth - choiceWidth)/2, Game.currentHeight /10 + linia*rectHeight - Game.currentHeight /48);
    }


}
