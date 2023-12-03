package progetto.componenti;



import java.awt.BorderLayout;
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
import progetto.componenti.astrazione.CustomLayoutManager;



public class Menu extends Schermo{

    private CustomLayoutManager cLM = new CustomLayoutManager();

    public void componenti_login(JFrame f){

        JPanel p0 = new JPanel(new GridLayout(3, 1, 10, 10 ));
        JPanel p1 = new JPanel(new GridBagLayout());

        JLabel l0 = new JLabel("Nome");
        JLabel l1 = new JLabel("Password");

        JTextField t0 = new JTextField(20);
        JTextField t1 = new JTextField(20);

        JButton b = new JButton("Login");

        //A SCHERMO
        JComponent componenti[] = cLM.creaArray(l0, t0, l1, t1, b);
        cLM.aggiungiElementoAlPannello(p0, componenti);
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

        //A SCHERMO
        JComponent array___p_titolo[] = cLM.creaArray( nome_file, titolo );
        cLM.aggiungiElementoAlPannello(p_titolo, array___p_titolo);

        p_textArea.add(scrollPane);

        JComponent array___p_buttons[] = cLM.creaArray( save, read );
        cLM.aggiungiElementoAlPannello(p_buttons, array___p_buttons);

        JComponent array___pagina[] = cLM.creaArray( p_titolo, p_textArea, p_buttons );
        cLM.aggiungiElementoAlPannello(pagina, array___pagina);

        f.setContentPane(pagina);
    }


    public void componenti__email(JFrame f) {
        JLabel L_utenteEmail = new JLabel("email: ");
        JTextField utenteEmail = new JTextField(15);

        JLabel L_utentePassword = new JLabel("password: ");
        JTextField utentePassword = new JTextField(15);
        
        JLabel L_destinatarioEmail = new JLabel("a chi: ");
        JTextField destinatarioEmail = new JTextField(25);
        
        JLabel titolo_doc = new JLabel("titolo: ");
        JTextField titolo = new JTextField(25);

        JTextArea corpo = new JTextArea(30,30);
        JScrollPane scrollPane = new JScrollPane(corpo);
        
        
        JButton invia = new JButton("Invia");
        
        
        new Email().sendMail(invia, utenteEmail, utentePassword, destinatarioEmail, titolo, corpo);
        
        
        //impaginazione
        JPanel p_intestazione__utente = new JPanel();  
        JPanel p_intestazione = new JPanel();                           
        JPanel p_titolo = new JPanel(); 
        JPanel p_button = new JPanel();
        
        JPanel TOP_intestazione = new JPanel(new GridLayout(4,1));

        //A SCHERMO
        JComponent array___p_intestazione__utente[] =  cLM.creaArray(
            L_utenteEmail, utenteEmail, L_utentePassword, utentePassword
            );
        cLM.aggiungiElementoAlPannello(p_intestazione__utente, array___p_intestazione__utente);

        JComponent array___p_intestazione[] =  cLM.creaArray(
            L_destinatarioEmail, destinatarioEmail
        );
        cLM.aggiungiElementoAlPannello(p_intestazione, array___p_intestazione);

        JComponent array___p_titolo[] =  cLM.creaArray(
            titolo_doc, titolo
        );
        cLM.aggiungiElementoAlPannello(p_titolo, array___p_titolo);
        
        JComponent array___TOP_intestazione[] =  cLM.creaArray(
            p_intestazione__utente, p_intestazione, p_titolo
        );
        cLM.aggiungiElementoAlPannello(TOP_intestazione, array___TOP_intestazione);
      
        p_button.add(invia);


        f.add(TOP_intestazione, BorderLayout.NORTH);
        f.add(scrollPane, BorderLayout.CENTER);
        f.add(p_button, BorderLayout.SOUTH);
    }
}
