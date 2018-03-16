package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    //Stałe oraz jeden główny wątek
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false; //czy gra działa

    private Handler handler;
    private HUD hud;
    private Spawn spawn;

    private Random random;

    //Konstruktor gry
    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window (WIDTH, HEIGHT, "Pierwsza Gra", this);

        hud = new HUD();
        spawn = new Spawn(handler, hud);
        random = new Random();

        handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player, handler));
        handler.addObject(new Player(0, HEIGHT/2 - 32, ID.Player2, handler));
        handler.addObject(new BasicEnemy(clamp(random.nextInt(WIDTH), 64, WIDTH - 64), (clamp(random.nextInt(HEIGHT), 64, HEIGHT - 64)), ID.BasicEnemy, handler));
        handler.addObject(new QuickBoi(64, 64, ID.QuickEnemy, handler));
        handler.addObject(new BallChaser(128, 64, ID.BallChaser, handler));

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
        this.requestFocus();
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
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
        hud.tick();
        spawn.tick();
    }
    //Wszystkie funckje rysujące obiekty
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
        hud.render(g);

        g.dispose();
        bs.show();
    }
    //Funkcja zabraniająca graczowi wyjscie poza pole, uzywana w klasie Player
    public static int clamp (int var, int min, int max){

        if (var >= max)
            return max;

        if (var <= min)
            return min;
        else
            return var;
    }

    public static void main (String args[]){

        new Game();

    }
}
