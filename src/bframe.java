import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class bframe extends JFrame implements ActionListener , KeyListener , MouseListener{



public final int HEIGHT = 800;
public final int WIDTH = 1200;

JButton button1;
JButton button2;
JButton button3;
JButton button4;

JLabel moveLabel;









    public bframe()
    {

        //#region Frame Basics
        // null = no Particular Layout structure, Elements are placed and sized Manually  , .pack() function doesnt work well without layout manager
        this.setLayout(null);

        // centers the Frame
        this.setLocationRelativeTo(null);

        // 
        this.setSize(WIDTH,HEIGHT);

        // puts center of frame on center of screen
        this.setLocation((int)(this.getLocation().x -0.5*WIDTH), (int)(this.getLocation().y -0.5*HEIGHT));


        // 
        this.setResizable(true);

        // defines function on clicking x in top right corner
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.pack();

        this.addKeyListener(this);

        //
        this.setVisible(true);

        //#endregion 

        //#region Title, Icon , Background

        //
        this.setTitle("Practice Frame");

        //
        ImageIcon icon = new ImageIcon("src\\resources\\Icon_Gear.png"); // full path : H:\\Projects\\Java\\Practice\\GUI_Practice_01\\src\\resources\\Icon_Gear.png
        this.setIconImage(icon.getImage());

        //
        this.getContentPane().setBackground(Color.cyan);
        //#endregion

        //#region Set buttons

        button1 = new JButton("Button1");
        button1.setBounds(1085, 0, 100, 100);
        this.add(button1);


        button2 = new JButton("Button2");
        button2.setBounds(1085, 100, 100, 100);
        this.add(button2);

        button3 =  new JButton("Button3");
        button3.setBounds(1085,200,100,100);
        this.add(button3);

        button4 = new JButton("Button4");
        button4.setBounds(1085, 300, 100, 100);
        this.add(button4);



        //#endregion


        //#region other
        moveLabel = new JLabel();
        moveLabel.setIcon(new ImageIcon("src\\resources\\ICON_anime_cute_2.jpg"));
        moveLabel.setBounds(500,500,222,222);
        this.add(moveLabel);


        //#endregion

        this.addMouseListener(this);
    }

    public void set(int r ,int g , int b)
    {
        this.getContentPane().setBackground(new Color(r,g,b));
    }

    public void update()
    {
        this.setSize(WIDTH, HEIGHT+1);
        this.setSize(WIDTH,HEIGHT);
    }

    public void createButton(int x , int y , int width , int height)
    {
        button1 =  new JButton();
        button1.setText("FUCK");
        this.add(button1);
        button1.addActionListener(this);
        button1.setBounds(x, y, width, height); 

    }

    public void fillProgressBar(JProgressBar bar)
    {
        int barcounter = 0;

        while(barcounter<=bar.getMaximum())
        {
            
           bar.paintAll(bar.getGraphics());
           bar.setValue(barcounter);
           barcounter+=5;
           try {
            Thread.sleep(55);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        }
        bar.setString("Done :3");

    }




    @Override
    public void actionPerformed(ActionEvent e) {

        //! button1
        if(e.getSource() == button1)
        {       
            
            // System.out.println(java.time.LocalTime.now());
            // if(button1.getText().equals("FUCK"))
            // {
            //     button1.setText("YOU!");
            // } else{
            //     button1.setText("FUCK");
            // }

        }


        
    }

    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyChar()) {
            case 'w':
                moveLabel.setLocation(moveLabel.getX(), moveLabel.getY()-5);
                break;

            case 'a':
                moveLabel.setLocation(moveLabel.getX()-5, moveLabel.getY());
                break;

            case 's':
            moveLabel.setLocation(moveLabel.getX(), moveLabel.getY()+5);
                break;

            case 'd':
            moveLabel.setLocation(moveLabel.getX()+5, moveLabel.getY());
                break;
        
            default:
                break;
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("Mouse Clicked");
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println("Mouse Pressed");
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        System.out.println("Mouse Released");

        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");


        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");



    }
    



}
