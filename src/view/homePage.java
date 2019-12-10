/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JPanel;
import logic.homePageLogic;

/**
 *
 * @author omar
 */
public class homePage extends JPanel {

    ad ad, ad2, ad3;
    homePageLogic logic;

    public homePage() {
        setLayout(null);
        add(getAd());
        add(getAd2());
        add(getAd3());

    }

    public ad getAd() {
        if (ad == null) {
            ad = new ad(0);
            ad.setBounds(50, 120, 180, 180);
            ad.setBackground(new Color(153,204,255));
            ad.addMouseListener(getLogic());
        }
        return ad;
    }

    public ad getAd2() {
        if (ad2 == null) {
            ad2 = new ad(1);
            ad2.setBounds(300, 120, 180, 180);
            ad2.setBackground(new Color(153,204,255));
            ad2.addMouseListener(getLogic());
        }

        return ad2;
    }

    public ad getAd3() {
        if (ad3 == null) {
            ad3 = new ad(2);
            ad3.setBounds(550, 120, 180, 180);
            ad3.setBackground(new Color(153,204,255));
            ad3.addMouseListener(getLogic());
        }
        return ad3;
    }

    public homePageLogic getLogic() {
        if (logic == null) {
            logic = new homePageLogic(this);
        }
        return logic;
    }

}
