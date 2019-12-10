/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import view.ann;
import view.hoSetAnn;
import view.rootHome;

/**
 *
 * @author omar
 */
public class rootHomeLogic implements MouseListener {

    rootHome jp;

    public rootHomeLogic(rootHome jp) {

        this.jp = jp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jp.getAddAnn()) {
            new hoSetAnn();
        } else if (e.getSource() == jp.getAd()) {
            new ann(0);
        } else if (e.getSource() == jp.getAd2()) {
            new ann(1);
        } else if (e.getSource() == jp.getAd3()) {
            new ann(2);
        }
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
