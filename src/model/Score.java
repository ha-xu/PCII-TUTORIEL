package model;

import main.Main;

public class Score extends Thread{

    private static float score = 0;

    private boolean isPause = false;

    private static final int interval = 20;


    public static void ResetScore() {
        score = 0;
    }

    public static float GetScore() {
        return score;
    }

    public static void AddScore(float interval) {
        score += interval;
    }

    //constructor
    public Score(){
        score = 0;
    }

    @Override
    public void run() {
        while(!isPause) {
            try { Thread.sleep(interval);
                AddScore(((float)interval)/1000f);
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void pause(){
        isPause = true;
    }
}
