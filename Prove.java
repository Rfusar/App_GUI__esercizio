import java.util.ArrayList;


import javax.swing.JMenu;
import javax.swing.JMenuBar;

class MenuPair{
    JMenuBar menuBar;
    JMenu[] menus;

    MenuPair(JMenuBar menuBar, JMenu[] menus) {
        this.menuBar = menuBar;
        this.menus = menus;
    }
}

public class Prove {

    public ArrayList<MenuPair> campi_menu(String titoli[], JMenuBar mB){ 
        
        ArrayList<MenuPair> listaMenu = new ArrayList<>();
        JMenu menu[] = new JMenu[titoli.length];
        for(int i = 0; i<titoli.length;i++){
            JMenu a = new JMenu(titoli[i]);
            menu[i] = a;
        }
        for(JMenu a : menu){ mB.add(a); }

        MenuPair menuPair = new MenuPair(mB, menu);
        listaMenu.add(menuPair); 
        return listaMenu;  
    }
}
