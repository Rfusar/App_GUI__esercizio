package progetto.astrazione;

import javax.swing.JFrame;

public class Pagina {

    private JFrame frame = new JFrame();;

    public void setFrame(JFrame frame, String titolo, int size[], boolean ridimesiona) { 
        this.frame = frame;
        this.frame.setTitle(titolo);
        this.frame.setSize(size[0], size[1]);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(ridimesiona);
        
    }
    public JFrame getFrame() {return frame;}




}
