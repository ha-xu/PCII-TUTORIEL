package view;

import model.Parcours;
import model.Position;
import model.Score;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Affichage extends JPanel {
    public static final int winWidth = 500;
    public static final int winHeight = 350;

    public static final double X =  (((double)Position.AFTER) / (double)(Position.BEFORE + Position.AFTER) * (double) winWidth) ;
    public static final double Y = ((((double)Position.HAUTEUR_MAX) / (double)(Position.HAUTEUR_MAX - Position.HAUTEUR_MIN)) * (double) winHeight) ;

    private static final double ratio_x = ((double) winWidth )/ (double) (Position.BEFORE + Position.AFTER) ;
    private static final double ratio_y = ((double) winHeight) / (double) (Position.HAUTEUR_MAX - Position.HAUTEUR_MIN) ;

    public static final int circleHeight = (int) ((int) Position.HAUREUROVALE * ratio_y);
    public static final int circleWidth = (int) ((int) Position.WIDTHOVALE * ratio_x);

    private final Position pos;
    private final Parcours parcours;

    private final JLabel scoreLabel;


    public static boolean gameOver = false;
    private int explosionTime = 0;
    private int explosionSize = 0;

    private static Point explosionPoint;

    public static void SetExplosionPoint(Point p){
        explosionPoint = p;
    }

    private Point modelPointToViewPoint(Point p) {
        return new Point( (int)X + (int) (p.getX() * ratio_x), (int)Y - (int) (p.getY() * ratio_y));
    }



    public Affichage(Position p, Parcours parcours) {
        pos = p;
        this.parcours = parcours;
        setPreferredSize(new Dimension(winWidth, winHeight));
        Score.ResetScore();
        //add score label save two decimal places
        scoreLabel = new JLabel("Score: " + String.format("%.2f", Score.GetScore()));
        this.add(scoreLabel);

        gameOver = false;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);


            g.setColor(Color.BLACK);
            //change the thickness of the line
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5.0f));
            //change the color of the line
            g2.setColor(Color.ORANGE);


            paintCircle(g);


            g2.setStroke(new BasicStroke(3.0f));
            //change the color of the line
            g2.setColor(Color.black);


            paintParcours(g);

            //update the score
            scoreLabel.setText("Score: " + String.format("%.2f", Score.GetScore()));

        //draw the explosion
        if(gameOver){
            paintExplosion(g);
        }


    }

    public void paintCircle(Graphics g){
        Point centerPosition = modelPointToViewPoint(new Point(0, (int)pos.get() ));
        //draw a point at the center of the circle
        g.drawOval((int)centerPosition.getX(), (int)centerPosition.getY(),1,1);
        g.drawOval((int)centerPosition.getX()-circleWidth/2, (int)centerPosition.getY()- circleHeight/2, circleWidth, circleHeight);
    }


    public void paintParcours(Graphics g){
        g.setColor(Color.BLACK);

        ArrayList<Point> points = parcours.getPoints();

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = modelPointToViewPoint(points.get(i)) ;
            Point p2 = modelPointToViewPoint(points.get(i+1));
            //print p1 and p2 's coordinate in console
            g.drawLine((int) (p1.getX()), (int) (p1.getY()), (int) (p2.getX()), (int) (p2.getY()));
        }
    }

    public void paintExplosion(Graphics g){
        g.setColor(Color.RED);

        Point realExplosionPoint = modelPointToViewPoint(explosionPoint);

        g.fillOval((int)realExplosionPoint.getX() - explosionSize/2, (int) realExplosionPoint.getY() - explosionSize/2, explosionSize, explosionSize);

        if(explosionSize < 50) {
            explosionSize += 3;

        }else{

            Main.GameOver();
        }
    }

}
