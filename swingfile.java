import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class swingfile extends JFrame implements ActionListener
{
    static JFrame f;
    static JTextField t1;
    static JTextField t2;
    static JTextField t3;
    static JButton b1;
    static JButton b2;
    static JLabel l1;
    String res1,res2,res3;
    swingfile()
    {
        res1=res2=res3="";
    }
    public static void main(String args[])
    {
        swingfile sf = new swingfile();

        f = new JFrame("file opertaion");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        b1 = new JButton("SAVE");
        b2 = new JButton("retreve");
        l1 = new JLabel("enter here");

        t1.setBounds(100,30,100,50);
        t2.setBounds(100,160,100,50);
        t3.setBounds(100,240,100,50);
        b1.setBounds(250,100,100,60);
        b2.setBounds(250,220,100,60);
        l1.setBounds(1,30,100,50);
        f.setSize(500,500);

        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(b1);
        f.add(b2);
        f.add(l1);

        b1.addActionListener(sf);
        b2.addActionListener(sf);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try 
            {
                String str = t1.getText();
                FileWriter fw = new FileWriter("text.txt");
                fw.write(str);
                fw.close();
            }catch(Exception e)
            {
                System.out.println("error occured");
            }
            t2.setText("saved");
        }
        else if(ae.getSource() == b2)
        {
            String s="";
            try 
            {
                FileReader fr = new FileReader("text.txt");
                int c;
                do
                {
                    c = fr.read();
                    if(c != -1)
                    s += (char)c;
                }while(c != -1);
                fr.close();
            }catch(Exception e)
            {
                System.out.println("error occured");
            }
            t2.setText("received");
            t3.setText(s);
        }
    }
}