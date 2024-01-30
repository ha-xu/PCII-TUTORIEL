package model;

import view.Affichage;

import java.awt.geom.Point2D;

public class Position {

    public static final int GROUND = Affichage.winHeight; //y value of ground
    public static final double G = 15; //gravity
    private double hauteur = 5; //La hauteur initiale du cercle est le milieu de la fenêtre

    //Getter of hauteur
    public double getHauteur() {
        return hauteur;
    }
    private static final double VITESSEINITAL = 15;

    private double vitesse = 0;

    private int avancement = 0;
//    private double impulsion = 0;
    public static final double HAUREUROVALE = 20;
    public static final double WIDTHOVALE = 10;


    public static final int HAUTEUR_MIN = -20;
    public static final int HAUTEUR_MAX = 50;

    public static final int BEFORE = 200;
    public static final int AFTER = 50;
    public double get() {
        return hauteur;
    }

    public int getAvancement() {
        return avancement;
    }

    public void jump() {
//        hauteur = hauteur - HAUTEUR; // faire augmenter de la valeur constante
        vitesse = VITESSEINITAL; //EXO7 modifier la vitesse
    }

    public void move(double interval) {

        vitesse = vitesse - G * interval * 0.001; //calculer la vitesse ( v = v0 - gt)
        hauteur = ((double) hauteur + (double) vitesse * (double) interval / 1000); // valculer la hauteur ( h = vt)
    }

    public void ParcoursMove(){
        avancement = avancement + 1;
    }

    public double GetOvaleHauteurUp(){
        return hauteur + HAUREUROVALE/2;
    }

    public double GetOvaleHauteurDown(){
        return hauteur - HAUREUROVALE/2;
    }
}

