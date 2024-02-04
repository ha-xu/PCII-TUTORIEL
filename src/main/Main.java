package main;

import control.ReactionClic;
import model.*;
import view.Affichage;
import view.GameMenuPanel;
import view.GameOverPanel;
import view.Redessine;

import javax.swing.*;
public class Main{
    private static JFrame gameFrame;

    public static void ShowMenu(){
        gameFrame.getContentPane().removeAll();
        gameFrame.add(new GameMenuPanel());
        gameFrame.revalidate();
        gameFrame.repaint();
    }

    //start the game
    public static void GameStart(){


        Position pos = new Position(); //new instance of position
        Parcours par = new Parcours(pos); //new instance of model.Parcours

        Affichage aff = new Affichage(pos,par); //new instance of view.Affichage
        Redessine rede = new Redessine(aff); //new instance of view.Redessine
        Descendre des = new Descendre(pos); //new instance of model.Descendre
        ParcoursMove parMove = new ParcoursMove(pos,par); //new instance of model.ParcoursMove
        Score score = new Score(); //new instance of model.Score
        CollisionDetecteur collisionDetecteur = new CollisionDetecteur(pos,par,des,parMove,rede,score); //new instance of model.CollisionDetecteur

        ReactionClic react = new ReactionClic(pos);
        aff.addMouseListener(react);

        des.start();
        rede.start();
        parMove.start();
        collisionDetecteur.start();
        score.start();


        gameFrame.getContentPane().removeAll();
        gameFrame.add(aff);
        gameFrame.revalidate();
        gameFrame.repaint();
    }



    //show when game over
    public static void GameOver(){
        gameFrame.getContentPane().removeAll();
        gameFrame.add(new GameOverPanel());
        gameFrame.revalidate();
        gameFrame.repaint();
    }



    public static void main(String[] args) {
        gameFrame = new JFrame("TheCircleGame");
        gameFrame.setPreferredSize(new java.awt.Dimension(500, 350));
        ShowMenu();
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}

