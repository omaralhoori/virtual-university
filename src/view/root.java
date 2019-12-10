/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logic.rootLogic;
import logic.moveFrame;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author omar
 */
public class root {

    JFrame mf;
    JPanel aside, homeBt, studenBt, teacherBt, lessonBt, extBt;//main,
    moveFrame move;

    public moveFrame getMove() throws IOException {
        if (move == null) {
            move = new moveFrame(this.getMf());
        }
        return move;
    }

    public JPanel getExtBt() {
        if (extBt == null) {
            extBt = new JPanel();
            JLabel ex;
            extBt.setBounds(0, 360, 200, 60);
            extBt.setBackground(new Color(51, 51, 51));
            extBt.add(ex = new JLabel("Çıkış"));
            extBt.setLayout(null);
            ex.setForeground(Color.WHITE);
            ex.setFont(new Font("Segoe UI", 1, 16));
            ex.setIcon(new ImageIcon(getClass().getResource("/Icons/Exit.png")));
            ex.setBounds(25, 9, 175, 40);
            extBt.setCursor(new Cursor(HAND_CURSOR));
            extBt.addMouseListener(new rootLogic(this.getExtBt(), this));

        }

        return extBt;
    }

    public void setExtBt(JPanel extBt) {
        this.extBt = extBt;
    }

    public JPanel getHomeBt() {
        if (homeBt == null) {
            homeBt = new JPanel();
            JLabel ho;
            homeBt.setBounds(0, 80, 200, 60);
            homeBt.setBackground(new Color(51, 51, 51));
            homeBt.add(ho = new JLabel("Ana Sayfa"));
            homeBt.setLayout(null);
            ho.setForeground(Color.WHITE);
            ho.setFont(new Font("Segoe UI", 1, 16));
            ho.setIcon(new ImageIcon(getClass().getResource("/Icons/Home.png")));
            ho.setBounds(25, 9, 175, 40);
            homeBt.setCursor(new Cursor(HAND_CURSOR));
            homeBt.addMouseListener(new rootLogic(this.getHomeBt(), this));

        }
        return homeBt;
    }

    public void setHomeBt(JPanel homeBt) {
        this.homeBt = homeBt;
    }

    public JPanel getStudenBt() {
        if (studenBt == null) {
            studenBt = new JPanel();
            JLabel su;
            studenBt.setBounds(0, 150, 200, 60);
            studenBt.setBackground(new Color(51, 51, 51));
            studenBt.add(su = new JLabel("Öğrenciller"));
            studenBt.setLayout(null);
            su.setForeground(Color.WHITE);
            su.setFont(new Font("Segoe UI", 1, 16));
            su.setIcon(new ImageIcon(getClass().getResource("/Icons/Student.png")));
            su.setBounds(25, 9, 175, 40);
            studenBt.setCursor(new Cursor(HAND_CURSOR));
            studenBt.addMouseListener(new rootLogic(this.getStudenBt(), this));

        }

        return studenBt;
    }

    public void setStudenBt(JPanel studenBt) {
        this.studenBt = studenBt;
    }

    public JPanel getTeacherBt() {
        if (teacherBt == null) {
            teacherBt = new JPanel();
            JLabel te;
            teacherBt.setBounds(0, 220, 200, 60);
            teacherBt.setBackground(new Color(51, 51, 51));
            teacherBt.add(te = new JLabel("Hocalar"));
            teacherBt.setLayout(null);
            te.setForeground(Color.WHITE);
            te.setFont(new Font("Segoe UI", 1, 16));
            te.setIcon(new ImageIcon(getClass().getResource("/Icons/Teacher.png")));
            te.setBounds(25, 9, 175, 40);
            teacherBt.setCursor(new Cursor(HAND_CURSOR));
            teacherBt.addMouseListener(new rootLogic(this.getTeacherBt(), this));

        }

        return teacherBt;
    }

    public void setTeacherBt(JPanel teacherBt) {
        this.teacherBt = teacherBt;
    }

    public JPanel getLessonBt() {
        if (lessonBt == null) {
            lessonBt = new JPanel();
            JLabel les;
            lessonBt.setBounds(0, 290, 200, 60);
            lessonBt.setBackground(new Color(51, 51, 51));
            lessonBt.add(les = new JLabel("Dersler"));
            lessonBt.setLayout(null);
            les.setForeground(Color.WHITE);
            les.setFont(new Font("Segoe UI", 1, 16));
            les.setIcon(new ImageIcon(getClass().getResource("/Icons/Lesson.png")));
            les.setBounds(25, 9, 175, 40);
            lessonBt.setCursor(new Cursor(HAND_CURSOR));
            lessonBt.addMouseListener(new rootLogic(this.getLessonBt(), this));

        }

        return lessonBt;
    }

    public void setLessonBt(JPanel lessonBt) {
        this.lessonBt = lessonBt;
    }

    public JPanel getAside() {
        if (aside == null) {
            aside = new JPanel();
            // aside.add(getEbt().getLa(getMf()));
            aside.add(getHomeBt());
            aside.add(getStudenBt());
            aside.add(getTeacherBt());
            aside.add(getLessonBt());
            aside.add(getExtBt());
            aside.setBackground(new Color(51, 51, 51));
            aside.setLayout(null);

        }
        return aside;
    }

    public void setAside(JPanel aside) {
        this.aside = aside;
    }

    public root() throws IOException {
        getMf();

    }

    public JFrame getMf() throws IOException {
        if (mf == null) {
            mf = new JFrame("Mudur Sayfasi");
            mf.getContentPane().setLayout(new AbsoluteLayout());
            mf.getContentPane().add(getAside(), new AbsoluteConstraints(0, 0, 200, 550));
            mf.getContentPane().add(new rootHome(getMf()), new AbsoluteConstraints(200, 0, 700, 550));
            mf.setUndecorated(true);
            mf.addMouseListener(getMove());
            mf.addMouseMotionListener(getMove());
            //mf.setLocation(250, 110);

            mf.setVisible(true);
            mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            mf.setSize(900, 550);
            mf.setLocationRelativeTo(null);

        }

        return mf;
    }

    public void setMf(JFrame mf) {
        this.mf = mf;
    }

}
