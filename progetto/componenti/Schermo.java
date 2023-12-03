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
        JFrame f = getFrame(); 
        setFrame(f, "HOME", null, true);
        String titoli[] = {"File", "Editor", "Email"};

        MenuPair mP =  new Home_page().campi_menu(titoli, new JMenuBar());

        //File
        new Home_page().cerca__FILE(mP.getMenus()[0], "Cerca file", false);
        new Home_page().cerca__FILE(mP.getMenus()[0], "Cerca cartella", true);
        //Editor
        new Home_page().apri__editor(mP.getMenus()[1], "Apri");
        //Email
        new Home_page().apri__email(mP.getMenus()[2], "Apri");
        
        f.setJMenuBar(mP.getMenuBar());

        f.setVisible(true);
    }


    public void editor(){
        JFrame f = getFrame(); 
        setFrame(f, "EDITOR", null, false);
        new Menu().componenti__editor(f);

        f.setVisible(true);
    }

    public void Email(){
        int size[] = {650, 700};
        JFrame f = getFrame(); 
        setFrame(f, "EMAIL", size, false);
        new Menu().componenti__email(f);

        f.setVisible(true);
    }

}
