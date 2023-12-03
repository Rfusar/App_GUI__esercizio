package progetto;

import javax.swing.SwingUtilities;


import progetto.componenti.Schermo;
//import progetto.astrazione.Database;

 public class Main extends Schermo {
     Main(String[] args) {}
     
     enum P{ LOGIN,FRAME,EDITOR,EMAIL}
     public void show(P pagine) {
        switch (pagine) {
            //test
            case EDITOR: editor(); break;
            case EMAIL: Email(); break;
            case FRAME: frame(); break;
            //main
            case LOGIN: login(); break;
        }
    }
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            P prova = P.LOGIN;
            public void run() {
                new Main(args).show(prova);
            }
        });
    }
}