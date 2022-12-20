
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class AddFood extends JFrame implements ActionListener
{
    
    JTextField  tffoodno,tffname, tfprice;
    JLabel heading , lblfoodno,lblfname,lblclean,lblprice,lbltype;
    JComboBox availablecombo,cleancombo,typecombo;
    JButton add,cancel;
    public AddFood()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        heading = new JLabel("Add Food");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	heading.setBounds(150, 20, 200, 20);
	add(heading);
        
        lblfoodno = new JLabel("Food Code");
	lblfoodno.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblfoodno.setBounds(60, 80, 120, 30);
	add(lblfoodno);
        
        tffoodno = new JTextField();
	tffoodno.setBounds(200, 80, 150, 30);
	add(tffoodno);
        
        lblfname = new JLabel("Food name");
	lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblfname.setBounds(60, 130, 120, 30);
	add(lblfname);
        
        tffname = new JTextField();
	tffname.setBounds(200, 130, 150, 30);
	add(tffname);
      
       
        
        lblprice = new JLabel("Price");
	lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblprice.setBounds(60, 180, 120, 30);
	add(lblprice);
        
        tfprice = new JTextField();
	tfprice.setBounds(200, 180, 150, 30);
	add(tfprice);
        
       
        
        add = new JButton("Add Food");
	add.addActionListener(this);
	add.setBounds(60, 350, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
	add(add);

	cancel = new JButton("Cancel");
	cancel.addActionListener(this);
	cancel.setBounds(220, 350, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
	add(cancel);
        
           // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
           // Image i2 = i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
           // ImageIcon i3 = new ImageIcon(i2); 
	   // JLabel image = new JLabel(i3);
           // image.setBounds(0,0,600,300); 
           // add(image);
        
         setBounds(200, 150, 425, 450);
         setVisible(true);
         
         
    }
    public void actionPerformed(ActionEvent ae){
       
            if(ae.getSource()==add)
            {
                String foodnumber = tffoodno.getText();
                String foodname = tffname.getText();
               
                String price  = tfprice.getText();
                
                
                try
                {
                    Conn conn = new Conn();
                    String str = "INSERT INTO food values( '"+foodnumber+"', '"+foodname+"','"+price+"')";
                    conn.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Food Successfully Added"); 
                    setVisible(true);
                    
                }
                catch(Exception ee)
                {
                    System.out.println(ee);
                  //  JOptionPane.showMessageDialog(null, "Room Successfhghhhhhhhhhhhhhhully Added");
                }
                 
                }
            else if(ae.getSource() == cancel){
                this.setVisible(false);
            }
            else
            {
                
            }
            }
                
    
    public static void main(String[] args) {
        new AddFood().setVisible(true);
}
    
}


