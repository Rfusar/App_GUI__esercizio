package progetto.astrazione.variabili;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuPair{
    JMenuBar menuBar;
    JMenu[] menus;

    public void setMenuBar(JMenuBar menuBar){this.menuBar = menuBar;}
    public JMenuBar getMenuBar() {return menuBar;}

    public void setMenus(JMenu[] menus){this.menus = menus;}
    public JMenu[] getMenus() {return menus;}
}
