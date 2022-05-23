import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class NewFrame extends JFrame {
    

    public NewFrame(JFrame parentFrame)
    {
        this.setLayout(null);
        this.setLocationRelativeTo(parentFrame);
        this.setSize(400,400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //! Dispose means only current window will close, exit on close will close all JFrames currently employed
        this.setVisible(true);
    }

}
