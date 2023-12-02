package progetto.componenti;



import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//MY_PACKAGE
import progetto.astrazione.logica.Login;
import progetto.astrazione.logica.Editor;
import progetto.astrazione.logica.Email;



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


    public void componenti__editor(JFrame f) {
        JLabel nome_file = new JLabel("nome file: ");
        JTextField titolo = new JTextField(25);
        JTextArea area = new JTextArea(40, 40);
        JScrollPane scrollPane = new JScrollPane(area);

        JButton save = new JButton("Salva");
        new Editor().salva__testo(save, area, titolo);

        JButton read = new JButton("Leggi");
        new Editor().carica__testo(read, area, titolo);

        JPanel pagina = new JPanel(new GridLayout(3, 1));
        JPanel p_titolo = new JPanel(new GridBagLayout());
        JPanel p_textArea = new JPanel();
        JPanel p_buttons = new JPanel(new GridBagLayout());

        p_titolo.add(nome_file);
        p_titolo.add(titolo);

        p_textArea.add(scrollPane);

        p_buttons.add(save);
        p_buttons.add(read);

        pagina.add(p_titolo);
        pagina.add(p_textArea);
        pagina.add(p_buttons);

        f.setContentPane(pagina);
    }


    public void componenti__email(JFrame f) {
        JLabel L_utenteEmail = new JLabel("inserisci email: ");
        JLabel L_destinatarioEmail = new JLabel("a chi: ");
        JTextField utenteEmail = new JTextField(25);
        JTextField destinatarioEmail = new JTextField(25);
        
        JLabel titolo_doc = new JLabel("titolo: ");
        JTextField titolo = new JTextField(25);

        JTextArea corpo = new JTextArea(40, 40);
        JScrollPane scrollPane = new JScrollPane(corpo);
        
        JButton invia = new JButton("Invia");
        
        JTextField utentePassword = new JTextField(25);
        
        //new Email().sendMail(invia, utenteEmail, utentePassword, destinatarioEmail, titolo, corpo);
        

        //impaginazione
        JPanel pagina = new JPanel(new GridLayout(6, 2, 3, 0));

        JPanel p_intestazuine = new JPanel(new GridLayout(2,4));
        JPanel p_email = new JPanel(new GridBagLayout());
        JPanel p_textArea = new JPanel();
        JPanel p_buttons = new JPanel(new GridBagLayout());
        JPanel p_password = new JPanel(new GridBagLayout());

        p_intestazuine.add(L_utenteEmail);
        p_intestazuine.add(utenteEmail);
        p_intestazuine.add(L_destinatarioEmail);
        p_intestazuine.add(destinatarioEmail);

        p_email.add(titolo_doc);
        p_email.add(titolo);

        p_textArea.add(scrollPane);
        
        p_buttons.add(invia);

        p_password.add(utentePassword);


        pagina.add(p_intestazuine);
        pagina.add(p_email);
        pagina.add(p_textArea);
        pagina.add(p_buttons);
        pagina.add(p_password);

        f.setContentPane(pagina);
    }




}
