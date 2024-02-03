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

    @Override
    public void run() {

        for(;;) {
            try { Thread.sleep(DELAY);
                monAffichage.repaint(); //Faites-le redessiner de temps en temps
                monAffichage.AddScore(((float)DELAY)/1000f);
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    /** Le programme de test lance deux threads entrelacés */

}