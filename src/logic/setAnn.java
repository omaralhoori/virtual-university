/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.dbAnn;
import view.hoSetAnn;

/**
 *
 * @author omar
 */
public class setAnn implements ActionListener {

    hoSetAnn jf;

    public setAnn(hoSetAnn jf) {
        this.jf = jf;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jf.getCancle()) {
            jf.dispose();
        } else if (e.getSource() == jf.getAddImage()) {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = file.getSelectedFile();
                jf.path = selectedFile.getAbsolutePath();
                System.out.println(jf.path);

            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("No File Select");
            }

        } else if (e.getSource() == jf.getAdd()) {
            try {
                new dbAnn().insertAnn(jf.getTitle1().getText(), jf.getText().getText(), jf.path);
                jf.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(setAnn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
