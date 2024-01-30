package model;

public class ParcoursMove extends Thread{
    private Position position;
    private Parcours parcours;
    private static final int interval = 100;

    private boolean isPause = false;

    //constructor
    public ParcoursMove(Position p, Parcours parcours){
        position = p;
        this.parcours = parcours;
    }

    @Override
    public void run() {
        while(!isPause) {
            try { Thread.sleep(interval);
                position.ParcoursMove();
                parcours.update();
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void pause(){
        isPause = true;
    }
}
