package main;

import view.Affichage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameOverPanel extends JPanel {

    public GameOverPanel() {
        JLabel gameOverLabel = new JLabel("Game Over");
        JLabel scoreLabel = new JLabel("Score: " + String.format("%.2f", Affichage.GetScore()));
        JButton reStartButton = new JButton("Restart");
        JButton menuButton = new JButton("Menu");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new java.awt.Dimension(500, 350));


        //Set the properties of the label
        gameOverLabel.setFont(new Font("Consola", Font.BOLD, 25));
        gameOverLabel.setForeground(Color.RED);
        gameOverLabel.setBorder(new EmptyBorder(0, 0, 10, 0));  // 下边距设置为10

        scoreLabel.setFont(new Font("Consola", Font.BOLD, 15));
        scoreLabel.setForeground(Color.black);
        scoreLabel.setBorder(new EmptyBorder(0, 0, 10, 0));  // 下边距设置为10

        //Set the alignements of the label and the button
        gameOverLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        reStartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(gameOverLabel);
        this.add(scoreLabel);
        this.add(reStartButton);
        this.add(menuButton);
        this.add(Box.createVerticalGlue());

        //add a listener to the button
        reStartButton.addActionListener(evt -> Main.GameStart());

        menuButton.addActionListener(evt -> Main.ShowMenu());
    }


}
