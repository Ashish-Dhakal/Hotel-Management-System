package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;

public class UpdateRoom extends JFrame implements ActionListener {

    JLabel text, lblid, lblroom, lblname, lblpaid, lblpending, lblcheckin, lbllroom;

    JTextField tfroom, tfname, tfpaid, tfpending, tfcheckin , tfavailable, tfstatus;

    Choice ccustomer;

    JButton back, update, check;

    UpdateRoom() {
        JFrame frame = new JFrame("Check Update");
        getContentPane().setBackground(Color.WHITE);

        text = new JLabel("Update Room Status");
        text.setFont(new Font("Railway", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
        add(text);

        lblid = new JLabel("Customer Id");
        // lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        ccustomer = new Choice();
        // lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {

                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblroom = new JLabel("Room Number");
        // lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        lblroom.setBounds(30, 130, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        // tfroom.setFont(new Font("Railway", Font.PLAIN, 20));
        tfroom.setBounds(200, 130, 150, 25);
        add(tfroom);

        lblname = new JLabel("Availability");
        // lblname.setFont(new Font("Railway", Font.PLAIN, 20));
        lblname.setBounds(30, 180, 100, 20);
        add(lblname);

        tfavailable = new JTextField();
        // tfavailable.setFont(new Font("Railway", Font.PLAIN, 20));
        tfavailable.setBounds(200, 180, 150, 25);
        add(tfavailable);

        lblcheckin = new JLabel("Cleaning Status");
        // lblcheckin.setFont(new Font("Railway", Font.PLAIN, 20));
        lblcheckin.setBounds(30, 230, 100, 20);
        add(lblcheckin);

        tfstatus = new JTextField();
        // tfstatus.setFont(new Font("Railway", Font.PLAIN, 20));
        tfstatus.setBounds(200, 230, 150, 25);
        add(tfstatus);

      

        check = new JButton("CHECK");
        check.setBounds(30, 300, 100, 30);
        check.addActionListener(this); //action to be performed here
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        // back.setBorder(emptyBorder);
        add(check);

        update = new JButton("UPDATE");
        update.setBounds(150, 300, 100, 30);
        update.addActionListener(this); //action to be performed here
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        // update.setBorder(emptyBorder);
        add(update);

        back = new JButton("BACK");
        back.setBounds(270, 300, 100, 30);
        back.addActionListener(this); //action to be performed here
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        // back.setBorder(emptyBorder);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        // Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        //ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setLayout(null);
        setBounds(300, 200, 980, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '" + id + "'";
             
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {

                    tfroom.setText(rs.getString("room"));

                }
              
                                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = "+tfroom.getText());
                                while(rs2.next()){
                                    tfavailable.setText(rs2.getString("availability")); 
                                    tfstatus.setText(rs2.getString("cleaning_status")); //cleaning_status
                                }
                            
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
           
                

                String number = ccustomer.getSelectedItem();
                String room = tfroom.getText(); //room_number;    
                String available = tfavailable.getText(); //name    
                String status = tfstatus.getText();
                
                    if (number.equals("") || available.equals("") || status.equals("") || room.equals("") )
         {
              JOptionPane.showMessageDialog(null,"Something is missing","Alert",JOptionPane.WARNING_MESSAGE); 
             return;
         }
                
                try{
                                    Conn c = new Conn();
                                    String str = "update room set cleaning_status = '"+tfstatus.getText()+"' where roomnumber = "+tfroom.getText();
                                    c.s.executeUpdate(str);
                                    JOptionPane.showMessageDialog(null, "Update Sucessful");
                                    
                                    new Reception().setVisible(true);
                                    setVisible(false);
				}catch (Exception ee){
					ee.printStackTrace();
				}

        }      
        else if (ae.getSource() == back) {
            new Reception().setVisible(true);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateRoom();

    }

}
