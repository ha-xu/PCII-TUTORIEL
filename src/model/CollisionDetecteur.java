package model;

import main.Main;
import view.Redessine;

public class CollisionDetecteur extends Thread{
    private final Position position;
    private final Parcours parcours;

    private final Descendre descendre;

    private final ParcoursMove parcoursMove;

    private final Redessine redessine;

    private static final int interval = 20;

    private boolean isPause = false;
    //constructor
    public CollisionDetecteur(Position p, Parcours parcours,Descendre descendre,ParcoursMove parcoursMove,Redessine redessine){
        position = p;
        this.parcours = parcours;
        this.descendre = descendre;
        this.parcoursMove = parcoursMove;
        this.redessine = redessine;
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
                    //stop the repaint thread
                    redessine.pause();
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
