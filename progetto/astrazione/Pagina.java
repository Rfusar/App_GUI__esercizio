package progetto.astrazione;

import javax.swing.JFrame;

public class Pagina {

    //GETTER E SETTER PER JFRAME
    private JFrame frame = new JFrame();

        public JFrame getFrame() {return frame;}

        public void setFrame(JFrame frame, String titolo, int size[], boolean ridimesiona) { 
            this.frame = frame;
            this.frame.setTitle(titolo);
            if(size != null){ this.frame.setSize(size[0], size[1]); }
                else{this.frame.setSize(500, 500);}
            this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
            this.frame.setResizable(ridimesiona);
        
        }
}
