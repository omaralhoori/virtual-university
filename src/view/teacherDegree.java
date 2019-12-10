/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import logic.teacherDegreeLogic;

/**
 *
 * @author omar
 */
public class teacherDegree extends JPanel {

    teacher tF;
    public JTable table;
    JScrollPane tablePane;
    JLabel stuIdLabel, vizeLabel, finlLabel, coursLabel;
    JTextField vize, finl;
    String name;
    String[] cours;
    String data[][];
    String[] header = {"öğrenci id", "vize", "final"};
    JButton add;int u;
    JComboBox<String> courses;
    teacherDegreeLogic logic;
    public ArrayList<model.course> arr = model.dbCor.getCourse();
    public ArrayList<model.degree> arr2 = model.dbDegree.getDegree();

    public teacherDegree(String name, teacher tF) {
        this.name = name;
        this.tF = tF;
        setLayout(null);
        add(getCourses());
        add(getTablePane());
        add(getStuIdLabel());
        add(getVizeLabel());
        add(getVize());
        add(getFinlLabel());
        add(getFinl());
        add(getAdd());
    }

    public String[] getCours() {
        cours = new String[arr.size()];
        u = 0;
        for (int i = 0; i < arr.size(); i++) {
            if(u==0)break;
            if (name.equals(arr.get(i).getTeaId())) {
                cours[u] = arr.get(i).getCorName();
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
            courses.setBounds(20, 10, 200, 30);
            courses.addItemListener(getLogic());

        }

        return courses;
    }

    public String[][] getData() {

        data = new String[arr2.size()][3];
        int j = 0;
        for (int i = 0; i < arr2.size(); i++) {
            if(u==0)break;
            if (getCourses().getSelectedItem().toString().equals(arr2.get(i).getCorId())) {
                data[j][0] = "" + arr2.get(i).getStuId();
                data[j][1] = arr2.get(i).getVize();
                data[j][2] = arr2.get(i).getFinl();
                j++;
            }

        }

        String[][] dat = new String[j][3];
        for (int i = 0; i < j; i++) {
            dat[i][0] = data[i][0];
            dat[i][1] = data[i][1];
            dat[i][2] = data[i][2];
        }

        return dat;
    }

    public JTable getTable() {

        table = new JTable(getData(), header);
        table.addMouseListener(getLogic());
        table.addKeyListener(getLogic());
        //----------------------------render----------------------
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        //----------------------------------------------------------------------------    

        return table;
    }

    public JScrollPane getTablePane() {
        if (tablePane == null) {
            tablePane = new JScrollPane();
            tablePane.setViewportView(getTable());
            tablePane.setBounds(20, 50, 300, 400);
            tablePane.setBorder(null);
        }
        return tablePane;
    }

    public JLabel getStuIdLabel() {
        if (stuIdLabel == null) {
            stuIdLabel = new JLabel("Öğrenci No : ");
            stuIdLabel.setBounds(400, 80, 100, 30);
        }
        return stuIdLabel;
    }

    public JLabel getVizeLabel() {
        if (vizeLabel == null) {
            vizeLabel = new JLabel("vize : ");
            vizeLabel.setBounds(400, 120, 80, 30);
        }
        return vizeLabel;
    }

    public JLabel getFinlLabel() {
        if (finlLabel == null) {
            finlLabel = new JLabel("final : ");
            finlLabel.setBounds(400, 160, 80, 30);
        }
        return finlLabel;
    }

    public JTextField getVize() {
        if (vize == null) {
            vize = new JTextField();
            vize.setBounds(480, 120, 100, 30);
        }
        return vize;
    }

    public JTextField getFinl() {
        if (finl == null) {
            finl = new JTextField();
            finl.setBounds(480, 160, 100, 30);
        }
        return finl;
    }

    public JButton getAdd() {
        if (add == null) {
            add = new JButton("Güncelle");
            add.addActionListener(getLogic());
            add.setBounds(480, 200, 100, 30);
        }
        return add;
    }

    public teacherDegreeLogic getLogic() {
        if (logic == null) {
            logic = new teacherDegreeLogic(tF, this);
        }
        return logic;
    }

}
