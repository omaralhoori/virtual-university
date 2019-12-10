/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import view.root;
import view.rootTeacher;

/**
 *
 * @author omar
 */
public class rootTeacherLogic implements ActionListener{
rootTeacher tP;
String gender;
root mf;
    public rootTeacherLogic(rootTeacher tP,root mf) {
    this.tP=tP;
    this.mf=mf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tP.getMale().isSelected()) {
                    gender = "male";
                } else {
                    gender = "female";
                }

    try {
        if (model.dbTea.insertTeacher(tP.getUser().getText(), tP.getPassword().getText(), tP.getEmail().getText(), gender, tP.getDepart().getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(null,   tP.getUser().getText() + " eklendi", "yeni kullanici", JOptionPane.INFORMATION_MESSAGE);
            mf.getMf().getContentPane().remove(1);
            mf.getMf().getContentPane().add(new rootTeacher(mf).getJp(), new AbsoluteConstraints(200, 0, 700, 550));
            mf.getMf().validate();
        }  else {
                    JOptionPane.showMessageDialog(null, "kullanici adi veya eposta kullanilimis ", "Kullanici/eposta hata", JOptionPane.WARNING_MESSAGE);
                }
        
    } catch (SQLException ex) {
        Logger.getLogger(rootTeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(rootTeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
