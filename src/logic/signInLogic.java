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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.dbSign;
import static model.dbSign.getUsers;
import model.users;
import view.root;
import view.SignIn;
import view.SignUp;

/**
 *
 * @author omar
 */
public class signInLogic implements MouseListener {

    SignIn jf;
    SignUp jf2;
    JPanel sgin;
    JLabel si;
    String name, numbre;

    public signInLogic(JPanel sgin, JLabel si, SignIn jf) {
        this.sgin = sgin;
        this.si = si;
        this.jf = jf;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jf.getSgin()) {

            int i = dbSign.checkUser(jf.getUser().getText(), jf.getPassword().getText());
            switch (i) {
                case 0:
                    JOptionPane.showMessageDialog(null, "user is not exist", "erro user", JOptionPane.WARNING_MESSAGE);
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "hello " + jf.getUser().getText(), "Welcome", JOptionPane.INFORMATION_MESSAGE);

                     {
                        try {
                            jf.getJf().dispose();
                            check();
                            new view.teacher(name, numbre);
                        } catch (IOException ex) {
                            Logger.getLogger(signInLogic.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "wrong password", "erro password", JOptionPane.WARNING_MESSAGE);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "hello " + jf.getUser().getText(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
                     {
                        try {
                            jf.getJf().dispose();

                        } catch (IOException ex) {
                            Logger.getLogger(signInLogic.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                     {
                        try {
                            new root();
                        } catch (IOException ex) {
                            Logger.getLogger(signInLogic.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "hello " + jf.getUser().getText(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
                     {
                        try {
                            jf.getJf().dispose();

                        } catch (IOException ex) {
                            Logger.getLogger(signInLogic.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                     {
                        try {
                            check();
                            new view.student(name, numbre);
                        } catch (IOException ex) {
                            Logger.getLogger(signInLogic.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                default:
                    break;
            }
        } else if (e.getSource() == jf.getSgup()) {
            try {
                jf.getJf().dispose();
                jf2 = new SignUp();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

        sgin.setBackground(new Color(153, 0, 204));
        si.setForeground(new Color(240, 240, 240));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // sgin.setBorder(new LineBorder(new Color(136, 23, 193), 2, true));
        sgin.setBackground(new Color(136, 23, 193));
        si.setForeground(Color.white);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //   jp1.setBackground(new Color(102,255,153));

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    void check() {
        ArrayList<users> arr = model.dbSign.getUsers();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getUserName().equalsIgnoreCase(jf.getUser().getText())) {
                name = arr.get(i).getUserName();
                numbre = arr.get(i).getDepartMent().substring(0, 2) + arr.get(i).getId();
            }

        }
    }

}
