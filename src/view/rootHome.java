/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logic.rootHomeLogic;

/**
 *
 * @author omar
 */
public class rootHome extends JPanel {

    Ext Ebt;
    JFrame mf;
    JPanel header,addAnn;
    ad ad,ad2,ad3;
    rootHomeLogic logic;
    
    public JPanel getAddAnn() {
        if (addAnn == null) {
            addAnn = new JPanel();
            JLabel duy = new JLabel("Bir duyuru ekle..");
            duy.setForeground(Color.WHITE);
            duy.setFont(new Font("Segoe UI", 1, 12));
            addAnn.add(duy);
            addAnn.setCursor(new Cursor(12));
            addAnn.setBackground(new Color(153, 0, 153));
            addAnn.setBounds(350, 450, 100, 30);
            addAnn.addMouseListener(getLogic());

        }

        return addAnn;
    }

    public JPanel getHeader() {
        if (header == null) {
            header = new JPanel();
            JLabel hed = new JLabel("Ana Sayfa");
            JLabel hed1 = new JLabel("");
            hed.setBounds(300, 25, 200, 40);
            hed1.setBounds(260, 20, 40, 40);
            hed.setForeground(Color.WHITE);
            hed.setFont(new Font("Stencil", 1, 24));
            hed1.setIcon(new ImageIcon(getClass().getResource("/Icons/Home.png")));
            header.add(hed);
            header.add(hed1);
            header.setLayout(null);
            header.setBackground(new Color(132, 26, 132));
            header.setBounds(0, 40, 700, 80);
        }
        return header;
    }

    public ad getAd() {
        if(ad==null){
            ad=new ad(0);
            ad.setBounds(30, 190, 180, 180);
            ad.addMouseListener(getLogic());
        }
        return ad;
    }

    public ad getAd2() {
        if(ad2==null){
            ad2=new ad(1);
            ad2.setBounds(255, 190, 180, 180);
            ad2.addMouseListener(getLogic());
        }
        
        return ad2;
    }

    public ad getAd3() {
         if(ad3==null){
            ad3=new ad(2);
            ad3.setBounds(480, 190, 180, 180);
            ad3.addMouseListener(getLogic());
        }
        return ad3;
    }


    public Ext getEbt() {
        if (Ebt == null) {
            Ebt = new Ext();
            Ebt.setCl(new Color(50, 50, 50));
            Ebt.getLa(mf).setBounds(680, 5, 20, 20);

        }
        return Ebt;
    }

    public rootHome(JFrame mf) {
        this.setBackground(new Color(250, 250, 250));
        this.setLayout(null);
        this.mf = mf;
        this.add(getEbt().getLa(mf));
        this.add(getHeader());
        this.add(getAd());
        this.add(getAd2());
        this.add(getAd3());
        this.add(getAddAnn());
        
    }

    public rootHomeLogic getLogic() {
        if(logic==null){
            logic=new rootHomeLogic(this);
        }
        return logic;
    }

        
}
