package progetto.astrazione.logica;

/* 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.lang.InterruptedException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Email {
    public void sendMail(JButton b, JTextField eU, JTextField pU, JTextField eD, JTextField oE, JTextArea cE,
            JTextField fE) {
        b.addActionListener(new ActionListener() {
            private static String convertiOggettoInJson(String emailUtente, String password_GMAIL,
                    String emailDestinatario, String oggettoEmail, String corpoEmail, String fileEmail) {
                return String.format("{"+
                    "\"\"\"emailUtente\"\"\":\"\"\"%s\"\"\","+
                    "\"\"\"password_GMAIL\"\"\":\"\"\"%s\"\"\","+
                    "\"\"\"emailDestinatario\"\"\":\"\"\"%s\"\"\","+
                    "\"\"\"oggetto\"\"\":\"\"\"%s\"\"\","+
                    "\"\"\"body\"\"\":\"\"\"%s\"\"\","+
                    "\"\"\"file\"\"\":\"\"\"%s\"\"\""+
                "}", 
                    emailUtente, password_GMAIL, emailDestinatario, oggettoEmail, corpoEmail, fileEmail);
            }

            private static String getPowerShellCommand(String ObjectJson) {
                return "$json = '" + ObjectJson + "'; C:\\Users\\Utente\\Desktop\\proveProgetti\\prove_Java\\GUI_Java\\Email.ps1 -parametro $json";}

            @Override
            public void actionPerformed(ActionEvent e) {
                String ObjectJson = convertiOggettoInJson(eU.getText(), pU.getText(), eD.getText(), oE.getText(),
                        cE.getText(), fE.getText());

                try {
                    // Creare il processo PowerShell
                    Process process = new ProcessBuilder("powershell.exe", "-Command", getPowerShellCommand(ObjectJson))
                            .redirectErrorStream(true)
                            .start();

                    // Ottenere lo stream di input per leggere l'output di PowerShell
                    InputStream inputStream = process.getInputStream();
                    Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
                    String output = scanner.hasNext() ? scanner.next() : "";

                    // Attendere che il processo PowerShell termini
                    int exitCode = process.waitFor();

                    // Stampa l'output di PowerShell e il codice di uscita
                    System.out.println(output);
                    System.out.println(exitCode);

                } catch (IOException | InterruptedException E) {E.printStackTrace();}

                
            };
        });
    }

}
