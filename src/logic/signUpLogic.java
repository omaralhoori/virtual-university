/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.SignIn;
import view.SignUp;

/**
 *
 * @author omar
 */
public class signUpLogic implements MouseListener {

    SignUp jf;
    JPanel sgup;
    JLabel su;
    SignIn jf2;
    String gender;

    public signUpLogic(SignUp jf, JPanel sgup, JLabel su) {
        this.jf = jf;
        this.sgup = sgup;
        this.su = su;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == jf.getSgup()) {
            try {
                if (jf.getMale().isSelected()) {
                    gender = "male";
                } else {
                    gender = "female";
                }

                if (model.dbSign.insertUser(jf.getUser().getText(), jf.getPassword().getText(), jf.getEmail().getText(), gender, jf.getDepart().getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(null, "merhaba " + jf.getUser().getText(), "yeni kullanici", JOptionPane.INFORMATION_MESSAGE);
                    jf.getJf2().dispose();
                    new SignIn();
                } else {
                    JOptionPane.showMessageDialog(null, "kullanici adi veya eposta kullanilimis ", "Kullanici/eposta hata", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(signUpLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        sgup.setBackground(new Color(153, 0, 204));
        su.setForeground(new Color(240, 240, 240));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        sgup.setBackground(new Color(136, 23, 193));
        su.setForeground(Color.white);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
