package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import logic.moveFrame;
import logic.signUpBa;
import logic.signUpLogic;

public class SignUp {

    JFrame jf2;
    JPanel jp2,sgup,line1, line2;
    Ext Ebt;
    JLabel pic, pass1, user1, email1, gender, back,depar;
    BufferedImage wPic;
    JTextField user, email;
    JPasswordField password;
    JRadioButton male, female;
    JComboBox<String> depart;
    moveFrame move;

    public moveFrame getMove() throws IOException {
        if(move==null){
            move=new moveFrame(this.getJf2());
        }
        return move;
    }
 
    
    
    //---------------------------------------------------------------------------
    
    
    
    
    
      public JPanel getLine1() {
        if (line1 == null) {
            line1 = new JPanel();
            line1.setBackground(Color.white);
            line1.setBounds(325, 75, 2, 400);
        }
        return line1;
    }

    public JPanel getLine2() {
        if (line2 == null) {
            line2 = new JPanel();
            line2.setBackground(Color.white);
            line2.setBounds(70, 75, 2, 400);
        }
        return line2;
    }
    
    
    
    public JLabel getDepar() {if(depar==null){
        depar=new JLabel("Bolum :");
        depar.setBounds(100, 400, 50, 25);
        depar.setFont(new Font("Segoe UI", 0, 12));
            depar.setForeground(Color.white);
    }
        return depar;
    }  
    
    public JComboBox<String> getDepart() {
        if(depart==null){
            depart=new JComboBox<>();
            depart.setModel(new DefaultComboBoxModel<>(new String[] {"yazilim","enerji","insaat"}));
            depart.setBounds(165, 400, 140, 25);
        }
        return depart;
    }

//------------------------------------------------------
    public SignUp() throws IOException {

        

        getJp2().add(getEbt().getLa(getJf2()));
        getJp2().add(getPic());
        getJp2().add(getUser());
        getJp2().add(getPassword());
        getJp2().add(getPass1());
        getJp2().add(getUser1());
        getJp2().add(getEmail1());
        getJp2().add(getEmail());
        getJp2().add(getMale());
        getJp2().add(getDepart());
        getJp2().add(getFemale());
        getJp2().add(getGender());
        getJp2().add(getSgup());
        getJp2().add(getBack());
        getJp2().add(getDepar());
        getJp2().add(getLine1());getJp2().add(getLine2());
getJf2();
    }
//------------------getter---------------------------------------------------

    public JFrame getJf2() throws IOException {
        if (jf2 == null) {
            jf2 = new JFrame("New Frame");
            jf2.setUndecorated(true);
            jf2.addMouseListener(getMove());
            jf2.addMouseMotionListener(getMove());
            jf2.setLocation(500, 125);
            jf2.setVisible(true);
            jf2.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf2.setSize(400, 600);
            jf2.setContentPane(getJp2());

        }

        return jf2;
    }

    public JPanel getJp2() {
        if (jp2 == null) {
            jp2 = new JPanel();
            jp2.setBackground(new Color(204, 0, 255));
            jp2.setLayout(null);

        }

        return jp2;
    }

    public JLabel getPic() throws IOException {
        if (pic == null) {
            wPic = ImageIO.read(this.getClass().getResource("/Icons/User.png"));
            pic = new JLabel(new ImageIcon(wPic));
            pic.setBounds(150, 50, 90, 90);
        }

        return pic;
    }

    public JLabel getBack() throws IOException  {
        if (back == null) {
        
            back = new JLabel();
            back.setIcon(new ImageIcon(getClass().getResource("/Icons/arrow.png")));
            back.setCursor(new Cursor(12));
            back.setBounds(10, 5, 25, 25);
            back.addMouseListener(new signUpBa(this.getBack(),this.getJf2()));
        }

        return back;
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

    public JLabel getPass1() {
        if (pass1 == null) {
            pass1 = new JLabel("Şifre");
            pass1.setBounds(100, 220, 200, 25);

            pass1.setFont(new Font("Segoe UI", 0, 12));
            pass1.setForeground(Color.white);
        }

        return pass1;
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

    public JLabel getEmail1() {
        if (email1 == null) {
            email1 = new JLabel("e-posta");
            email1.setBounds(100, 280, 200, 25);
            email1.setFont(new Font("Segoe UI", 0, 12));
            email1.setForeground(Color.white);
        }
        return email1;
    }

    public JTextField getEmail() {
        if (email == null) {
            email = new JTextField();
            email.setBounds(100, 300, 200, 25);
            email.setBackground(new Color(0, 0, 0, 0));
            email.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
            email.setFont(new Font("Segoe UI", 1, 14));
            email.setForeground(Color.white);
            email.setCaretColor(new Color(204, 0, 255));
            email.setOpaque(false);
        }
        return email;
    }

    public JRadioButton getMale() {
        if (male == null) {
            male = new JRadioButton("Erkek");
            male.setBounds(160, 340, 80, 40);
            male.setSelected(true);
            male.setBackground(new Color(0, 0, 0, 0));
            male.setOpaque(false);
            male.setActionCommand("male");
            male.setForeground(Color.white);
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
            female.setBounds(240, 340, 80, 40);
            female.setBackground(new Color(0, 0, 0, 0));
            female.setForeground(Color.white);
            female.setOpaque(false);
            female.setActionCommand("female");
            female.addActionListener(event -> {
                getMale().setSelected(false);
                female.setSelected(true);

            });

        }
        return female;
    }

    public JLabel getGender() {
        if (gender == null) {
            gender = new JLabel("Cinsiyet :");
            gender.setBounds(100, 346, 200, 25);
            gender.setFont(new Font("Segoe UI", 0, 12));
            gender.setForeground(Color.white);
        }
        return gender;
    }

    public Ext getEbt() throws IOException {
        if (Ebt == null) {
            Ebt = new Ext();
            Ebt.getLa(getJf2()).setBounds(380, 5, 25, 20);
        }

        return Ebt;
    }
    
    public JPanel getSgup() {
        if (sgup== null) {
            JLabel si;
            sgup = new JPanel();

            sgup.setBounds(100, 450,200, 40);
            sgup.setBackground(new Color(136, 23, 193));
            sgup.add(si = new JLabel("KaydOl"));
            sgup.setLayout(null);
            si.setForeground(Color.WHITE);
            si.setBounds(82, 9, 60, 20);
            sgup.setCursor(new Cursor(HAND_CURSOR));
            sgup.setBorder(new LineBorder(new Color(136, 23, 193), 2, true));
            sgup.addMouseListener(new signUpLogic(this,this.getSgup(), si));
        }

        return sgup;
    }

}
