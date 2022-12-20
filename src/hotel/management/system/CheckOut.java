
package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import java.sql.*;
// import net.proteanit.sql.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener
{
    Choice ccustomer;
    
    JLabel lblroomnumber, lblcheckin ,lblcheckintime ,lblcheckout ,lblcheckouttime  ;
    
    JButton checkout ,back;
    CheckOut()
    {
          JFrame frame = new JFrame("Check Out");
        Border emptyBorder = BorderFactory.createEmptyBorder();
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Check Out");
        text.setFont(new Font("Railway", Font.PLAIN, 20));
        text.setBounds(100, 20, 100, 30);
        frame.add(text);
        
        JLabel lblid = new JLabel("Customer Id");
       // lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        lblid.setBounds(30, 80, 100, 30); //30, 230, 100, 30
        frame.add(lblid);
        
         ccustomer = new Choice();
        // lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        ccustomer.setBounds(150, 80, 180, 25);
        frame.add(ccustomer);

      
       
        
        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(30, 130, 100, 30);
        frame.add(l2);
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 180, 30);
        frame.add(lblroomnumber);
        
        lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 180, 100, 30);
       frame.add(lblcheckin);
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 180, 30);
        frame.add(lblcheckintime);
        
          lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        frame.add(lblcheckout);
        
        Date date =new Date();
        
        lblcheckouttime = new JLabel(""+date);
        lblcheckouttime.setBounds(150, 230, 180, 30);
        frame.add(lblcheckouttime);
        
          try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
              

                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
                
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        checkout = new JButton("Check Out");
        checkout.setBounds(30, 280, 120, 30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        frame.add(checkout);
      //  checkout.setBorder(emptyBorder);

        back = new JButton("Back");
        back.setBounds(180, 280, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        frame.add(back);
     //   back.setBorder(emptyBorder);
        
           ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(350,50,400,250);
                frame.add(l1);
        
        frame.setLayout(null);
         frame.setBounds(300, 200, 800, 400);
         frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == checkout)
        {
           // String room  = croom.getSelectedItem();
            
          
           String roomm = lblroomnumber.getText();
           
           
         
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update  room set availability = 'Available' where roomnumber = '"+roomm+" ' ";
            String query3 = "update  room set cleaning_status = 'Cleaned'  ";
             
            
         try {
            Conn conn = new Conn();
            
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
             conn.s.executeUpdate(query3);
             JOptionPane.showMessageDialog(null , "Checkout Done");
             
            
             
             setVisible(false);
            new Reception();
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        }
        
        else
        {
            setVisible(false);
            new Reception();
        }
    }
    public static void main (String[] args)
    {
        new CheckOut();
    }
}
