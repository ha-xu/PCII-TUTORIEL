package model;

/**
 * XU ZIHAN GROUPE 1
 */
public class Descendre extends Thread {
    private final Position pos;
    private static final int interval = 100;

    private boolean isPause = false;
    public Descendre(Position p){
        pos = p;
    }


    @Override
    public void run() {
        while(!isPause) {
            try { Thread.sleep(interval);
                 pos.move(interval);
//                System.out.println(pos.getV());
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void pause(){
        isPause = true;
    }


}


