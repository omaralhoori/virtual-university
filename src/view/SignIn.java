/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Cursor.HAND_CURSOR;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import logic.*;

/**
 *
 * @author omar
 */
public class SignIn  {

    JFrame jf;
    JPanel jp, sgin, sgup, line1, line2;
    JLabel user1, pass1, pic, or;
    JTextField user;
    JPasswordField password;
    BufferedImage wPic;
    Ext Ebt;
    SignUp jf2;
    moveFrame move;

    public moveFrame getMove() throws IOException {
        if(move==null){
            move=new moveFrame(this.getJf());
        }
        return move;
    }
 
//-------------------------------getter----------------------------------------
    public Ext getEbt() throws IOException {
        if (Ebt == null) {
            Ebt = new Ext();
            Ebt.getLa(getJf()).setBounds(380, 5, 25, 20);
        }

        return Ebt;
    }

    public JPanel getLine1() {
        if (line1 == null) {
            line1 = new JPanel();
            line1.setBackground(Color.white);
            line1.setBounds(325, 75, 2, 250);
        }
        return line1;
    }

    public JPanel getLine2() {
        if (line2 == null) {
            line2 = new JPanel();
            line2.setBackground(Color.white);
            line2.setBounds(70, 75, 2, 250);
        }
        return line2;
    }

    public JLabel getOr() {
        if (or == null) {
            or = new JLabel("Veya");
            or.setBounds(188, 305, 25, 25);
            or.setFont(new Font("Segoe UI", 1, 10));
            or.setForeground(Color.white);

        }
        return or;
    }

    public JLabel getPic() throws IOException {
        if (pic == null) {
            wPic = ImageIO.read(this.getClass().getResource("/Icons/User.png"));
            pic = new JLabel(new ImageIcon(wPic));
            pic.setBounds(150, 50, 90, 90);
        }

        return pic;
    }

    public JPanel getSgin() {
        if (sgin == null) {
            JLabel si;
            sgin = new JPanel();

            sgin.setBounds(100, 300, 80, 40);
            sgin.setBackground(new Color(136, 23, 193));
            sgin.add(si = new JLabel("Giriş Yap"));
            sgin.setLayout(null);
            si.setForeground(Color.WHITE);
            si.setBounds(15, 9, 60, 20);
            sgin.setCursor(new Cursor(HAND_CURSOR));
            sgin.setBorder(new LineBorder(new Color(136, 23, 193), 2, true));
            sgin.addMouseListener(new signInLogic(this.sgin, si,this));
        }

        return sgin;
    }

    public JPanel getSgup() {
        if (sgup == null) {
            JLabel su;
            sgup = new JPanel();
            sgup.setBounds(220, 300, 80, 40);
            sgup.setBackground(new Color(136, 23, 193));
            sgup.add(su = new JLabel("KaydOl"));
            sgup.setLayout(null);
            su.setForeground(Color.WHITE);
            su.setBounds(18, 9, 60, 20);
            sgup.setCursor(new Cursor(HAND_CURSOR));
            sgup.addMouseListener(new signInLogic( this.getSgup(), su,this));
        }
        return sgup;
    }

    public JLabel getUser1() {
        if (user1 == null) {
            user1 = new JLabel("Kullancı Adı");
            user1.setBounds(100, 160, 200, 25);
            user1.setFont(new Font("Segoe UI", 0, 12));
            user1.setForeground(Color.white);
        }
        return user1;
    }

    public JLabel getPass1() {
        if (pass1 == null) {
            pass1 = new JLabel("Şifre");
            pass1.setBounds(100, 220, 200, 25);

            pass1.setFont(new Font("Segoe UI", 0, 12));
            pass1.setForeground(Color.white);
        }

        return pass1;
    }

    public JTextField getUser() {
        if (user == null) {
            user = new JTextField();
            user.setBounds(100, 180, 200, 25);
            user.setBackground(new Color(0, 0, 0, 0));
            user.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
            user.setFont(new Font("Segoe UI", 1, 14));
            user.setForeground(Color.white);
            user.setCaretColor(new Color(204, 0, 255));
            user.setOpaque(false);
        }
        return user;
    }

    public JPasswordField getPassword() {
        if (password == null) {
            password = new JPasswordField();
            password.setBounds(100, 240, 200, 25);
            password.setBackground(new Color(0, 0, 0, 0));
            password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
            password.setFont(new Font("Segoe UI", 1, 14));
            password.setForeground(Color.white);
            password.setCaretColor(new Color(204, 0, 255));
            password.setOpaque(false);
        }
        return password;
    }
//-----------------------------------Panel---------------------------------------------------
    public JPanel getJp() throws IOException {
        if (jp == null) {
            jp = new JPanel();
                    jp.add(getUser());
        jp.add(getUser1());
        jp.add(getPass1());
        jp.add(getPic());
        jp.add(getSgin());
        jp.add(getSgup());
       jp.add(getOr());
        jp.add(getLine1());
        jp.add(getLine2());
        jp.add(getPassword());
        jp.add(getEbt().getLa(getJf()));
       
     
             
            
            jp.setBackground(new Color(204, 0, 255));
            jp.setLayout(null);

        }

        return jp;
    }
//---------------------------Frame----------------------------------
    public JFrame getJf() throws IOException {
        if (jf == null) {
            jf = new JFrame("New Frame");
            jf.setContentPane(getJp());
            jf.setUndecorated(true);
            
           jf.setLocation(500, 200);
            
            jf.addMouseListener(getMove());
            jf.addMouseMotionListener(getMove());
            jf.setVisible(true);
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setSize(400, 400);
        //    jf.setLocationRelativeTo(null);

        }

        return jf;
    }

    //Constructor-----------------------------------------------
    public SignIn() throws IOException {
        
        

        getJf();

        //getJp().add(getJp1()); 
        //setUndecorated(true);
    }
//---------------------setter-----------------------------------------------

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public void setUser(JTextField user) {
        this.user = user;
    }
//-------------------------Mouse----------------------------------

}
