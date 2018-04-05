package GRAKwadrat;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    //Stałe oraz jeden główny wątek
    public static final int WIDTH = 640, HEIGHT = 480;
    public static int currentWidth = 640, currentHeight = 480;

    private Window window;
    private Thread thread;
    private boolean running = false; //czy gra działa

    private Handler handler;
    private HUD hud;
    private Spawn spawn;
    private Menu menu;
    private Help help;
    private ScoreBoard scoreBoard;
    public PlayerChoice playerChoice;

    private Random random;

    public STATE gameState = STATE.Menu;

    //Konstruktor gry
    public Game(){
        handler = new Handler();
        menu = new Menu(this, handler);
        help = new Help(this, handler);
        scoreBoard = new ScoreBoard(this);
        playerChoice = new PlayerChoice(this, handler);

        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);
        this.addMouseListener(help);
        this.addMouseListener(scoreBoard);
        this.addMouseListener(playerChoice);


        window = new Window(WIDTH, HEIGHT, "Pierwsza Gra", this);

        hud = new HUD();
        spawn = new Spawn(handler, hud, playerChoice);
        random = new Random();

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
                System.out.println("Currentwidth= " + currentWidth + " Currentheight= " + currentHeight);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){

        handler.tick();

        if (gameState == STATE.Game) {
            hud.tick();
            spawn.tick();
        }
        else if (gameState == STATE.Menu){
            menu.tick();
        }
        else if (gameState == STATE.Help){
            help.tick();
        }
        else if (gameState == STATE.ScoreBoard){
            scoreBoard.tick();
        }
        else if (gameState == STATE.PlayerChoice){
            playerChoice.tick();
        }
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
        g.fillRect(0,0, currentWidth, currentHeight);

        handler.render(g);

        if (gameState == STATE.Game) {
            hud.render(g);
        }
        else if (gameState == STATE.Menu){
            menu.render(g);
        }
        else if (gameState == STATE.Help){
            help.render(g);
        }
        else if (gameState == STATE.ScoreBoard){
            scoreBoard.render(g);
        }
        else if (gameState == STATE.PlayerChoice){
            playerChoice.render(g);
        }
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



