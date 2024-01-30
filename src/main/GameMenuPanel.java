package main;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameMenuPanel extends JPanel{
    //constructor
    public GameMenuPanel(){
        JLabel label = new JLabel("CIRCLE");
        JButton startButton = new JButton("Start");
        JButton quitButton = new JButton("Quit");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new java.awt.Dimension(500, 350));

        //Set the properties of the label
        label.setFont(new Font("Consola", Font.BOLD, 25));
        label.setForeground(Color.ORANGE);
        label.setBorder(new EmptyBorder(0, 0, 10, 0));  //set the padding of the label

        //Set the alignements of the label and the button
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(label);
        this.add(startButton);
        this.add(quitButton);
        this.add(Box.createVerticalGlue());

        this.setVisible(true);
        //add a listener to the button
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.GameStart();
            }
        });

        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
    }
}
