/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author omar
 */
public class studentExams extends JPanel {

    JScrollPane sp;
    JPanel lastExams;
    public ArrayList<model.degree> arr = model.dbDegree.getDegree();
    public ArrayList<model.exam> arr2 = model.dbExam.getExam();
    String[] cours;
    String[][] exam;
    int id;int u;
    JComboBox<String> courses;

    public studentExams(int id) {
        this.id = id;
        setLayout(null);
        add(getCourses());
        add(getSp());
    }

    public String[][] getExam() {

        String[][] data = new String[arr2.size()][5];
        int z = 0;

        for (int j = 0; j < arr2.size(); j++) {
            if(u==0)break;
            if (getCourses().getSelectedItem().toString().equalsIgnoreCase(arr2.get(j).getCorName())) {
                data[z][0] = arr2.get(j).getExName();
                data[z][1] = arr2.get(j).getExTime();
                data[z][2] = arr2.get(j).getExLink();
                data[z][3] = arr2.get(j).getCorName();
                data[z][4] = arr2.get(j).getExDesc();
                z++;
            }
        }

        exam = new String[z][5];
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < 5; j++) {
                exam[i][j] = data[i][j];
            }
        }

        return exam;

    }

    public JPanel getLastExams() {
       
            lastExams = new JPanel();
            lastExams.setLayout(new BoxLayout(lastExams, BoxLayout.PAGE_AXIS));

            for (int i = 0; i < getExam().length; i++) {
                String[] temp = new String[5];
                for (int j = 0; j < 5; j++) {
                    temp[j] = getExam()[i][j];
                }
                lastExams.add(new exam(temp));
                lastExams.add(Box.createRigidArea(new Dimension(0, 10)));
            }

        
        return lastExams;
    }

    public JScrollPane getSp() {
        if (sp == null) {
            sp = new JScrollPane(getLastExams());
            sp.setBounds(50, 20, 720, 390);
            sp.setBorder(null);
        }
        return sp;
    }

    public String[] getCours() {
        cours = new String[arr.size()];
        u = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (id==arr.get(i).getStuId()) {
                cours[u] = arr.get(i).getCorId();
                u++;
            }
        }

        String[] dat = new String[u];
        for (int i = 0; i < u; i++) {
            dat[i] = cours[i];
        }

        return dat;

    }


    public JComboBox<String> getCourses() {
        DefaultComboBoxModel df = new DefaultComboBoxModel<>(getCours());
        if (courses == null) {
            courses = new JComboBox<>();
            courses.setModel(df);
            courses.setBounds(60, 415, 200, 30);
            courses.addItemListener(aListener -> {
                getSp().setViewportView(getLastExams());
            });

        }

        return courses;
    }

}
