package GRAKwadrat;

import java.awt.*;

public class BasicEnemy extends GameObject {

    private Handler handler;

    public BasicEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        velX = 2;
        velY = 2;

        this.handler = handler;
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }
    public void tick() {
        x += velX;
        y += velY;
        //Zabrania przeciwnikom wyjśc poza okno
        if(x <= 0 || x >= Game.currentWidth - 32)
            velX = -velX;
        if(y <= 0 || y >= Game.currentHeight - 48)
            velY = -velY;

        handler.addObject(new BasicTrail(x, y, ID.TrailRect, Color.red, 16, 16,0.05, handler ));
    }


    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
