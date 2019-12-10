/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import logic.resize;
import model.dbAnn;

/**
 *
 * @author omar
 */
public class ann extends JFrame {
    JLabel title, image, date;
    dbAnn ann;
    JPanel jp;
    JScrollPane txt;
    JTextArea text;
    int adNo;
   

    public ann(int adNo) {
       this.adNo=adNo;
        setContentPane(getJp());
        setVisible(true);
        setSize(400, 500);
 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JLabel getTitle1() {
        if (title == null) {
            title = new JLabel(getAnn().getAnnounc().get(adNo).getTitle());
            title.setForeground(Color.BLACK);
            title.setFont(new Font("Stencil", 0, 18));
            title.setBounds(20, 20, 200, 30);

        }

        return title;
    }

    public JTextArea getText() {
        if (text == null) {
            text = new JTextArea(getAnn().getAnnounc().get(adNo).getText());
            text.setLineWrap(true);
            text.setBackground(new Color(232, 155, 12));
            text.setEditable(false);
        }
        return text;
    }

    public JLabel getImage() {
        if (image == null) {
            image = new JLabel();
            image.setBounds(100, 60, 150, 150);
            image.setIcon(new resize(getAnn().getAnnounc().get(adNo).getImage(), image).image);

        }

        return image;
    }

    public dbAnn getAnn() {
        if (ann == null) {
            ann = new dbAnn();
        }
        return ann;
    }

    public JLabel getDate() {
        if (date == null) {
            date = new JLabel(getAnn().getAnnounc().get(adNo).getDate());
            date.setForeground(Color.GRAY);
            date.setFont(new Font("Segoe UI", 0, 12));
            date.setBounds(20, 35, 200, 30);

        }

        return date;
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.add(getTitle1());
            jp.add(getDate());
            jp.add(getImage());
            jp.add(getTxt());
            jp.setLayout(null);
            jp.setBackground(new Color(232, 155, 12));
            

        }
        return jp;
    }

    public JScrollPane getTxt() {
        if (txt == null) {
            txt = new JScrollPane(getText());
            txt.setBounds(20, 230, 350, 200);
          
        }
        return txt;
    }

}
