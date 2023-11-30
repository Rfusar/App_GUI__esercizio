package progetto.astrazione.logica;


import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//MY_PACKAGE
import progetto.componenti.Menu;
import progetto.astrazione.variabili.MenuPair;




public class Home_page extends Menu{

    //CREAZIONE DINAMICA DEI CAMPI MENU ===> CLASS MenuPair
    public MenuPair campi_menu(String titoli[], JMenuBar mB){ 

        MenuPair menuPair =  new MenuPair();
        JMenu menu[] = new JMenu[titoli.length];
        for(int i = 0; i<titoli.length;i++){
            JMenu a = new JMenu(titoli[i]);
            menu[i] = a;
        }
        for(JMenu a : menu){ mB.add(a); }
        
        menuPair.setMenuBar(mB);
        menuPair.setMenus(menu);
        return  menuPair;
    }

    //FUNZIONALITA CERCA FILE
    public void cerca__FILE(JMenu m, String titolo_sottoMenu){
        JMenuItem itemCercaFile = new JMenuItem(titolo_sottoMenu);
        itemCercaFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.showOpenDialog(null);
            }
        });
        m.add(itemCercaFile);
    }

    
}
