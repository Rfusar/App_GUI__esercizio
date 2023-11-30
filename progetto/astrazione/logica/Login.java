package progetto.astrazione.logica;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//MY_PACKAGE
import progetto.componenti.Menu;
import progetto.componenti.Schermo;



public class Login extends Menu{

    public void autenticazione(JFrame f, JButton b, JTextField t0, JTextField t1){
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = t0.getText();
                String password = t1.getText();
                if(nome.equals("riccardo") && password.equals("chiocciola")){ 
                   f.dispose();
                   new Schermo().frame();
                   
                }
            }
        });
    }    
}
