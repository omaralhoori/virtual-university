/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.ann;
import view.hoSetAnn;
import view.homePage;
import view.rootHome;

/**
 *
 * @author omar
 */
public class homePageLogic implements MouseListener {

    homePage jp;

    public homePageLogic(view.homePage jp) {

        this.jp = jp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jp.getAd()) {
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
