/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import logic.moveFrame;
import logic.resize;
import logic.studentLogic;
import logic.teacherLogic;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author omar
 */
public class student {

    JFrame sf;
    JPanel fram, header, exit, mini, homeBt, examBt, courseBt, degreeBt, lessonBt;
    JLabel name, number;
    String Name, Number;
    JScrollPane aside;
    studentLogic logic;
    moveFrame move;
    JLabel ho, co, de, ex, le;

    public student(String Name, String Number) throws IOException {
        this.Name = Name;
        this.Number = Number;
        getSf();
    }

    public JFrame getSf() throws IOException {
        if (sf == null) {
            sf = new JFrame("Öğreci Sayfası");

            sf.setUndecorated(true);
            sf.setSize(1000, 600);
            sf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            sf.getContentPane().setLayout(new AbsoluteLayout());
            sf.getContentPane().add(getFram(), new AbsoluteConstraints(0, 0, 1000, 30));
            sf.getContentPane().add(getAside(), new AbsoluteConstraints(0, 30, 200, 570));
            sf.getContentPane().add(getHeader(), new AbsoluteConstraints(200, 30, 800, 100));
            sf.getContentPane().add(new homePage(), new AbsoluteConstraints(200, 130, 1000, 570));
            sf.setVisible(true);

            sf.setLocationRelativeTo(null);
        }
        return sf;
    }

    public JPanel getFram() throws IOException {
        if (fram == null) {
            fram = new JPanel();
            fram.setBackground(new Color(220, 220, 220));
            fram.setPreferredSize(new Dimension(800, 30));
            javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(fram);
            fram.setLayout(pnHeaderLayout);
            pnHeaderLayout.setHorizontalGroup(
                    pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeaderLayout.createSequentialGroup()
                                    .addGap(0, 700, Short.MAX_VALUE)
                                    .addComponent(getMini(), javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(getExit(), javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            pnHeaderLayout.setVerticalGroup(
                    pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getExit())
                            .addComponent(getMini())
            );

            //-----------------------------------------
            fram.addMouseListener(getMove());
            fram.addMouseMotionListener(getMove());
            fram.add(getExit());

        }
        return fram;
    }

    public JPanel getExit() {
        if (exit == null) {
            exit = new JPanel();
            exit.setBackground(new Color(220, 220, 220));
            ImageIcon ico1 = new ImageIcon(getClass().getResource("/Icons/exitBtn.png"));
            ImageIcon ico2 = new ImageIcon(getClass().getResource("/Icons/exitRedBtn.png"));
            JLabel btn = new JLabel(ico1);

            exit.add(btn);
            exit.addMouseListener(getLogic());
            exit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setIcon(ico2);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setIcon(ico1);
                }

            });

            exit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        }
        return exit;
    }

    public JPanel getMini() {
        if (mini == null) {
            mini = new JPanel();
            mini.setBackground(new Color(220, 220, 220));
            ImageIcon ico1 = new ImageIcon(getClass().getResource("/Icons/MiniBtn.png"));
            ImageIcon ico2 = new ImageIcon(getClass().getResource("/Icons/MiniGrBtn.png"));
            JLabel btn = new JLabel(ico1);

            mini.setCursor(new Cursor(Cursor.HAND_CURSOR));
            mini.add(btn);
            mini.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setIcon(ico2);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setIcon(ico1);
                }

            });
            mini.addMouseListener(getLogic());

        }
        return mini;
    }

    public JScrollPane getAside() {
        if (aside == null) {
            aside = new JScrollPane();
            aside.setBackground(new Color(130, 130, 130));
            aside.setBounds(0, 0, 200, 570);
            aside.setBorder(null);
            aside.setPreferredSize(new Dimension(200, 570));
            aside.setFocusable(true);
            aside.setLayout(null);
            aside.add(getHomeBt());
            aside.add(getExamBt());
            aside.add(getCourseBt());
            aside.add(getDegreeBt());
            aside.add(getLessonBt());

        }
        return aside;
    }

    public JPanel getHomeBt() {
        if (homeBt == null) {
            homeBt = new JPanel();
            ho = new JLabel("Ana Sayfa");

            homeBt.setBounds(0, 80, 200, 60);
            homeBt.setBackground(new Color(130, 130, 130));
            homeBt.add(ho);
            homeBt.setLayout(null);
            ho.setForeground(new Color(250, 250, 250));
            ho.setFont(new Font("Segoe UI", 1, 16));
            ho.setIcon(new ImageIcon(getClass().getResource("/Icons/Home.png")));
            ho.setBounds(25, 9, 175, 40);
            homeBt.setCursor(new Cursor(HAND_CURSOR));
            homeBt.addMouseListener(getLogic());

        }
        return homeBt;
    }

    public JPanel getExamBt() {
        if (examBt == null) {
            examBt = new JPanel();

            examBt.setBounds(0, 160, 200, 60);
            examBt.setBackground(new Color(130, 130, 130));
            examBt.add(ex = new JLabel("Sınavlar"));
            examBt.setLayout(null);
            ex.setForeground(new Color(250, 250, 250));
            ex.setFont(new Font("Segoe UI", 1, 16));
            ex.setIcon(new ImageIcon(getClass().getResource("/Icons/ExamWh.png")));
            ex.setBounds(25, 9, 175, 40);
            examBt.setCursor(new Cursor(HAND_CURSOR));
            examBt.addMouseListener(getLogic());
        }
        return examBt;
    }

    public JPanel getCourseBt() {
        if (courseBt == null) {
            courseBt = new JPanel();

            courseBt.setBounds(0, 240, 200, 60);
            courseBt.setBackground(new Color(130, 130, 130));
            courseBt.add(co = new JLabel("Dersler"));
            courseBt.setLayout(null);
            co.setForeground(new Color(250, 250, 250));
            co.setFont(new Font("Segoe UI", 1, 16));
            co.setIcon(new ImageIcon(getClass().getResource("/Icons/CourseWh.png")));
            co.setBounds(25, 9, 175, 40);
            courseBt.setCursor(new Cursor(HAND_CURSOR));
            courseBt.addMouseListener(getLogic());
        }
        return courseBt;
    }

    public JPanel getDegreeBt() {
        if (degreeBt == null) {
            degreeBt = new JPanel();

            degreeBt.setBounds(0, 320, 200, 60);
            degreeBt.setBackground(new Color(130, 130, 130));
            degreeBt.add(de = new JLabel("Notlar"));
            degreeBt.setLayout(null);
            de.setForeground(new Color(250, 250, 250));
            de.setFont(new Font("Segoe UI", 1, 16));
            de.setIcon(new ImageIcon(getClass().getResource("/Icons/DegreeWh.png")));
            de.setBounds(25, 9, 175, 40);
            degreeBt.setCursor(new Cursor(HAND_CURSOR));
            degreeBt.addMouseListener(getLogic());
        }
        return degreeBt;
    }

    public JPanel getLessonBt() {
        if (lessonBt == null) {
            lessonBt = new JPanel();

            lessonBt.setBounds(0, 400, 200, 60);
            lessonBt.setBackground(new Color(130, 130, 130));
            lessonBt.add(le = new JLabel("Derse Yazılım"));
            lessonBt.setLayout(null);
            le.setForeground(new Color(250, 250, 250));
            le.setFont(new Font("Segoe UI", 1, 16));
            le.setIcon(new ImageIcon(getClass().getResource("/Icons/Edit.png")));
            le.setBounds(25, 9, 175, 40);
            lessonBt.setCursor(new Cursor(HAND_CURSOR));
            lessonBt.addMouseListener(getLogic());
        }
        return lessonBt;
    }

    public JPanel getHeader() throws IOException {
        if (header == null) {
            header = new JPanel();
            String path = "/Icons/Twitter_96px.png";
            JLabel su = new JLabel(new ImageIcon(getClass().getResource("/Icons/Exit_25.png")));
            JLabel se = new JLabel(new ImageIcon(getClass().getResource("/Icons/Settings_25.png")));
            if (getClass().getResource(path) != null) {
                path = getClass().getResource(path).getPath();
            } else {
                path = getClass().getResource("/Icons/NoUser.png").getPath();
            }
            JLabel pic = new JLabel(new ImageIcon(new resize(path).img1));
            header.setBackground(new Color(82, 184, 251));
            header.setBounds(0, 0, 1000, 100);
            header.setLayout(null);
            header.setPreferredSize(new Dimension(1000, 100));
            pic.setBounds(650, 10, 80, 80);
            su.setBounds(755, 63, 25, 25);
            se.setBounds(730, 63, 25, 25);
            se.setCursor(new Cursor(HAND_CURSOR));
            su.setCursor(new Cursor(HAND_CURSOR));
            su.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        getSf().dispose();
                        new SignIn();
                    } catch (IOException ex) {
                        Logger.getLogger(teacher.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
            header.add(se);
            header.add(pic);
            header.add(su);
            header.add(getName());
            header.add(getNumber());

        }
        return header;
    }

    public JLabel getName() {
        if (name == null) {
            name = new JLabel(Name);
            name.setForeground(Color.WHITE);
            name.setBounds(740, 27, 100, 20);
            name.setFont(new Font("Staatliches", 1, 15));
        }
        return name;
    }

    public JLabel getNumber() {
        if (number == null) {
            number = new JLabel(Number);
            number.setBounds(740, 42, 80, 20);
            number.setFont(new Font("Segoe UI", 0, 10));
            number.setForeground(Color.GRAY);
        }
        return number;
    }

    public studentLogic getLogic() {
        if (logic == null) {
            logic = new studentLogic(this);
        }
        return logic;
    }

    public moveFrame getMove() throws IOException {
        if (move == null) {
            move = new moveFrame(this.getSf());
        }
        return move;
    }

}
