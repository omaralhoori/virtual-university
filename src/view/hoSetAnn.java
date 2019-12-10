/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import logic.setAnn;

/**
 *
 * @author omar
 */
public class hoSetAnn extends JFrame {

    JPanel jp, ann;
    JButton add, cancle, addImage;
    JTextField title;
    JTextArea text;
    JScrollPane txt;
    public String path;

    public hoSetAnn() {
        //this.ann=ann;
        setUndecorated(true);
        setContentPane(getJp());
        setVisible(true);
        setSize(350, 450);
        setLocation(450, 225);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.add(getTitle1());
            jp.add(getTxt());
            jp.add(getAdd());
            jp.add(getCancle());
            jp.add(getAddImage());
            jp.setLayout(null);
        }
        return jp;
    }

    public JButton getAdd() {
        if (add == null) {
            add = new JButton("Ekle");
            add.setBounds(138, 365, 80, 30);
            add.setBackground(Color.red);
            add.setContentAreaFilled(false);
            add.addActionListener(new setAnn(this));
            add.setOpaque(true);

        }
        return add;
    }

    public JButton getCancle() {
        if (cancle == null) {
            cancle = new JButton("iptal");
            cancle.setBounds(225, 365, 80, 30);
            cancle.setBackground(Color.red);
            cancle.setContentAreaFilled(false);
            cancle.addActionListener(new setAnn(this));
            cancle.setOpaque(true);
        }
        return cancle;
    }

    public JButton getAddImage() {
        if (addImage == null) {
            addImage = new JButton("resim ekle");
            addImage.setBounds(30, 320, 100, 30);
            addImage.setBackground(Color.red);
            addImage.setContentAreaFilled(false);
            addImage.addActionListener(new setAnn(this));
            addImage.setOpaque(true);
        }

        return addImage;
    }

    public JTextField getTitle1() {
        if (title == null) {
            title = new JTextField("baslik ekle");
            title.setBounds(30, 30, 275, 30);

        }

        return title;
    }

    public JTextArea getText() {
        if (text == null) {
            text = new JTextArea("metin ekle ...", 10, 10);
            text.setLineWrap(true);

        }

        return text;
    }

    public JScrollPane getTxt() {
        if (txt == null) {
            txt = new JScrollPane(getText());
            txt.setBounds(30, 70, 275, 240);
        }
        return txt;
    }

}
