package GRAKwadrat;

import java.awt.*;

public class BasicTrail extends GameObject {
    private float alpha = 1;
    private Handler handler;
    private Color color;
    private float width, height;
    private double life;
    //life = 0.001 - 0.1

    public BasicTrail(float x, float y, ID id, Color color, float width, float height, double life, Handler handler) {
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;

    }

    public void tick() {
        if(alpha > life){
            alpha -= life - 0.001f;
        }
        else
            handler.removeObject(this);
    }
    //Renderowanie 'ogona', nie do końca to rozumiem, Graphics2D i composity są niełatwe
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);

        if (id == ID.TrailOval)
            g.fillOval((int)x, (int)y, (int)width, (int)height);

        if (id == ID.TrailRect)
            g.fillRect((int)x, (int)y, (int)width, (int)height);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }
    public Rectangle getBounds() {
        return null;
    }
}
