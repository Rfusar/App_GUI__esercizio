package progetto.componenti;


import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//MY_PACKAGE
import progetto.astrazione.logica.Login;



public class Menu extends Schermo{
    public void componenti_login(JFrame f){
        JPanel p0 = new JPanel(new GridLayout(3, 1, 10, 10 ));
        JPanel p1 = new JPanel(new GridBagLayout());

        JLabel l0 = new JLabel("Nome");
        JLabel l1 = new JLabel("Password");

        JTextField t0 = new JTextField(20);
        JTextField t1 = new JTextField(20);

        JButton b = new JButton("Login");


        JComponent componenti[] = {l0, t0, l1, t1, b};
        for(JComponent a : componenti){ p0.add(a); }
        p1.add(p0);
        f.setContentPane(p1);

        new Login().autenticazione(f, b, t0, t1);
    }


    public void tendina__cercaFile(){

    }

}
