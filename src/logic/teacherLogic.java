/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.teacher;
import java.awt.Color;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import view.homePage;
import view.teacherCourses;
import view.teacherDegree;
import view.teacherExams;
/**
 *
 * @author omar
 */
public class teacherLogic implements MouseListener{
    view.teacher tF;
    public teacherLogic(teacher tF) {
        this.tF = tF;
     
    }

 
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
       if(e.getSource()==tF.getExit()){
            System.exit(0);
        }
      
        else if(e.getSource()==tF.getMini()){
            try {
                tF.getTf().setState(Frame.ICONIFIED);
            } catch (IOException ex) {
                Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(e.getSource()==tF.getHomeBt()){
           try {
               tF.getTf().getContentPane().remove(3);
               tF.getTf().getContentPane().add(new homePage(),new AbsoluteConstraints(200, 130, 1000, 570));
               tF.getTf().validate();
           } catch (IOException ex) {
               Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        else if(e.getSource()==tF.getCourseBt()){
            try {
              tF.getTf().getContentPane().remove(3);
                tF.getTf().getContentPane().add(new teacherCourses(tF.getName().getText()), new AbsoluteConstraints(200, 130, 1000, 570));
                tF.getTf().validate();
            } catch (IOException ex) {
                Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(e.getSource()==tF.getExamBt()){
            try {
                tF.getTf().getContentPane().remove(3);
                tF.getTf().getContentPane().add(new teacherExams(tF.getName().getText()), new AbsoluteConstraints(200, 130, 1000, 570));
                tF.getTf().validate();
            } catch (IOException ex) {
                Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()==tF.getDegreeBt()){
           try {
               tF.getTf().getContentPane().remove(3);
               tF.getTf().getContentPane().add(new teacherDegree(tF.getName().getText(),tF),new AbsoluteConstraints(200, 130, 1000, 570));
               tF.getTf().validate();
           } catch (IOException ex) {
               Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
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
        if(e.getSource()==tF.getHomeBt()){
            tF.getHomeBt().setBackground(new Color(11,145,209));
        }
        
         if(e.getSource()==tF.getExamBt()){
            tF.getExamBt().setBackground(new Color(11,145,209));
        }
          if(e.getSource()==tF.getDegreeBt()){

            tF.getDegreeBt().setBackground(new Color(11,145,209));
        }
           if(e.getSource()==tF.getCourseBt()){
            tF.getCourseBt().setBackground(new Color(11,145,209));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
          if(e.getSource()==tF.getHomeBt()){
            tF.getHomeBt().setBackground(new Color(130,130,130));
        }
        
        
           if(e.getSource()==tF.getExamBt()){
            tF.getExamBt().setBackground(new Color(130,130,130));
        }
             if(e.getSource()==tF.getDegreeBt()){
            tF.getDegreeBt().setBackground(new Color(130,130,130));
        }
               if(e.getSource()==tF.getCourseBt()){
            tF.getCourseBt().setBackground(new Color(130,130,130));
        }
    }
    
}
