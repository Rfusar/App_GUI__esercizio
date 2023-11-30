package progetto.componenti;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

//MY_PACKAGE
import progetto.astrazione.Pagina;
import progetto.astrazione.logica.Home_page;
import progetto.astrazione.variabili.MenuPair;


public class Schermo extends Pagina{


    public void login(){
        int size[] = {450, 250};
        JFrame f = getFrame(); 
        setFrame(f, "LOGIN", size, false);
        new Menu().componenti_login(f);

        f.setVisible(true);
    }

    //MENU
    public void frame(){
        int size[] = {500, 500};
        JFrame f = getFrame(); 
        setFrame(f, "HOME", size, true);
        String titoli[] = {"File", "Cerca", "Trova"};

        MenuPair mP =  new Home_page().campi_menu(titoli, new JMenuBar());

        //JMENU
        new Home_page().cerca__FILE(mP.getMenus()[0], "Cerca file");

        f.setJMenuBar(mP.getMenuBar());

        f.setVisible(true);
    }
}
