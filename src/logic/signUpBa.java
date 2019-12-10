/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import view.SignIn;

/**
 *
 * @author omar
 */
public class signUpBa implements MouseListener {

    JLabel back;
    JFrame jf;
    SignIn jf2;
    //ImageIcon ico=new ImageIcon(this.getClass().getResource("/Icons/arr.png"));
    // BufferedImage img;
    public signUpBa(JLabel back, JFrame jf) {

        this.back = back;
        this.jf = jf;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jf.dispose();
        try {
            jf2 = new SignIn();
        } catch (IOException ex) {
            Logger.getLogger(signUpBa.class.getName()).log(Level.SEVERE, null, ex);
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
        //   back.setIcon(new ImageIcon(ico));
        back.setIcon(new ImageIcon(getClass().getResource("/Icons/arrow1.png")));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        back.setIcon(new ImageIcon(getClass().getResource("/Icons/arrow.png")));
    }

}
