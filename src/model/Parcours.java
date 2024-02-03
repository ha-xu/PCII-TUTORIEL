package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class Parcours {

    public static int HORIZON = 50;
    public static int MaxLength = Position.BEFORE + Position.AFTER;
    public static int X_MIN = 30;
    public static int X_MAX = 50;

    public static int Y_MIN = Position.HAUTEUR_MIN+20;
    public static int Y_MAX = Position.HAUTEUR_MAX-20;

    private final Position pos;
    private final ArrayList<Point> points = new ArrayList<>();

    public ArrayList<Point> getPoints() {
        ArrayList<Point> newPoints = new ArrayList<>();
        for (Point p : points) {
            Point newPoint = new Point(p);
            newPoint.setLocation(p.getX()-pos.getAvancement(), p.getY());
            newPoints.add(newPoint);
        }
        return newPoints;
    }

    public Parcours(Position pos) {
        this.pos = pos;
        int x0 = 0;
        int y0 = 5;
        Point debut = new Point(x0, y0);
        points.add(debut);
        Point debut2 = new Point(x0 + HORIZON, y0);
        points.add(debut2);
        int x1 = x0 + HORIZON;
        int y1;
        while(x1 <= MaxLength) {
            Random rand = new Random();
            y1  = rand.nextInt(Y_MAX - Y_MIN) + Y_MIN;
            x1 = x1 + rand.nextInt(X_MAX-X_MIN) + X_MIN;
            Point p = new Point(x1, y1);
            points.add(p);
        }
    }

   public void update(){

       if(points.size() >=2){
            if(points.get(1).getX() - pos.getAvancement() < -Position.AFTER){
                points.removeFirst();
            }
        }


       int dernierX = points.getLast().x - pos.getAvancement() ;

       if(dernierX<=MaxLength){
           Random rand = new Random();
           int newX;
           int newY;
           newY  = rand.nextInt(Y_MAX - Y_MIN) + Y_MIN;
           newX = points.getLast().x + rand.nextInt(X_MAX-X_MIN) + X_MIN;
           Point p = new Point(newX, newY);
           points.add(p);
       }
   }

   public double GetYinPosition0(){
       //get two points whose (X - avancement) are around the position 0
       Point p0 = new Point();
         Point p1 = new Point();

       for(Point p : points){
           if(p.getX() - pos.getAvancement() <= 0 && points.get(points.indexOf(p)+1).getX() - pos.getAvancement() >= 0){
                p0.setLocation(p.getX() - pos.getAvancement(), p.getY());
                p1.setLocation(points.get(points.indexOf(p)+1).getX() - pos.getAvancement(), points.get(points.indexOf(p)+1).getY());
                break;
           }
       }
       return p0.getY() + (p1.getY() - p0.getY()) * (0 - p0.getX()) / (p1.getX() - p0.getX());


   }

}
