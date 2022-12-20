
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class AddDriver extends JFrame implements ActionListener
{
    
    JTextField  tfname,tfage,tfcompany,tflocation;
    JLabel heading , lblname,lblage,lbllocation,lblavailable,lblgender,lblcarcompany;
    JComboBox availablecombo,gendercombo;
    JButton add,cancel;
    
    public AddDriver()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	heading.setBounds(150, 20, 200, 20);
	add(heading);
        
        lblname = new JLabel("Name");
	lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblname.setBounds(60, 80, 120, 30);
	add(lblname);
        
        tfname = new JTextField();
	tfname.setBounds(200, 80, 150, 30);
	add(tfname);
        
        lblage = new JLabel("Age");
	lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblage.setBounds(60, 130, 120, 30);
	add(lblage);
        
        tfage = new JTextField();
	tfage.setBounds(200, 130, 150, 30);
	add(tfage);
        
        lblgender = new JLabel("Geder");
	lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblgender.setBounds(60, 180, 120, 30);
	add(lblgender);
        
        gendercombo = new JComboBox(new String[] { "Male", "Female" });
	gendercombo.setBounds(200, 180, 150, 30);
        gendercombo.setBackground(Color.white);
	add(gendercombo);
        
        lblcarcompany = new JLabel("Car Company");
	lblcarcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblcarcompany.setBounds(60, 230, 120, 30);
	add(lblcarcompany);
        
        tfcompany = new JTextField();
	tfcompany.setBounds(200, 230, 150, 30);
	add(tfcompany);
        
        lblavailable = new JLabel("Availability");
	lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblavailable.setBounds(60, 280, 120, 30);
	add(lblavailable);
        
        availablecombo = new JComboBox(new String[] { "Availabile", "ON DUTY" });
	availablecombo.setBounds(200, 280, 150, 30);
        availablecombo.setBackground(Color.white);
	add(availablecombo);
                
       
        lbllocation = new JLabel("Location");
	lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lbllocation.setBounds(60, 330, 120, 30);
	add(lbllocation);


        tflocation = new JTextField();
	tflocation.setBounds(200, 330, 150, 30);
	add(tflocation);
        
        add = new JButton("Add Driver");
	add.addActionListener(this);
	add.setBounds(60, 380, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
	add(add);

	cancel = new JButton("Cancel");
	cancel.addActionListener(this);
	cancel.setBounds(220, 380, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
	add(cancel);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
                Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel l15 = new JLabel(i3);
                l15.setBounds(400,80,500,300);
                add(l15);
        
        
        
        
        
        
         setBounds(200, 150, 1000, 500);
         setVisible(true);
         
         
    }
    public void actionPerformed(ActionEvent ae){
       
            if(ae.getSource() == add)
            {
                String name = tfname.getText();
                String age = tfage.getText();
                String gender = (String)gendercombo.getSelectedItem();
                String company  = tfcompany.getText();
                String availabile  = (String) availablecombo.getSelectedItem();
                String location  = tflocation.getText();
                
                        if (name.equals("")|| location.equals("") )
         {
              JOptionPane.showMessageDialog(null,"Something is missing","Alert",JOptionPane.WARNING_MESSAGE); 
             return;
         }
                
                try
                {
                    Conn conn = new Conn();
                    String str = "INSERT INTO driver values( '"+name+"', '"+age+"','"+gender+"', '"+company+"', '"+availabile +"', '"+location+"')";
                    conn.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    setVisible(false);
                    
                }
                catch(Exception ee)
                {
                    System.out.println(ee);
                }
                 
                }
            else if(ae.getSource() == cancel){
                this.setVisible(false);
            }
            }
                
    
    public static void main(String[] args) {
        new AddDriver().setVisible(true);
}
    
}


