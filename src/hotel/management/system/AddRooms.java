
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class AddRooms extends JFrame implements ActionListener
{
    
    JTextField  tfroom,tfprice;
    JLabel heading , lblroomno,lblavailable,lblclean,lblprice,lbltype;
    JComboBox availablecombo,cleancombo,typecombo;
    JButton add,cancel;
    public AddRooms()
    {
        JFrame frame = new JFrame("Add Room");
        getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        
        heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	heading.setBounds(150, 20, 200, 20);
	frame.add(heading);
        
        lblroomno = new JLabel("Room Number");
	lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblroomno.setBounds(60, 80, 120, 30);
	frame.add(lblroomno);
        
        tfroom = new JTextField();
	tfroom.setBounds(200, 80, 150, 30);
	frame.add(tfroom);
        
        lblavailable = new JLabel("Availability");
	lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblavailable.setBounds(60, 130, 120, 30);
	frame.add(lblavailable);
        
        availablecombo = new JComboBox(new String[] { "Available", "Occupied" });
	availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.white);
	frame.add(availablecombo);
        
        lblclean = new JLabel("Cleaning Status");
	lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblclean.setBounds(60, 180, 120, 30);
	frame.add(lblclean);
        
        cleancombo = new JComboBox(new String[] { "Cleaned", "Dirty" });
	cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.white);
	frame.add(cleancombo);
        
        lblprice = new JLabel("Price");
	lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblprice.setBounds(60, 230, 120, 30);
	frame.add(lblprice);
        
        tfprice = new JTextField();
	tfprice.setBounds(200, 230, 150, 30);
	frame.add(tfprice);
        
        lbltype = new JLabel("Bed Type");
	lbltype.setFont(new Font("Tahoma", Font.BOLD, 16));
	lbltype.setBounds(60, 280, 120, 30);
	frame.add(lbltype);


        typecombo = new JComboBox(new String[] { "Single Bed", "Double Bed"});
	typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.white);
	frame.add(typecombo);
        
        add = new JButton("Add Room");
	add.addActionListener(this);
	add.setBounds(150, 350, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
	frame.add(add);

	cancel = new JButton("Cancel");
	cancel.addActionListener(this);
	cancel.setBounds(220, 350, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
	frame.add(cancel);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,300);
                frame.add(l15);
        
        
        
        
        
        
         frame.setBounds(200, 150, 1000, 450);
         frame.setVisible(true);
         
         
    }
    public void actionPerformed(ActionEvent ae){
       
            if(ae.getSource()==add)
            {
                String roomnumber = tfroom.getText();
                String availability = (String) availablecombo.getSelectedItem();
                String status = (String)cleancombo.getSelectedItem();
                
                String price  = tfprice.getText();
                String type = (String)typecombo.getSelectedItem();
                
                    if (roomnumber.equals("") )
         {
              JOptionPane.showMessageDialog(null,"Something is missing","Alert",JOptionPane.WARNING_MESSAGE); 
             return;
         }
                
                try
                {
                    Conn conn = new Conn();
                    String str = "INSERT INTO room values( '"+roomnumber+"', '"+availability+"', '"+status+"','"+price+"', '"+type+"')";
                    conn.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    setVisible(false);
                    
                    
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
            
            }
                
    
    public static void main(String[] args) {
        new AddRooms().setVisible(true);
}
    
}


