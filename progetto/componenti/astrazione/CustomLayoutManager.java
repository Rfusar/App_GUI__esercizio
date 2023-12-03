package progetto.componenti.astrazione;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class CustomLayoutManager implements LayoutManager {

    public JComponent[] creaArray(JComponent... elementi){
        JComponent array[] = new JComponent[elementi.length];
        for(int i = 0; i < elementi.length; i++){ array[i] = elementi[i];}
        return array;
    }

    public void aggiungiElementoAlPannello(JPanel pannello, JComponent elementi[]){
        for(JComponent i : elementi){ pannello.add(i); }
    }


    @Override
    public void addLayoutComponent(String name, Component comp) {
        // In questo esempio, il layout manager non tiene traccia dei componenti aggiunti.
        // Puoi implementare la logica qui se necessario.
    }

    @Override
    public void layoutContainer(Container parent) {
        // Posiziona i componenti nel container
        int x = 0;
        int y = 0;

        for (Component component : parent.getComponents()) {
            // Imposta la posizione e la dimensione di ciascun componente
            component.setBounds(x, y, component.getPreferredSize().width, component.getPreferredSize().height);

            // Aggiorna le coordinate per il prossimo componente (esempio: posizionamento orizzontale)
            x += component.getPreferredSize().width;
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        // Restituisci la dimensione minima richiesta dal layout (esempio: somma delle dimensioni minime dei componenti)
        int minWidth = 0;
        int minHeight = 0;

        for (Component component : parent.getComponents()) {
            minWidth += component.getMinimumSize().width;
            minHeight += component.getMinimumSize().height;
        }

        return new Dimension(minWidth, minHeight);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        // Restituisci la dimensione preferita richiesta dal layout (esempio: somma delle dimensioni preferite dei componenti)
        int prefWidth = 0;
        int prefHeight = 0;

        for (Component component : parent.getComponents()) {
            prefWidth += component.getPreferredSize().width;
            prefHeight += component.getPreferredSize().height;
        }

        return new Dimension(prefWidth, prefHeight);
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // Nel tuo esempio, il layout manager non tiene traccia dei componenti aggiunti.
        // Puoi implementare la logica qui se necessario.
    }
}

