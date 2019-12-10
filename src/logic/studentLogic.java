/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import view.homePage;
import view.studentCourses;
import view.studentDegree;
import view.studentDerseYazilim;
import view.studentExams;

/**
 *
 * @author omar
 */
public class studentLogic implements MouseListener {

    view.student sF;

    public studentLogic(view.student sF) {
        this.sF = sF;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == sF.getExit()) {
            System.exit(0);
        } else if (e.getSource() == sF.getMini()) {
            try {
                sF.getSf().setState(Frame.ICONIFIED);
            } catch (IOException ex) {
                Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == sF.getHomeBt()) {
            try {
                sF.getSf().getContentPane().remove(3);
                sF.getSf().getContentPane().add(new homePage(), new AbsoluteConstraints(200, 130, 1000, 570));
                sF.getSf().validate();
            } catch (IOException ex) {
                Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == sF.getCourseBt()) {
            try {
                sF.getSf().getContentPane().remove(3);
                sF.getSf().getContentPane().add(new studentCourses(Integer.parseInt(sF.getNumber().getText().substring(2))), new AbsoluteConstraints(200, 130, 1000, 570));
                sF.getSf().validate();
            } catch (IOException ex) {
                Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == sF.getExamBt()) {
            try {
                sF.getSf().getContentPane().remove(3);
                sF.getSf().getContentPane().add(new studentExams(Integer.parseInt(sF.getNumber().getText().substring(2))), new AbsoluteConstraints(200, 130, 1000, 570));
                sF.getSf().validate();
            } catch (IOException ex) {
                Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == sF.getDegreeBt()) {
            try {
                sF.getSf().getContentPane().remove(3);
                sF.getSf().getContentPane().add(new studentDegree(Integer.parseInt(sF.getNumber().getText().substring(2))), new AbsoluteConstraints(200, 130, 1000, 570));
                sF.getSf().validate();
            } catch (IOException ex) {
                Logger.getLogger(teacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == sF.getLessonBt()) {
            try {
                sF.getSf().getContentPane().remove(3);
                sF.getSf().getContentPane().add(new studentDerseYazilim(Integer.parseInt(sF.getNumber().getText().substring(2)), sF), new AbsoluteConstraints(200, 130, 1000, 570));
                sF.getSf().validate();
            } catch (IOException ex) {
                Logger.getLogger(studentLogic.class.getName()).log(Level.SEVERE, null, ex);
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
        if (e.getSource() == sF.getHomeBt()) {
            sF.getHomeBt().setBackground(new Color(11, 145, 209));
        }
        if (e.getSource() == sF.getExamBt()) {
            sF.getExamBt().setBackground(new Color(11, 145, 209));
        }
        if (e.getSource() == sF.getDegreeBt()) {

            sF.getDegreeBt().setBackground(new Color(11, 145, 209));
        }
        if (e.getSource() == sF.getCourseBt()) {
            sF.getCourseBt().setBackground(new Color(11, 145, 209));
        }
        if (e.getSource() == sF.getLessonBt()) {
            sF.getLessonBt().setBackground(new Color(11, 145, 209));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == sF.getHomeBt()) {
            sF.getHomeBt().setBackground(new Color(130, 130, 130));
        }

        if (e.getSource() == sF.getExamBt()) {
            sF.getExamBt().setBackground(new Color(130, 130, 130));
        }
        if (e.getSource() == sF.getDegreeBt()) {
            sF.getDegreeBt().setBackground(new Color(130, 130, 130));
        }
        if (e.getSource() == sF.getCourseBt()) {
            sF.getCourseBt().setBackground(new Color(130, 130, 130));
        }
        if (e.getSource() == sF.getLessonBt()) {
            sF.getLessonBt().setBackground(new Color(130, 130, 130));
        }
    }

}
