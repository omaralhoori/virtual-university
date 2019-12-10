/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logic.rootHomeLogic;
import logic.resize;
import model.dbAnn;

/**
 *
 * @author omar
 */
public class ad extends JPanel {

    int adNo;
    dbAnn ann;

    ad(int adNo) {
        this.adNo = adNo;
        JLabel hed = new JLabel(getAnn().getAnnounc().get(adNo).getTitle());
        JLabel hed1 = new JLabel();
        JLabel hed2 = new JLabel(getAnn().getAnnounc().get(adNo).getDate());
        hed.setBounds(20, 130, 180, 30);
        hed1.setBounds(25, 5, 120, 120);
        hed2.setBounds(20, 150, 180, 30);
        hed.setForeground(Color.BLACK);
        hed2.setForeground(Color.gray);
        hed.setFont(new Font("Segoe UI", 1, 14));
        hed2.setFont(new Font("Segoe UI", 0, 12));
        hed1.setIcon(new resize(getAnn().getAnnounc().get(adNo).getImage(), hed1).image);
        add(hed);
        add(hed1);
        add(hed2);
        setLayout(null);
        setBackground(new Color(219, 156, 251));
        setCursor(new Cursor(12));
    }

    public dbAnn getAnn() {
        if (ann == null) {
            ann = new dbAnn();
        }
        return ann;
    }
}
