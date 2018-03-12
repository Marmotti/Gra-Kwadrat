package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    //Stałe oraz jeden główny wątek
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false; //czy gra działa

    private Handler handler;

    //Konstruktor gry
    public Game(){
        new Window (WIDTH, HEIGHT, "Pierwsza Gra", this);

        handler = new Handler();

        handler.addObject(new Player(100, 100, ID.Player));
    }
    //Metoda startująca  naszą grę
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    // Metoda pauzująca grę
    public synchronized void stop(){
        try{
            thread.join(); //Zatrzymuje grę
            running = false;
            } catch (Exception e){
            e.printStackTrace();
        }
    }
    /* Serce gry, metoda opisująca działanie, updatująca grę w czasie
    Jest to tzw 'game loop'.
     */
    public void run(){
        long lastTime = System.nanoTime();
        double FPS = 60.0;
        double time = 1000000000 / FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / time ;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                System.out.println("x = " + handler.object.getFirst().getX());
                System.out.println("VelX = " + handler.object.getFirst().getVelX());
                System.out.println("Delta =  " + delta);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.orange);
        g.fillRect(0,0,WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main (String args[]){

        new Game();

    }
}
