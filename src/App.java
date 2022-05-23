import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.Dimension;


public class App {


    public static void main(String[] args) throws Exception 
    {


        bframe frame = new bframe();



//#region Labels

        JLabel label1 = new JLabel();

        // Set Image
        label1.setIcon(new ImageIcon("src\\resources\\Icon_Anime_Cute.jpg"));

        //
        label1.setText("test");

        //Set text position Relative to Image
        label1.setVerticalTextPosition(JLabel.TOP);
        label1.setHorizontalTextPosition(JLabel.CENTER);

        //Text color
        label1.setForeground(Color.green);

        //
        label1.setIconTextGap(10);

        // add to frame
        frame.add(label1);

        // use this without Layout Manager , otherwise use e.g. label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(600, 600, 300, 300);

        
        // frame.setIconImage(new ImageIcon("src\\resources\\Icon_Anime_Cute.jpg").getImage());

    //#endregion
        
//#region Panels
        bpanel panel = new bpanel(0, 0, 400, 400, Color.red, null);
        frame.add(panel);
        frame.update();
        // can add things to panel, those behave relative to the panel they are in
        JLabel label2 = new JLabel("Heyho");
        panel.add(label2);
        label2.setBounds(50, 50, 100, 30);
        label2.setFont(new Font("Arial" , Font.BOLD , 22)); //!--------------------------------------------------------------- 暗記？

//#endregion

//#region LayeredPane
JLayeredPane lp = new JLayeredPane();
frame.add(lp);
lp.setBounds(0, 500, 300, 300);

//#region Define Panels
JLabel llabel1 =  new JLabel();
llabel1.setOpaque(true);
llabel1.setBackground(Color.red);
llabel1.setBounds(0, 0, 50, 50);

JLabel llabel2 =  new JLabel();
llabel2.setOpaque(true);
llabel2.setBackground(Color.blue);
llabel2.setBounds(25, 25, 50, 50);


JLabel llabel3 =  new JLabel();
llabel3.setOpaque(true);
llabel3.setBackground(Color.green);
llabel3.setBounds(50, 50, 50, 50);
//#endregion

//Wrapped integer =  depth of the Pane. 0 = bottom , 4 = top
lp.add(llabel1 , Integer.valueOf(0));
lp.add(llabel2 , Integer.valueOf(1));
lp.add(llabel3 , Integer.valueOf(2));

//#endregion

//#region Open new Window
    frame.button1.addActionListener(e-> new NewFrame(frame));

//#endregion

//#region Message Windows (Popups)
// JOptionPane.showMessageDialog(frame, "CLOSED_OPTION", "title", JOptionPane.CLOSED_OPTION); // -1
// JOptionPane.showMessageDialog(frame, "DEFAULT_OPTION", "title", JOptionPane.DEFAULT_OPTION); // -1
// JOptionPane.showMessageDialog(frame, "PLAIN_MESSAGE", "title", JOptionPane.PLAIN_MESSAGE); //-1

// JOptionPane.showMessageDialog(frame, "YES_NO_OPTION", "title", JOptionPane.YES_NO_OPTION); //0
// JOptionPane.showMessageDialog(frame, "YES_OPTION", "title", JOptionPane.YES_OPTION); //0
// JOptionPane.showMessageDialog(frame, "ERROR_MESSAGE", "title", JOptionPane.ERROR_MESSAGE); // 0
// JOptionPane.showMessageDialog(frame, "OK_OPTION", "title", JOptionPane.OK_OPTION); //0

// JOptionPane.showMessageDialog(frame, "INFORMATION_MESSAGE", "title", JOptionPane.INFORMATION_MESSAGE); //1
// JOptionPane.showMessageDialog(frame, "NO_OPTION", "title", JOptionPane.NO_OPTION); //1
// JOptionPane.showMessageDialog(frame, "YES_NO_CANCEL_OPTION", "title", JOptionPane.YES_NO_CANCEL_OPTION); //1

// JOptionPane.showMessageDialog(frame, "CANCEL_OPTION", "title", JOptionPane.CANCEL_OPTION); //2
// JOptionPane.showMessageDialog(frame, "OK_CANEL_OPTION", "title", JOptionPane.OK_CANCEL_OPTION); //2
// JOptionPane.showMessageDialog(frame, "WARNING_MESSAGE", "title", JOptionPane.WARNING_MESSAGE); //2

// JOptionPane.showMessageDialog(frame, "QUESTION_MESSAGE", "title", JOptionPane.QUESTION_MESSAGE); //3

//#endregion

//#region Textfields

JTextField tf =  new JTextField();
tf.setText("input...");
frame.add(tf);
tf.setBounds(1000,100,100,50);
frame.button1.addActionListener(e-> System.out.println(tf.getText()));
//#endregion

//#region Checkboxes

JCheckBox check  = new JCheckBox();
check.setText("I'm gay");

check.addActionListener(e-> 
{
    System.out.println("ur gay");
}
);

frame.add(check);
check.setBounds(1000,500,20,20);


//#endregion

//#region JRadiobutton [button thats on or off]
JRadioButton rad =  new JRadioButton();
rad.setText("radiobutton");
frame.add(rad);
rad.setBounds(1000,200,20,20);
rad.addActionListener(e->
{
    System.out.println("Radio clicked");
    if(rad.isSelected())
{
    System.out.println("rad is enabled");
}
});

//#endregion

//#region Combo boxes [dropdown Menu]

JComboBox cumbox =  new JComboBox<>();
cumbox.addItem("item1");
cumbox.addItem("item2");
frame.add(cumbox);
cumbox.setBounds(1000,400,100,30);
cumbox.addActionListener(e-> {
    System.out.println(cumbox.getSelectedItem());
}  );

//#endregion

//#region Sliders

    JSlider slider =  new JSlider(0,100,50);
    slider.setBounds(400, 0, 50, 200);
    slider.setPreferredSize(new Dimension(400,200));
    slider.setPaintTicks(true);
    slider.setMinorTickSpacing(10);
    slider.setPaintTrack(true);
    slider.setMajorTickSpacing(25); 
    slider.setPaintLabels(true);
    frame.add(slider);
    slider.setOrientation(JSlider.VERTICAL);

    // label to show chosen number
    JLabel label3 = new JLabel();
    label3.setText(Integer.toString(slider.getValue()));
    label3.setBounds(450,-100,500,500);
    label3.setFont(new Font(null,0,100));
    slider.addChangeListener(e-> label3.setText(Integer.toString(slider.getValue())));
    frame.add(label3);
    frame.update();



//#endregion


//#region Progress Bar

    JProgressBar bar = new JProgressBar();
    bar.setValue(0);
    bar.setBounds(0, 400, 300, 100);
    bar.setStringPainted(true);
    bar.setMaximum(100);
    bar.setForeground(Color.green);
    bar.setBackground(Color.black);
    frame.add(bar);

    frame.button2.addActionListener((e) -> frame.fillProgressBar(bar));





    
//#endregion

//#region   Menubars

    JMenuBar menubar = new JMenuBar();

    JMenu fileMenu = new JMenu("Files");
    JMenu editMenu = new JMenu("Edit");
    JMenu helpMenu  = new JMenu("Help");

    JMenuItem file_open =  new JMenuItem("Open file");
    JMenuItem file_save = new JMenuItem("Save file");
    JMenuItem file_save_as = new JMenuItem("Save file as...");
    fileMenu.add(file_open);
    fileMenu.add(file_save);
    fileMenu.add(file_save_as);


    JMenuItem edit_undo = new JMenuItem("Undo (CTRL+Z)");
    JMenuItem edit_redo = new JMenuItem("Redo (SHIFT+CTRL+Z)");
    editMenu.add(edit_undo);
    editMenu.add(edit_redo);


    JMenuItem help_guide = new JMenuItem("Open Guide");
    helpMenu.add(help_guide);

    menubar.add(fileMenu);
    menubar.add(editMenu);
    menubar.add(helpMenu);

    //example on adding functionality:
    file_open.addActionListener(e-> System.out.println("File was Opened"));

    // you can add shortcuts to menu options
    file_open.setMnemonic(KeyEvent.VK_O); // pressing O will open a file , this only works when the Parent menu is currently selected so we add a mnemonic for that too:
    fileMenu.setMnemonic(KeyEvent.VK_F); // here only ALT+F will open the Parent menu


    frame.setJMenuBar(menubar);
    frame.update();


    



//#endregion

//#region FileChooser

    frame.button3.addActionListener
    ( e->
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\felix\\Downloads"));
            int response = fileChooser.showOpenDialog(null); // this returns 1 or 0 dependig on whether or not the selection was successful
            if(response != 1)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }

        }
    );

    // theres also fileChooser.showSaveDialog(null); which can then save a file.


//#endregion


//#region colorpicker

    JLabel label4 = new JLabel("Change my color!");
    // label4.setHorizontalTextPosition(JLabel.TOP);
    label4.setBounds(1085,640,100,100);
    label4.setOpaque(true);
    label4.setBackground(Color.black);
    frame.add(label4);

    frame.button4.addActionListener(e->
    {
        JColorChooser colorChooser = new JColorChooser();
        Color newColor = colorChooser.showDialog(null, "Pick a Color", Color.black);
        label4.setBackground(newColor);
    });



//#endregion


//#region KeyListener




//#endregion

//#region Rainbow Algorithm
    //** 

    // frame.getContentPane().setBackground(new Color(0,0,0));
    // boolean endrainbow = false;
    // while(!endrainbow)
    // {
    //     //start RED
    //     frame.set(255,0,0);

    //     // Turn YELLOW
    //     for (int i = 0; i < 255; i++) {
    //         frame.set(255, i, 0);
    //         Thread.sleep(5);
    //         System.out.println(i);
    //     }

    //     // Turn Cyan
    //     for (int i = 0; i < 255; i++) {
    //         frame.set(255-i, 255, i);
    //         Thread.sleep(5);
    //         System.out.println("2: " +i);
    //     }

    //     //Turn Blue
    //     for (int i = 0; i < 255; i++) {
    //         frame.set(0,255-i,255);
    //         Thread.sleep(5);
    //         System.out.println("3: " +i);
    //     }

    //     // Turn Red
    //     for (int i = 0; i < 255; i++) {
    //         frame.set(0+i, 0, 255-i);
    //         Thread.sleep(5);
    //     }
    // }


    //#endregion   

        
       

    }




}
