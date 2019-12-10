/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import view.root;
import view.rootStudent;

/**
 *
 * @author omar
 */
public class rootStudentLogic implements MouseListener,ActionListener{
    rootStudent sp;
    root mf;
    int j,x;

    public rootStudentLogic(rootStudent sp,root mf) {
        this.sp = sp;
        this.mf=mf;
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {if(e.getSource()==sp.getTable()){
      j=sp.arr.get(sp.getTable().getSelectedRow()).getId();
      sp.getAdd().setText(j +" "+sp.arr.get(sp.getTable().getSelectedRow()).getDepart());
      
    }
    else if(e.getSource()==sp.getTable2()){
      x=sp.arr2.get(sp.getTable2().getSelectedRow()).getId();
      sp.getRemove().setText(x +" "+sp.arr2.get(sp.getTable2().getSelectedRow()).getDepart());
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
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sp.getAddBtn()){
        try {
            if(model.dbStuMa.insertStu(j, sp.arr.get(sp.getTable().getSelectedRow()).getDepart(), sp.getClas().getSelectedItem().toString())){
               JOptionPane.showMessageDialog(null, "Öğrenci Etkinleştirildi " , "yeni Öğrenci", JOptionPane.INFORMATION_MESSAGE);
               mf.getMf().getContentPane().remove(1);
                mf.getMf().getContentPane().add(new rootStudent(mf), new AbsoluteConstraints(200, 0, 700, 550));
                mf.getMf().validate();

            }
            else JOptionPane.showMessageDialog(null, "Hata Oluştu", "Hata mesajı", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(rootStudentLogic.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex) {
                Logger.getLogger(rootStudentLogic.class.getName()).log(Level.SEVERE, null, ex);
            }}
        else if(e.getSource()==sp.getRemoveBtn()){
           try {
            if(model.dbStuMa.deleteStu(x)){
                JOptionPane.showMessageDialog(null, "Öğrenci Silindi " , "", JOptionPane.INFORMATION_MESSAGE);
                               mf.getMf().getContentPane().remove(1);
                mf.getMf().getContentPane().add(new rootStudent(mf), new AbsoluteConstraints(200, 0, 700, 550));
                mf.getMf().validate();
            }
            else JOptionPane.showMessageDialog(null, "Hata Oluştu", "Hata mesajı", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(rootStudentLogic.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex) {  
                Logger.getLogger(rootStudentLogic.class.getName()).log(Level.SEVERE, null, ex);
            }  
            
        }
    }
    
}
