/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import view.root;
import view.rootLesson;

/**
 *
 * @author omar
 */
public class rootLessontLogic implements ActionListener, MouseListener, ItemListener {

    rootLesson lP;
    root mf;
    int j = 0;

    public rootLessontLogic(rootLesson lP, root mf) {
        this.mf = mf;
        this.lP = lP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lP.getRemov()) {
            try {
                if (model.dbCor.deleteCor(j)) {

                    JOptionPane.showMessageDialog(null, "Ders silindi ", "Ders işlemi", JOptionPane.INFORMATION_MESSAGE);
                    mf.getMf().getContentPane().remove(1);
                    mf.getMf().getContentPane().add(new rootLesson(mf).getJp(), new AbsoluteConstraints(200, 0, 700, 550));
                    mf.getMf().validate();
                } else {
                    JOptionPane.showMessageDialog(null, "Hata Oluştu", "Hata mesajı", JOptionPane.WARNING_MESSAGE);
                }

            } catch (IOException ex) {
                Logger.getLogger(rootLessontLogic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(rootLessontLogic.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == lP.getAddBtn()) {
            try {
                if (model.dbCor.insertCor(lP.getCorNam().getText(), lP.getDepar().getSelectedItem().toString(), lP.teache.getSelectedItem().toString(), lP.getCla().getSelectedItem().toString())) {

                    JOptionPane.showMessageDialog(null, "Ders Eklendi ", "yeni Ders", JOptionPane.INFORMATION_MESSAGE);
                    mf.getMf().getContentPane().remove(1);
                    mf.getMf().getContentPane().add(new rootLesson(mf).getJp(), new AbsoluteConstraints(200, 0, 700, 550));
                    mf.getMf().validate();

                }
            } catch (SQLException ex) {
                Logger.getLogger(rootLessontLogic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(rootLessontLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lP.getTable()) {
            j = lP.arr.get(lP.getTable().getSelectedRow()).getCorId();
            lP.getRemove().setText(j + " " + lP.arr.get(lP.getTable().getSelectedRow()).getCorName());
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == lP.getDepar()) {

            try {
                lP.getJp().remove(16);
                lP.getJp().add(lP.getTeache());
                lP.getJp().validate();
            } catch (IOException ex) {
                Logger.getLogger(rootLessontLogic.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
