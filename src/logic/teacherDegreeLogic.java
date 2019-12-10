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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import view.teacher;
import view.teacherDegree;

/**
 *
 * @author omar
 */
public class teacherDegreeLogic implements ActionListener, MouseListener, ItemListener, KeyListener {

    view.teacher tF;
    view.teacherDegree tD;

    public teacherDegreeLogic(view.teacher tF, view.teacherDegree tD) {
        this.tF = tF;
        this.tD = tD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (model.dbDegree.updateDegree(Integer.parseInt(tD.getData()[tD.table.getSelectedRow()][0]), tD.getCourses().getSelectedItem().toString(), Integer.parseInt(tD.getVize().getText()), Integer.parseInt(tD.getFinl().getText()))) {
            } else {
                JOptionPane.showMessageDialog(null, "Hata Oluştu", "Hata mesajı", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(teacherDegreeLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tD.table) {
            tD.getStuIdLabel().setText("Öğrenci No :  " + tD.getData()[tD.table.getSelectedRow()][0]);
            tD.getVize().setText(tD.getData()[tD.table.getSelectedRow()][1]);
            tD.getFinl().setText(tD.getData()[tD.table.getSelectedRow()][2]);
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
        tD.getTablePane().setViewportView(tD.getTable());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (e.getSource() == tD.table) {
                tD.getStuIdLabel().setText("Öğrenci No :  " + tD.getData()[tD.table.getSelectedRow()][0]);
                tD.getVize().setText(tD.getData()[tD.table.getSelectedRow()][1]);
                tD.getFinl().setText(tD.getData()[tD.table.getSelectedRow()][2]);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (e.getSource() == tD.table) {
                tD.getStuIdLabel().setText("Öğrenci No :  " + tD.getData()[tD.table.getSelectedRow()][0]);
                tD.getVize().setText(tD.getData()[tD.table.getSelectedRow()][1]);
                tD.getFinl().setText(tD.getData()[tD.table.getSelectedRow()][2]);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (e.getSource() == tD.table) {
                tD.getStuIdLabel().setText("Öğrenci No :  " + tD.getData()[tD.table.getSelectedRow()][0]);
                tD.getVize().setText(tD.getData()[tD.table.getSelectedRow()][1]);
                tD.getFinl().setText(tD.getData()[tD.table.getSelectedRow()][2]);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (e.getSource() == tD.table) {
                tD.getStuIdLabel().setText("Öğrenci No :  " + tD.getData()[tD.table.getSelectedRow()][0]);
                tD.getVize().setText(tD.getData()[tD.table.getSelectedRow()][1]);
                tD.getFinl().setText(tD.getData()[tD.table.getSelectedRow()][2]);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (e.getSource() == tD.table) {
                tD.getStuIdLabel().setText("Öğrenci No :  " + tD.getData()[tD.table.getSelectedRow()][0]);
                tD.getVize().setText(tD.getData()[tD.table.getSelectedRow()][1]);
                tD.getFinl().setText(tD.getData()[tD.table.getSelectedRow()][2]);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (e.getSource() == tD.table) {
                tD.getStuIdLabel().setText("Öğrenci No :  " + tD.getData()[tD.table.getSelectedRow()][0]);
                tD.getVize().setText(tD.getData()[tD.table.getSelectedRow()][1]);
                tD.getFinl().setText(tD.getData()[tD.table.getSelectedRow()][2]);
            }
        }
    }

}
