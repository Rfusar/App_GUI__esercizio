package progetto.astrazione.logica;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Email {
    public void sendMail(JButton b, JTextField eU, JTextField pU, JTextField eD, JTextField oE, JTextArea cE ){
        b.addActionListener(new ActionListener() {
            String emailUtente = eU.getText();
            String passwordUtente = pU.getText();
            String emailDestinatario = eD.getText();
            String oggettoEmail = oE.getText();
            String corpoEmail = cE.getText();
            @Override
            public void actionPerformed(ActionEvent e) {
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");

                // Creazione della sessione
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailUtente, passwordUtente);
                    }
                });

                try {
                    // Creazione del messaggio
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(emailUtente));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestinatario));
                    message.setSubject(oggettoEmail);
                    message.setText(corpoEmail);

                    // Invio del messaggio
                    Transport.send(message);

                } 
                catch (MessagingException x) {
                    x.printStackTrace();
                }
            }
        });
    }
}
