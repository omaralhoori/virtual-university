package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ext {
	 Color cl;
         JLabel la;
    public Color getCl() {
           if(cl==null){
            cl=new Color(250, 250, 250);
        }
        return cl;
    }

    public void setCl(Color cl) {
     
        this.cl = cl;
    }
	
	public Ext() {
		
	}
	
	 public JLabel getLa(JFrame jf) {
	        if(la==null){
	            la=new JLabel("X");
	            la.setForeground(getCl());
	           la.setCursor(new Cursor(12));
	            la.addMouseListener(new MouseListener() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                   
	                        System.exit(0);
	                
	                }

	                @Override
	                public void mousePressed(MouseEvent e) {
	                
	                }

	                @Override
	                public void mouseReleased(MouseEvent e) {

	                }

	                @Override
	                public void mouseEntered(MouseEvent e) {
                        la.setForeground(Color.red);
	                }

	                @Override
	                public void mouseExited(MouseEvent e) {
	             la.setForeground(getCl());
	                }

	             
	            });
	            la.setFont(new Font("Segoe UI", 1, 15));
	        }
	        return la;
	    }

	    public void setLa(JLabel la) {
	        this.la = la;
	    }
	 

}
