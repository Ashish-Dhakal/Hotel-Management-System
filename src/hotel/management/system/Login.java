
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;

public class Login extends JFrame implements ActionListener {
    
    //to define globally to extract value in actionPerformed
    JTextField username,password;
    JButton rlogin, alogin,cancel;
    JLabel lblusername,lblpassword;
    
    Login()
        {
            
            JFrame frame = new JFrame("user LOGIN");
            getContentPane().setBackground(Color.WHITE);
            
            setLayout(null);
            
            //for usrename 
            lblusername = new JLabel ("Username");
            lblusername.setBounds(40,40,100,30);
            lblusername.setForeground(Color.white);
            frame.add(lblusername);
            
            username = new JTextField();
            username.setBounds(150,40,150,30);
            frame.add(username);
            
            //for password
            lblpassword = new JLabel("Password");
            lblpassword.setBounds(40,90,100,30);
            lblpassword.setForeground(Color.white);
            frame.add(lblpassword);
            
            password = new JPasswordField();
            password.setBounds(150,90,150,30);
            frame.add(password);
            
            //for login button
            alogin = new JButton("AL");
            alogin.setBounds(40,150,60,30);
            alogin.setFont(new Font("serif",Font.BOLD,15));          
            alogin.setBackground(Color.BLACK);
            alogin.setForeground(Color.WHITE);
            alogin.addActionListener(this);
            frame.add(alogin);
            
            rlogin = new JButton("RL");
            rlogin.setBounds(110,150,60,30);
            rlogin.setFont(new Font("serif",Font.BOLD,15));          
            rlogin.setBackground(Color.BLACK);
            rlogin.setForeground(Color.WHITE);
            rlogin.addActionListener(this);
            frame.add(rlogin);
            
            //for cancel button
            cancel = new JButton("Cancel");
            cancel.setBounds(180,150,120,30);
            cancel.setFont(new Font("serif",Font.BOLD,15));           
            cancel.setBackground(Color.BLACK);
            cancel.setForeground(Color.WHITE);
            cancel.addActionListener(this);
            frame.add(cancel);
            
           // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
           // Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
           // ImageIcon i3 =  new ImageIcon(i2);
          //  JLabel image = new JLabel(i3) ;
          //  image.setBounds(350,10,150,150);
          //  add(image);
            
            
            frame.setBounds(-10, 0, 1950, 1000);
            frame.setLayout(null);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
            Image i2 = i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2); 
	    JLabel image = new JLabel(i3);
            image.setBounds(0,0,600,300); 
            frame.add(image);
            
             
            
            frame.setBounds(470,200,600,300); 
            frame.setVisible(true);
        }
    public void close()
    {
        WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
        
    }
  
     public void actionPerformed(ActionEvent ae)      //to perfotm the login by clicking login button
     {
       if(ae.getSource()==alogin)         //getsource help to identify which button is clicked 
                {
                    String user = username.getText();     
                    String pass = password.getText();
                    
                    try
                        { 
                            Conn c = new Conn();
                            String query = "select * from login where username='"+user+"' and password='"+pass+"'";
                             
                            ResultSet rs =c.s.executeQuery(query);
                            if(rs.next())
                            { 
                              // new Dashboard().setVisible(true);
                              // this.setVisible(false);
                              
                              Dashboard db = new Dashboard();
                              db.setVisible(true);
                              
                              
                               
                              // new Dashboard();setVisible(true); //open the login portion
                              // this.setVisible(false);
                            

                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Invalid username or password");
                                setVisible(false); /////////
                                 
                            }
                            
                        }
                    catch(Exception e)
                        {
                        e.printStackTrace();
                        } 
                   
                }  
       if(ae.getSource()==rlogin)         //getsource help to identify which button is clicked 
                {
                    String user = username.getText();     
                    String pass = password.getText();
                    
                    try
                        { 
                            Conn c = new Conn();
                            String query = "select * from reception where username='"+user+"' and password='"+pass+"'";
                             
                            ResultSet rs =c.s.executeQuery(query);
                            if(rs.next())
                            { 
                              // new Dashboard().setVisible(true);
                              // this.setVisible(false);
                              
                              RDashboard db = new RDashboard();
                              db.setVisible(true);
                              
                              
                               
                              // new Dashboard();setVisible(true); //open the login portion
                              // this.setVisible(false);
                            

                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Invalid username or password");
                                setVisible(false); /////////
                                 
                            }
                            
                        }
                    catch(Exception e)
                        {
                        e.printStackTrace();
                        } 
                   
                } 
         if (ae.getSource()==cancel)
                {
                    setVisible(false);
                    new HotelManagementSystem();
                  
                    
                }
     /*    else if (ae.getSource() == login)
        {
            String user = username.getText();     
            String pass = password.getText();
            
            try
            {
                Conn c = new Conn();
                
                  String query = "select * from login where username='"+user+"' and password='"+pass+"'";
                                   
            String query1 = "select * from login where username = 'ashish' AND password = 'ashish' ";
            String query2 = "select * from login where username = 'sundar' AND password = 'sundar' ";
                             
                            ResultSet rs =c.s.executeQuery(query);
                            ResultSet rs1 =c.s.executeQuery(query1);
                            ResultSet rs2 =c.s.executeQuery(query2);
                            if(rs.next() )
                            { 
                                  
                                new Dashboard().setVisible(true);
                                setVisible(false);
                            }
                            
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Invalid username or password");
                                setVisible(true); /////////
                            }
                            
           
            
           
        
            
          
               
            }
           catch(Exception e)
                        {
                        e.printStackTrace();
                        } 
            
            
        } */
     
     }
    
    
    
    
    public static void main(String[] args)
    {
        new Login();
        
                   
    }
    
}
