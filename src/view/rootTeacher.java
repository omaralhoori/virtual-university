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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import logic.rootTeacherLogic;

/**
 *
 * @author omar
 */
public class rootTeacher {
    root mf;
    Ext ebt;
    JPanel jp;
    JTable table;
    JTextField user ,email;  
    JPasswordField password;
    JRadioButton male, female;
    JComboBox<String> depart;
    String[] header = {"id", "Adi", "bolum"};
    String data[][];
    JScrollPane scP;
    JLabel sayi,sayi1,sayi2,sayi3;
    JLabel pass1, user1, email1, gender, depar;
    JButton add;
    rootTeacherLogic logic;
    public ArrayList<model.teacher> arr = model.dbTea.getTeacher();
    public rootTeacher(root mf) {
        
        this.mf = mf;
        
    }

 
    //-----------------------inserting --------------------------------
        public JLabel getUser1() {
        if (user1 == null) {
            user1 = new JLabel("Kullancı Adı:");
            user1.setBounds(20, 320, 200, 25);
            
        }
        return user1;
    }

    
        public JTextField getUser() {
        if (user == null) {
            user = new JTextField();
            user.setBounds(100, 320, 200, 25);
            user.setBackground(new Color(0, 0, 0, 0));
           // user.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
            
            
            user.setOpaque(false);
        }
        return user;
    }

           public JLabel getPass1() {
        if (pass1 == null) {
            pass1 = new JLabel("Şifre :");
            pass1.setBounds(20, 360, 200, 25);
        }

        return pass1;
    }
               public JPasswordField getPassword() {
        if (password == null) {
            password = new JPasswordField();
            password.setBounds(100, 360, 200, 25);
            password.setBackground(new Color(0, 0, 0, 0));
            password.setOpaque(false);
        }
        return password;
    }
               
               
    public JLabel getEmail1() {
        if (email1 == null) {
            email1 = new JLabel("e-posta :");
            email1.setBounds(320, 320, 200, 25);

        }
        return email1;
    }

    public JTextField getEmail() {
        if (email == null) {
            email = new JTextField();
            email.setBounds(380 , 320, 200, 25);
            email.setBackground(new Color(0, 0, 0, 0));
            email.setOpaque(false);
        }
        return email;
    }
    
     public JLabel getGender() {
        if (gender == null) {
            gender = new JLabel("Cinsiyet :");
            gender.setBounds(320, 364, 200, 25);
        }
        return gender;
    }


    public JRadioButton getMale() {
        if (male == null) {
            male = new JRadioButton("Erkek");
            male.setBounds(380, 357, 80, 40);
            male.setSelected(true);
            male.setBackground(new Color(0, 0, 0, 0));
            male.setOpaque(false);
            male.setActionCommand("male");
            male.addActionListener(event -> {
                getFemale().setSelected(false);
                male.setSelected(true);

            });

        }
        return male;
    }

    public JRadioButton getFemale() {
        if (female == null) {
            female = new JRadioButton("Kiz");
            female.setBounds(450, 357, 80, 40);
            female.setBackground(new Color(0, 0, 0, 0));
            female.setOpaque(false);
            female.setActionCommand("female");
            female.addActionListener(event -> {
                getMale().setSelected(false);
                female.setSelected(true);

            });

        }
        return female;
    }

   
    
       public JLabel getDepar() {if(depar==null){
        depar=new JLabel("Bolum :");
        depar.setBounds(20, 420, 50, 25);

    }
        return depar;
    }  
    
      public JComboBox<String> getDepart() {
        if(depart==null){
            depart=new JComboBox<>();
            depart.setModel(new DefaultComboBoxModel<>(new String[] {"yazilim","enerji","insaat"}));
            depart.setBounds(100, 420, 140, 25);
        }
        return depart;
    }

    public JButton getAdd() {
        if(add==null){
            add=new JButton("Hoca Ekle");
            add.setBounds(475, 420, 100, 25);
            add.addActionListener(getLogic());
        }
        return add;
    }
       
      
    //-------------------------------------------------------
    
    
    public JPanel getJp() throws IOException {
        if(jp==null){
          jp=new JPanel();
         jp.setBackground(new Color(250, 250, 250));
        jp.setLayout(null);
         jp.add(getEbt().getLa(this.mf.getMf()));
         jp.add(getScP());
         jp.add(getSayi());jp.add(getSayi1());jp.add(getSayi2());jp.add(getSayi3());
         jp.add(getUser1());jp.add(getUser());jp.add(getPass1());jp.add(getPassword());jp.add(getEmail1());jp.add(getEmail());
         jp.add(getGender());jp.add(getMale());jp.add(getFemale());jp.add(getDepar());jp.add(getDepart());jp.add(getAdd());
        }
        return jp;
    }
    
    public String[][] getData() {
        if (data == null) {
            data = new String[arr.size()][3];
            for (int i = 0; i < arr.size(); i++) {
                data[i][0] = "" + arr.get(i).getId();
                data[i][1] = arr.get(i).getName();
                data[i][2] = arr.get(i).getDepart();
            }
        }

        return data;
    }

    
    public JTable getTable() {
        if (table == null) {
            
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
        }

        return table;
    }
    
    
        public JScrollPane getScP() {
        if (scP == null) {
            scP = new JScrollPane(getTable());
            scP.setBounds(25, 50, 300, 245);
        }
        return scP;
    }

    public JLabel getSayi() {
        if(sayi==null){
            sayi=new JLabel("Öğretmen Sayısı : " + arr.size());
            sayi.setBounds(375, 60, 150, 30);
            
        }
        return sayi;
    }

    public JLabel getSayi1() {
        if(sayi1==null){
            sayi1=new JLabel("Enerji Bölümündeki Öğretmen Saysı : "+sayac(getData(),"enerji"));
            sayi1.setBounds(375, 110, 300, 30);
        }
        return sayi1;
    }

    public JLabel getSayi2() {
          if(sayi2==null){
            sayi2=new JLabel("Yazilim Bölümündeki Öğretmen Saysı : "+sayac(getData(),"yazilim"));
            sayi2.setBounds(375, 150, 300, 30);
        }
        return sayi2;
    }

    public JLabel getSayi3() {
        if(sayi3==null){
            sayi3=new JLabel("İnşaat Bölümündeki Öğretmen Saysı : "+sayac(getData(),"insaat"));
            sayi3.setBounds(375,190, 300, 30);
        }
        return sayi3;
    }
    
    
            
    
    public Ext getEbt() throws IOException {
        if (ebt == null) {
            ebt = new Ext();
            ebt.setCl(new Color(50, 50, 50));
            ebt.getLa(mf.getMf()).setBounds(680, 5, 20, 20);

        }

        return ebt;
    }    

    public rootTeacherLogic getLogic() {
        if(logic==null){
            logic=new rootTeacherLogic(this,mf);
        }
        return logic;
    }
    
    
    int sayac(String[][] arr,String bolum){
        int sayac=0;
        for (int i = 0; i < this.arr.size(); i++) {
            if(arr[i][2].equalsIgnoreCase(bolum))sayac++;
        }
        
        return sayac;
    }
}
