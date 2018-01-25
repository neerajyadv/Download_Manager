import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//this is a class which creates the UI of our download manager. 
//It uses Swing to create components


public class DownloadManagerUI
{
    

    DownloadManagerUI()
    {
        JFrame frame = new JFrame("Download Manager");
        JPanel panel=new JPanel();
        panel.setLayout(null);
        
        panel.setBounds(0, 0, 600, 400);
        panel.setBackground(Color.gray);

        //create a jpnel, then infront of it its jtextfield, and infront of it jbutton
        //JLabel
        JLabel url1 = new JLabel("URL");
        url1.setBounds(5, 10, 100, 50);

        //JtextField
        JTextField jtf1 = new JTextField();
        jtf1.setBounds(80, 20, 350, 30);
        //JButton
        JButton jb1 = new JButton("Download");
        jb1.setBounds(460, 20, 100, 30);

        JLabel url2 = new JLabel("URL");
        url2.setBounds(5, 70, 100, 50);
        // JtextField
        JTextField jtf2 = new JTextField();
        jtf2.setBounds(80, 80, 350, 30);
        //JButton
        JButton jb2 = new JButton("Download");
        jb2.setBounds(460, 80, 100, 30);

        JLabel url3 = new JLabel("URL");
        url3.setBounds(5, 140, 100, 50);
        // //JtextField
        JTextField jtf3 = new JTextField();
        jtf3.setBounds(80, 150, 350, 30);
        //JButton
        JButton jb3 = new JButton("Download");
        jb3.setBounds(460, 150, 100, 30);

        JLabel url4 = new JLabel("URL");
        url4.setBounds(5, 210, 100, 50);
        // //JtextField
        JTextField jtf4 = new JTextField();
        jtf4.setBounds(80, 220, 350, 30);
        //JButton
        JButton jb4 = new JButton("Download");
        jb4.setBounds(460, 220, 100, 30);

        panel.add(url1);
        panel.add(url2);
        panel.add(url3);
        panel.add(url4);
        panel.add(jtf1);
        panel.add(jtf2);
        panel.add(jtf3);
        panel.add(jtf4);
        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);
        panel.add(jb4);
        

        //setting up the frame
        frame.add(panel);

        frame.setSize(600, 300);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        jb1.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
             String url=  jtf1.getText();

             DownloadButtonAction db=new DownloadButtonAction(url);
            }
        } );
        
    }
    

    public static void main(String... s) {
        new DownloadManagerUI();
    }


    public class DownloadButtonAction
{
    String url;
    public DownloadButtonAction(String url)
    {
        
        this.url=url;

        DownloadData dl=new DownloadData(url);

        Thread t1=new Thread(dl);
        t1.start();
    }
}
}