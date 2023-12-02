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
        String titoli[] = {"File", "Editor", "Email"};

        MenuPair mP =  new Home_page().campi_menu(titoli, new JMenuBar());


        //FILE
        new Home_page().cerca__FILE(mP.getMenus()[0], "Cerca file", false);
        new Home_page().cerca__FILE(mP.getMenus()[0], "Cerca cartella", true);
        new Home_page().apri__editor(mP.getMenus()[1], "Apri");
        new Home_page().apri__email(mP.getMenus()[2], "Apri");
        

        f.setJMenuBar(mP.getMenuBar());

        f.setVisible(true);
    }


    public void editor(){
        int size[] = {500, 600};
        JFrame f = getFrame(); 
        setFrame(f, "EDITOR", size, false);
        new Menu().componenti__editor(f);

        f.setVisible(true);
    }

    
    public void invioEmail(){
        int size[] = {500, 600};
        JFrame f = getFrame(); 
        setFrame(f, "email", size, false);
        new Menu().componenti__email(f);

        f.setVisible(true);
    }
}
