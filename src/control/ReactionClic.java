package control;

import model.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReactionClic implements MouseListener {

    private final Position pos;

    public ReactionClic(Position pos) {
        this.pos = pos;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        pos.jump();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

