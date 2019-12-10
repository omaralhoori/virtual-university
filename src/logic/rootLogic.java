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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import view.root;
import view.rootHome;
import view.rootLesson;
import view.rootStudent;
import view.rootTeacher;
import view.SignIn;
/**
 *
 * @author omar
 */
public class rootLogic implements MouseListener{
    JPanel btn;
    root jf;
    public rootLogic(JPanel btn,root jf) {
        this.btn = btn;
        this.jf=jf;
    }
    

  
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()==jf.getHomeBt()){
            
            try {
                jf.getMf().getContentPane().remove(1);
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jf.getMf().getContentPane().add(new rootHome(jf.getMf()), new AbsoluteConstraints(200, 0, 700, 550));
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jf.getMf().validate();
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        else if(e.getSource()==jf.getStudenBt()){
            try {
                jf.getMf().getContentPane().remove(1);
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jf.getMf().getContentPane().add(new rootStudent(jf), new AbsoluteConstraints(200, 0, 700, 550));
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jf.getMf().validate();
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()==jf.getTeacherBt()){
            try {
                jf.getMf().getContentPane().remove(1);
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jf.getMf().getContentPane().add(new rootTeacher(jf).getJp(), new AbsoluteConstraints(200, 0, 700, 550));
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jf.getMf().validate();
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           else if(e.getSource()==jf.getLessonBt()){
            try {
                jf.getMf().getContentPane().remove(1);
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jf.getMf().getContentPane().add(new rootLesson(jf).getJp(), new AbsoluteConstraints(200, 0, 700, 550));
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jf.getMf().validate();
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           else if(e.getSource()==jf.getExtBt()){
            try {
                jf.getMf().dispose();
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new SignIn();
            } catch (IOException ex) {
                Logger.getLogger(rootLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        btn.setBackground(new Color(102,0,102));
    }

    @Override
    public void mouseExited(MouseEvent e) {
         btn.setBackground(new Color(51, 51, 51));
    }
    
    
    
}
