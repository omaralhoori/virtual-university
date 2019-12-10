/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author omar
 */
public class studentDegree extends JPanel{

    JTable table;
    JScrollPane tablePane;
    int id;
    String[] cours;
    String data[][];
    String[] header = {"ders", "vize", "final"};
    JComboBox<String> courses;
    public ArrayList<model.course> arr = model.dbCor.getCourse();
    public ArrayList<model.degree> arr2 = model.dbDegree.getDegree();

    public studentDegree(int id) {
        this.id = id;
        setLayout(null);
        add(getTablePane());
    }



    public String[][] getData() {

        data = new String[arr2.size()][3];
        int j = 0;
        for (int i = 0; i < arr2.size(); i++) {
            if (id==arr2.get(i).getStuId())
            {
                data[j][0] = arr2.get(i).getCorId();
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
        table.setBorder(null);
        
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
            tablePane.setBounds(100, 20, 600, 400);
            tablePane.setBorder(BorderFactory.createEmptyBorder());
        }
        return tablePane;
    }

    
    
}
