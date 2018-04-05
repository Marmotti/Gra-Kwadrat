package GRAKwadrat;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private PlayerChoice playerChoice;
    private static int nOfEnemies = 1;
    private int scoreKeep = 0;
    private Random r = new Random();

    public Spawn (Handler handler, HUD hud, PlayerChoice playerChoice){
        this.handler = handler;
        this.hud = hud;
        this.playerChoice = playerChoice;
    }
    //Co tick tutaj dodajemy do scora, max 6 przeciwników
    public void tick(){
            scoreKeep++;

        if (scoreKeep >= 500){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
        }
        if (hud.getLevel() <= 6 && hud.getLevel() == nOfEnemies + 1){
            nOfEnemies++;
            if (nOfEnemies == 2 && playerChoice.getnOfPlayers() == 1)
                handler.addObject(new BasicEnemy(Game.clamp(r.nextInt(Game.currentWidth), 64, Game.currentWidth - 64), Game.clamp(r.nextInt(Game.currentHeight), 64, Game.currentHeight - 64), ID.BasicEnemy, handler));
            if (nOfEnemies == 2 && playerChoice.getnOfPlayers() == 2)
                handler.addObject(new BallChaser(Game.clamp(r.nextInt(Game.currentWidth), 64, Game.currentWidth - 64), Game.clamp(r.nextInt(Game.currentHeight), 64, Game.currentHeight - 64), ID.BallChaser2, handler));
            if (nOfEnemies == 4)
                handler.addObject(new QuickBoi(Game.clamp(r.nextInt(Game.currentWidth), 64, Game.currentWidth - 64), Game.clamp(r.nextInt(Game.currentHeight), 64, Game.currentHeight - 64), ID.QuickEnemy, handler));
            else
                handler.addObject(new BasicEnemy(Game.clamp(r.nextInt(Game.currentWidth), 64, Game.currentWidth - 64), Game.clamp(r.nextInt(Game.currentHeight), 64, Game.currentHeight - 64), ID.BasicEnemy, handler));
        }

    }
}
