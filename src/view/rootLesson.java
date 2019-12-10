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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import logic.rootLessontLogic;

/**
 *
 * @author omar
 */
public class rootLesson {
    root mf;
    Ext ebt;
    JPanel jp;
    JTable table;
    JLabel sayi,sayi1,sayi2,sayi3,remove;
    JLabel corName, depart, teacher, clas;
    JTextField corNam;
    public JComboBox<String> depar,teache,cla;
    JButton remov,addBtn;
    JTextField dersAdi ;  
    String[] header = {"ders id", "ders adı", "bolum","hoca id","Sınıf"};  
    JScrollPane scP;
    String data[][],data2[];
    rootLessontLogic logic;
    public ArrayList<model.course> arr = model.dbCor.getCourse();
    public ArrayList<model.teacher> arr2 = model.dbTea.getTeacher();
    //---------------------------------------------------------------
    public rootLesson(root mf) {    
        this.mf = mf;
    }

//--------------------------------------------------------------------
    
    
    public JPanel getJp() throws IOException {
        if(jp==null){
            jp=new JPanel();
            jp.setBackground(new Color(250, 250, 250));
            jp.setLayout(null);
            jp.add(getEbt().getLa(this.mf.getMf()));
            jp.add(getScP());
            jp.add(getSayi());jp.add(getSayi1());jp.add(getSayi2());jp.add(getSayi3());jp.add(getRemove());jp.add(getRemov());
            jp.add(getCorName());jp.add(getCorNam());jp.add(getDepart());jp.add(getDepar());jp.add(getTeacher());
            jp.add(getClas());jp.add(getCla());jp.add(getAddBtn());jp.add(getTeache());
        }
        
        return jp;
    }
//-------------------------------------------------ders bilgileri-----------------------------------------------------
    public String[][] getData() {
        if (data == null) {
            data = new String[arr.size()][5];
            for (int i = 0; i < arr.size(); i++) {
                data[i][0] = "" + arr.get(i).getCorId();
                data[i][1] = arr.get(i).getCorName();
                data[i][2] = arr.get(i).getCorDep();
                data[i][3] = ""+arr.get(i).getTeaId();
                data[i][4] = arr.get(i).getClas();
            }
        }

        return data;
    }

    
    public JTable getTable() {
        if (table == null) {
            
            table = new JTable(getData(), header);
            table.addMouseListener(getLogic());
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
            sayi=new JLabel("Dersler Sayısı : " + arr.size());
            sayi.setBounds(375, 60, 150, 30);
            
        }
        return sayi;
    }

       public JLabel getSayi1() {
        if(sayi1==null){
            sayi1=new JLabel("Enerji Bölümündeki Dersler Sayısı   : "+sayac(getData(),"enerji"));
            sayi1.setBounds(375, 110, 300, 30);
        }
        return sayi1;
    }

    public JLabel getSayi2() {
          if(sayi2==null){
            sayi2=new JLabel("Yazılım Bölümündeki Dersler Sayısı : "+sayac(getData(),"yazilim"));
            sayi2.setBounds(375, 150, 300, 30);
        }
        return sayi2;
    }

    public JLabel getSayi3() {
        if(sayi3==null){
            sayi3=new JLabel("İnşaat Bölümündeki Dersler Sayısı  : "+sayac(getData(),"insaat"));
            sayi3.setBounds(375,190, 300, 30);
        }
        return sayi3;
    }

    public JLabel getRemove() {
         if(remove==null){
            remove=new JLabel();
            remove.setBounds(375,250, 300, 30);
        }
        return remove;
    }

    public JButton getRemov() {
        if(remov==null ){
            remov=new JButton("ders sil");
            remov.setBounds(490,250, 100, 30);
            remov.addActionListener(getLogic());
        }
        return remov;
    }
     
   //------------------------------------ders ekleme---------------------------------------------------------------------------     

    public JLabel getCorName() {
        if(corName==null){
            corName=new JLabel("Ders adı : ");
            corName.setBounds(25, 320,100 , 30);
        }
        return corName;
    }

    public JLabel getDepart() {
        if(depart==null){
            depart=new JLabel("Bölüm : ");
            depart.setBounds(350, 320,100 , 30);
        }
        return depart;
    }

    public JLabel getTeacher() {
        if(teacher==null){
            teacher=new JLabel("Hoca : ");
            teacher.setBounds(25, 370,100 , 30);
        }
        return teacher;
    }

    public JLabel getClas() {
       if(clas==null){
            clas=new JLabel("sınıf : ");
            clas.setBounds(350 , 370,100 , 30);
        }
        return clas;
    }

    public JTextField getCorNam() {
        if(corNam==null){
            corNam=new JTextField();
            corNam.setBounds(100, 320,200, 30);
        }
        return corNam;
    }

    public JComboBox<String> getDepar() {
        if(depar==null){
            depar=new JComboBox<>();
            depar.setModel(new DefaultComboBoxModel<>(new String[] {"yazilim","enerji","insaat"}));
            depar.addItemListener(getLogic());
            depar.setBounds(420, 320,175 , 30);
        }
        return depar;
    }
    
     public String[] getData2() {
        
            data2 = new String[arr2.size()];
            int j=0;
            for (int i = 0; i < arr2.size(); i++) {
                if(getDepar().getSelectedItem().equals(arr2.get(i).getDepart())){
                data2[j] =arr2.get(i).getName();
                j++;
               }
            }
            
            String [] dat=new String[j];
            for(int i=0;i<j;i++)dat[i]=data2[i];

        return dat;
    }

    
    
    public JComboBox<String> getTeache() {
          DefaultComboBoxModel df=new DefaultComboBoxModel<>(getData2());
        
            teache=new JComboBox<>();
            teache.setModel(df);
            teache.addItemListener(getLogic());
            teache.setBounds(100, 370,200 , 30);
          
        return teache;
    }

    public JComboBox<String> getCla() {
           if(cla==null){
            cla=new JComboBox<>();
            cla.setModel(new DefaultComboBoxModel<>(new String[] {"1.sınıf", "2.sınıf", "3.sınıf", "4.sınıf"}));
            
            cla.setBounds(420, 370,175 , 30);
        }
        return cla;
    }

    public JButton getAddBtn() {
        if(addBtn==null ){
            addBtn=new JButton("ders Ekle");
            addBtn.setBounds(490,425, 100, 30);
            addBtn.addActionListener(getLogic());
        }
        return addBtn;
    }
     
    
    
    
    
  //------------------------------------------------------------------------------------------------------  
        
        
    
    public Ext getEbt() throws IOException {
            if (ebt == null) {
            ebt = new Ext();
            ebt.setCl(new Color(50, 50, 50));
            ebt.getLa(mf.getMf()).setBounds(680, 5, 20, 20);

        }

        return ebt;
    }

    public rootLessontLogic getLogic() {
        if(logic==null){
            logic=new rootLessontLogic(this,mf);
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
