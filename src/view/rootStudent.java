/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logic.rootStudentLogic;

/**
 *
 * @author omar
 */
public class rootStudent extends JPanel {
   
    root mf;
    Ext ebt;
    JTable table, table2;
    JScrollPane scP, scP2;
    JLabel add, remove;
    Object[] header = {"id", "bolum"};
    String[] header2 = {"id", "bolum", "sınıf"};
    Object data[][];
    String data2[][];
    rootStudentLogic mouse;
    JButton addBtn, removeBtn;
    JComboBox<String> clas;
    public ArrayList<model.studentMa> arr = model.dbStuMa.getStudent();
    public ArrayList<model.activeStu> arr2 = model.dbStuMa.getActStudent();

 
    
    
    //-----------------------------constructor---------------------------------
    public rootStudent(view.root mf) throws IOException {
        setBackground(new Color(250, 250, 250));
        setLayout(null);
        this.mf = mf;
        add(getEbt().getLa(mf.getMf()));
        add(getScP());
        add(getAdd());
        add(getAddBtn());
        add(getClas());
        add(getScP2());
        add(getRemove());
        add(getRemoveBtn());
    }
//-------------------------------------------------------------------------

    public Object[][] getData() {
        if (data == null) {
            data = new Object[arr.size()][2];
            for (int i = 0; i < arr.size(); i++) {
                data[i][0] = "" + arr.get(i).getId();
                data[i][1] = arr.get(i).getDepart();
            }
        }

        return data;
    }

    public JTable getTable() {
        if (table == null) {
            DefaultTableModel model=new DefaultTableModel(getData(), header);
            table = new JTable(model);
            table.addMouseListener(getMouse());

            //----------------------------render----------------------
            ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
            DefaultTableCellRenderer v = new DefaultTableCellRenderer();
            v.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(v);
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(v);
            }
            //----------------------------------------------------------------------------    
        }

        return table;
    }

    public JScrollPane getScP() {
        if (scP == null) {
            scP = new JScrollPane(getTable());
            scP.setBounds(25, 100, 300, 245);
        }
        return scP;
    }

    public JLabel getAdd() {
        if (add == null) {
            add = new JLabel();
            add.setBounds(25, 375, 100, 30);
        }
        return add;
    }

    public JComboBox<String> getClas() {
        if (clas == null) {
            clas = new JComboBox<>();
            clas.setModel(new DefaultComboBoxModel<>(new String[]{"1.sınıf", "2.sınıf", "3.sınıf", "4.sınıf"}));
            clas.setBounds(100, 375, 100, 30);
        }
        return clas;
    }

    public JButton getAddBtn() {
        if (addBtn == null) {
            addBtn = new JButton("Etkinleştir");
            addBtn.setBounds(225, 375, 100, 30);
            addBtn.addActionListener(getMouse());
        }
        return addBtn;
    }

    public String[][] getData2() {
        if (data2 == null) {
            data2 = new String[arr2.size()][3];
            for (int i = 0; i < arr2.size(); i++) {
                data2[i][0] = "" + arr2.get(i).getId();
                data2[i][1] = arr2.get(i).getDepart();
                data2[i][2] = arr2.get(i).getClas();
            }
        }

        return data2;
    }

    public JTable getTable2() {
        if (table2 == null) {
            table2 = new JTable(getData2(), header2);
            table2.addMouseListener(getMouse());

            //----------------------------render----------------------
            ((DefaultTableCellRenderer) table2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
            DefaultTableCellRenderer v = new DefaultTableCellRenderer();
            v.setHorizontalAlignment(JLabel.CENTER);
            table2.getColumnModel().getColumn(0).setCellRenderer(v);
            for (int i = 0; i < table2.getColumnCount(); i++) {
                table2.getColumnModel().getColumn(i).setCellRenderer(v);
            }
            //----------------------------------------------------------------------------    
        }

        return table2;
    }

    public JScrollPane getScP2() {
        if (scP2 == null) {
            scP2 = new JScrollPane(getTable2());
            scP2.setBounds(350, 100, 325, 245);
        }
        return scP2;
    }

    public JLabel getRemove() {
        if (remove == null) {
            remove = new JLabel();
            remove.setBounds(350, 375, 100, 30);
        }
        return remove;
    }

    public JButton getRemoveBtn() {
        if (removeBtn == null) {
            removeBtn = new JButton("Sil");
            removeBtn.setBounds(450, 375, 100, 30);
            removeBtn.addActionListener(getMouse());
        }
        return removeBtn;
    }

    public rootStudentLogic getMouse() {
        if (mouse == null) {
            mouse = new rootStudentLogic(this,mf);

        }
        return mouse;
    }

    public Ext getEbt() throws IOException {
        if (ebt == null) {
            ebt = new Ext();
            ebt.setCl(new Color(50, 50, 50));
            ebt.getLa(mf.getMf()).setBounds(680, 5, 20, 20);

        }

        return ebt;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

  
}
