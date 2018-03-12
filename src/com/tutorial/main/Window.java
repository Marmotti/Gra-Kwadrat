package com.tutorial.main;


import javax.swing.*;
import java.awt.*;

/*Klasa opsująca głowne okno gry.
Zawiera metody ją opisujące, po pojawieniu się okna gra startuje.
*/
public class Window extends Canvas {

public Window (int width, int height, String title, Game game){
    JFrame frame = new JFrame(title); //Okno jest JFramem
    frame.setPreferredSize(new Dimension(width, height));
    frame.setMaximumSize(new Dimension(width, height));
    frame.setMinimumSize(new Dimension(width, height));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Przycisk x w prawym górnym rogu spełnia swoją funckję
    frame.setResizable(false); //Nie mozna zmieniać rozmiaru okna
    frame.setLocationRelativeTo(null); //Środek okna pojawia się na środku ekranu
    frame.setVisible(true); //Okno jest widoczne

    frame.add(game);
    game.start(); //Doadnie i wystartowanie gry w oknie
}
}
