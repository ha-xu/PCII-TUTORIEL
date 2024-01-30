package model;

import main.GameOverPanel;
import main.Main;

import javax.swing.*;

public class CollisionDetecteur extends Thread{
    private Position position;
    private Parcours parcours;

    private  Descendre descendre;

    private ParcoursMove parcoursMove;

    private static final int interval = 20;

    private boolean isPause = false;
    //constructor
    public CollisionDetecteur(Position p, Parcours parcours,Descendre descendre,ParcoursMove parcoursMove){
        position = p;
        this.parcours = parcours;
        this.descendre = descendre;
        this.parcoursMove = parcoursMove;
        ;
    }

    @Override
    public void run() {
        while(!isPause) {
            try { Thread.sleep(interval);
                if (parcours.GetYinPosition0()<=position.GetOvaleHauteurDown() || parcours.GetYinPosition0()>=position.GetOvaleHauteurUp()){
                    System.out.println("Game Over");
                    //stop the move thread
                    parcoursMove.pause();
                    //stop the circle thread
                    descendre.pause();
                    //stop the collision detecteur thread
                    this.pause();

                    //show the game over panel
                    Main.GameOver();
                    break;
                }
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void pause(){
        isPause = true;
    }
}
