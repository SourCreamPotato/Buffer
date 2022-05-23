import javax.swing.JPanel;
import java.awt.Color;
import java.awt.LayoutManager;

public class bpanel extends JPanel {

    public bpanel()
    {

    }

    public bpanel(int x , int y , int width , int height , Color backgroundColor , LayoutManager layoutManager)
    {
        this.setBounds(x, y, width, height);
        this.setBackground(backgroundColor);
        this.setLayout(layoutManager);
    }
    
}
