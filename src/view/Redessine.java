package view;

/**
 * XU ZIHAN GROUPE 1
 */
public class Redessine extends Thread {
    private final Affichage monAffichage;
    private static final int DELAY = 50;
    public Redessine(Affichage Aff){
        monAffichage = Aff;
    }

    private boolean isPause = false;

    @Override
    public void run() {

        while (!isPause){
            try { Thread.sleep(DELAY);
                monAffichage.repaint(); //Faites-le redessiner de temps en temps
                monAffichage.AddScore(((float)DELAY)/1000f);
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void pause(){
        isPause = true;
    }

}