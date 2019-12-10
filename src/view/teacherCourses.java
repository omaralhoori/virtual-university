/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author omar
 */
public class teacherCourses extends JPanel {

    JScrollPane sp, des;
    JPanel lastCourses;
    JLabel titleLabel, linkLabel, descLabel, coursLabel;
    JTextField title, link;
    JTextArea desc;
    public ArrayList<model.course> arr = model.dbCor.getCourse();
    public ArrayList<model.lesson> arr2 = model.dbLesson.getLesson();
    String[] cours;
    String[][] les;
    String name;
    JButton addBtn;
    JComboBox<String> courses;

    public teacherCourses(String name) {
        this.name = name;
        setLayout(null);
        add(getSp());
        add(getTitleLabel());
        add(getTitle());
        add(getLink());
        add(getDes());
        add(getCourses());
        add(getDescLabel());
        add(getLinkLabel());
        add(getCoursLabel());
        add(getAddBtn());
    }

    public String[][] getLes() {
        if (les == null) {
            String[][] data = new String[arr2.size()][5];
            int z = 0;
            for (int i = 0; i < getCours().length; i++) {
                for (int j = 0; j < arr2.size(); j++) {
                    if (getCours()[i].equalsIgnoreCase(arr2.get(j).getCorName())) {
                        data[z][0] = arr2.get(j).getLesTitle();
                        data[z][1] = arr2.get(j).getLesTime();
                        data[z][2] = arr2.get(j).getLesLink();
                        data[z][3] = arr2.get(j).getCorName();
                        data[z][4] = arr2.get(j).getLesDesc();
                        z++;
                    }
                }
            }
            les = new String[z][5];
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < 5; j++) {
                    les[i][j] = data[i][j];
                }
            }

        }
        return les;

    }

    public JPanel getLastCours() {
        if (lastCourses == null) {
            lastCourses = new JPanel();
            lastCourses.setLayout(new BoxLayout(lastCourses, BoxLayout.PAGE_AXIS));

            for (int i = 0; i < getLes().length; i++) {
                String[] temp = new String[5];
                for (int j = 0; j < 5; j++) {
                    temp[j] = getLes()[i][j];
                }
                lastCourses.add(new lesson(temp));
                lastCourses.add(Box.createRigidArea(new Dimension(0, 10)));
            }

        }
        return lastCourses;
    }

    public JScrollPane getSp() {
        if (sp == null) {
            sp = new JScrollPane(getLastCours());

            sp.setBounds(40, 20, 720, 260);
            sp.setBorder(null);
        }
        return sp;
    }

    public JLabel getTitleLabel() {
        if (titleLabel == null) {
            titleLabel = new JLabel("Başlık : ");
            titleLabel.setBounds(20, 300, 80, 20);
        }
        return titleLabel;
    }

    public JLabel getLinkLabel() {
        if (linkLabel == null) {
            linkLabel = new JLabel("Bağlantı : ");
            linkLabel.setBounds(20, 330, 80, 20);
        }
        return linkLabel;
    }

    public JLabel getDescLabel() {
        if (descLabel == null) {
            descLabel = new JLabel("Açıklama : ");
            descLabel.setBounds(370, 300, 80, 20);
        }
        return descLabel;
    }

    public JLabel getCoursLabel() {
        if (coursLabel == null) {
            coursLabel = new JLabel("Ders : ");
            coursLabel.setBounds(20, 415, 80, 20);
        }
        return coursLabel;
    }

    public JScrollPane getDes() {
        if (des == null) {
            des = new JScrollPane(getDesc());
            des.setBounds(450, 300, 250, 100);
        }
        return des;
    }

    public JTextField getTitle() {
        if (title == null) {
            title = new JTextField();
            title.setBounds(120, 300, 200, 20);
        }
        return title;
    }

    public JTextField getLink() {
        if (link == null) {
            link = new JTextField();
            link.setBounds(120, 330, 200, 20);
        }
        return link;
    }

    public JTextArea getDesc() {
        if (desc == null) {
            desc = new JTextArea();
            desc.setLineWrap(true);

        }
        return desc;
    }

    public String[] getCours() {
        cours = new String[arr.size()];
        int j = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (name.equals(arr.get(i).getTeaId())) {
                cours[j] = arr.get(i).getCorName();
                j++;
            }
        }

        String[] dat = new String[j];
        for (int i = 0; i < j; i++) {
            dat[i] = cours[i];
        }

        return dat;

    }

    public JButton getAddBtn() {
        if (addBtn == null) {
            addBtn = new JButton("Ders Ekle");
            addBtn.setBounds(600, 415, 100, 30);
            addBtn.addActionListener(e -> {
                try {
                    if (model.dbLesson.insertLesson(getTitle().getText(), getLink().getText(), getCourses().getSelectedItem().toString(), getDesc().getText())) {
                        JOptionPane.showMessageDialog(null, "Sınav eklendi", "yeni Sınav", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(teacherExams.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
        }
        return addBtn;
    }

    public JComboBox<String> getCourses() {
        DefaultComboBoxModel df = new DefaultComboBoxModel<>(getCours());
        if (courses == null) {
            courses = new JComboBox<>();
            courses.setModel(df);
            courses.setBounds(120, 415, 200, 30);

        }

        return courses;
    }

}
