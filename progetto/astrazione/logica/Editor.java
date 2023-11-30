package progetto.astrazione.logica;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//MY_PACKAGE


public class Editor {

    public void salva__testo(JButton b, JTextArea t0, JTextField t1){
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String testo = t0.getText();
                String nome_file = t1.getText();

                JFileChooser fileChooser = new JFileChooser("C:\\Users\\Utente\\Desktop\\prove_java\\prove\\risultatiEditor");
                fileChooser.setDialogTitle("Seleziona un percorso per salvare il file");
                fileChooser.setSelectedFile(new File(nome_file));

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileDaSalvare = fileChooser.getSelectedFile();

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileDaSalvare))) {
                        writer.write(testo);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                
                }    
            }
        });
    }



    public void carica__testo(JButton b, JTextArea textArea, JTextField titoloField){
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\Utente\\Desktop\\prove_java\\prove\\risultatiEditor");
                fileChooser.setDialogTitle("Seleziona un file da aprire");

                int userSelection = fileChooser.showOpenDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileDaAprire = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(fileDaAprire))) {
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                        }

                        textArea.setText(content.toString());

                        titoloField.setText(fileDaAprire.getName());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    
}
