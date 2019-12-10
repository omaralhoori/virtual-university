/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author omar
 */
public class lesson extends JPanel{
    
     JLabel title,time,link,corName;
    JTextArea desc;
    JScrollPane des;
    String[] txts;

    public lesson(String[] txts) {
        this.txts = txts;
        setLayout(null);
        setBackground(new Color(117,161,253));
        setPreferredSize(new Dimension(700, 120));
        setMaximumSize(new Dimension(700, 120));
        setMinimumSize(new Dimension(700, 120));
        add(getTitle());
        add(getTime());
        add(getLink());
        add(getCorName());
        add(getDes());
        
        addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(125,175,253));
                getDesc().setBackground(new Color(125,175,253));
            }

            @Override
            public void mouseExited(MouseEvent e) {
        setBackground(new Color(117,161,253));
        getDesc().setBackground(new Color(117,161,253));
            }
            
            
        });
    }

    public JLabel getTitle() {
        if(title==null){
            title=new JLabel(txts[0]);
            title.setFont(new Font("Modern No. 20", 1, 18));
            title.setForeground(Color.WHITE);
            title.setBounds(80, 10, 80, 20);
        }
        return title;
    }

    public JLabel getTime() {
        if(time==null){
            time=new JLabel(txts[1]);
            time.setFont(new Font("Gadugi", 1, 14));
            time.setForeground(new Color(233,233,233));
            time.setBounds(10 ,30, 80, 20);
        }
        return time;
    }

    public JLabel getLink() {
        if(link==null){
            link=new JLabel(txts[2]);
            link.setBounds(20, 50, 200, 20);
            link.setCursor(new Cursor(12));
            link.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        java.awt.Desktop.getDesktop().browse(URI.create(txts[2]));
                    } catch (IOException ex) {
                        Logger.getLogger(exam.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });
            link.setForeground(new Color(250,81,107));
        }
        return link;
    }

    public JLabel getCorName() {
            if(corName==null){
            corName=new JLabel(txts[3]);
            corName.setFont(new Font("Modern No. 20", 1, 18));
            corName.setForeground(Color.WHITE);
            corName.setBounds(10, 10, 80, 20);
        }
        return corName;
    }

    public JTextArea getDesc() {
        if(desc==null){
            desc=new JTextArea(txts[4]);
            desc.setLineWrap(true);
            desc.setEditable(false);
            desc.setBackground(new Color(117,161,253));
            desc.setForeground(Color.WHITE);
            desc.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(125,175,253));
                getDesc().setBackground(new Color(125,175,253));
            }

            @Override
            public void mouseExited(MouseEvent e) {
        setBackground(new Color(117,161,253));
        getDesc().setBackground(new Color(117,161,253));
            }
            
            
        });
        }
               
        return desc;
    }

    public JScrollPane getDes() {
        if(des==null){
            des=new JScrollPane(getDesc());
            des.setBounds(10, 75, 670, 38);
            des.setBorder(null);
            
        }
        return des;
    }
    
    
    
    
}
