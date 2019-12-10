/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 *
 * @author omar
 */
public class moveFrame implements MouseListener, MouseMotionListener {

    int xMouse;
    int yMouse;
    JFrame jf;

    public moveFrame(JFrame jf) {
        this.jf = jf;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        framedragMousePressed(e);
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

    @Override
    public void mouseDragged(MouseEvent e) {
        framedragMouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private void framedragMouseDragged(MouseEvent e) {

        int x = e.getXOnScreen();

        int y = e.getYOnScreen();

        jf.setLocation(x - xMouse, y - yMouse);

    }

    private void framedragMousePressed(MouseEvent e) {

        xMouse = e.getX();

        yMouse = e.getY();

    }

}
