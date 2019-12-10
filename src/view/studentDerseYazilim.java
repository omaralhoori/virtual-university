/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author omar
 */
public class studentDerseYazilim extends JPanel{
    String[] header={"Ders adı","Hoca Adı","Sınıf"};
    String[][] data,dat;
    JTable table;
    JScrollPane tablePane;
    JButton addBtn;
    String[] cours;
    JComboBox<String> courses;
    ArrayList<model.course> arr=model.dbCor.getCourse();
    ArrayList<model.activeStu> arr2=model.dbStuMa.getActStudent();
    ArrayList<model.degree> arr3=model.dbDegree.getDegree();
    int id;String clas;int u;
    student sf;
    public studentDerseYazilim(int id,student sf) {
        this.id = id;
        this.sf=sf;
        setLayout(null);
        add(getCourses());
        add(getTablePane());
        add(getAddBtn());
    }

    public String[][] getData() {
        data=new String[arr3.size()][3];
        int z=0;
        for (int i = 0; i < arr3.size(); i++) {
            if(id==arr3.get(i).getStuId()){
                for (int j = 0; j < arr.size(); j++) {
                    if(u==0)break;
                    if(arr3.get(i).getCorId().equalsIgnoreCase(arr.get(j).getCorName())){
                        data[z][0]=arr.get(j).getCorName();
                        data[z][1]=arr.get(j).getTeaId();
                        data[z][2]=arr.get(j).getClas();
                        z++;
                    }
                }
            }
          
            
        }
         dat=new String[z][3];
            for (int j = 0; j <z; j++) {
                dat[j][0]=data[j][0];
                dat[j][1]=data[j][1];
                dat[j][2]=data[j][2];
            }
        return dat;
    }
    
    
        public JTable getTable() {

        table = new JTable(getData(), header);
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
        
    String dep(){
        for (int i = 0; i < arr2.size(); i++) {
            if(id==arr2.get(i).getId())
            {
                clas=arr2.get(i).getClas();
              return arr2.get(i).getDepart();
            }
        }
        return "";
        
    }
    
    
    public String[] getCours() {
        
        cours = new String[arr.size()];
        u = 0;
        outer:
        for (int i = 0; i < arr.size(); i++) {
            if (dep().equals(arr.get(i).getCorDep())) 
            if(clas.equalsIgnoreCase(arr.get(i).getClas())){
                for (int k = 0; k < getData().length; k++) {
                    if(dat[k][0].equals(arr.get(i).getCorName()))
                        continue outer;
                }
    
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
            courses.setBounds(350, 200, 200, 30);

        }

        return courses;
    }
    
     public JButton getAddBtn() {
        if (addBtn == null) {
            addBtn = new JButton("Ders Ekle");
            addBtn.setBounds(600, 200, 100, 30);
            addBtn.addActionListener(e -> {
                try {
                    if (model.dbCor.insertCorStu(id, getCourses().getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "ders eklendi", "yeni ders", JOptionPane.INFORMATION_MESSAGE);
                 sf.getSf().getContentPane().remove(3);
                 sf.getSf().getContentPane().add(new studentDerseYazilim(Integer.parseInt(sf.getNumber().getText().substring(2)),sf),new AbsoluteConstraints(200, 130, 1000, 570));
                 sf.getSf().validate();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(teacherExams.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(studentDerseYazilim.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
        }
        return addBtn;
    }
    
    
    
    
}
