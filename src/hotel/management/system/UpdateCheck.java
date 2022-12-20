package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;

public class UpdateCheck extends JFrame implements ActionListener {

    JLabel text, lblid, lblroom, lblname, lblpaid, lblpending, lblcheckin, lbllroom;

    JTextField tfroom, tfname, tfpaid, tfpending, tfcheckin;

    Choice ccustomer;

    JButton back, update, check;

    UpdateCheck() {
        JFrame frame = new JFrame("Check bill");
        getContentPane().setBackground(Color.WHITE);

        text = new JLabel("Check pending amount");
        text.setFont(new Font("Railway", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
        frame.add(text);

        lblid = new JLabel("Customer Id");
        // lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        lblid.setBounds(30, 80, 100, 20);
        frame.add(lblid);

        ccustomer = new Choice();
        // lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        ccustomer.setBounds(200, 80, 150, 25);
        frame.add(ccustomer);

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
        lblroom.setBounds(30, 120, 100, 20);
        frame.add(lblroom);

        tfroom = new JTextField();
        // tfroom.setFont(new Font("Railway", Font.PLAIN, 20));
        tfroom.setBounds(200, 120, 150, 25);
        frame.add(tfroom);

        lblname = new JLabel("Name");
        // lblname.setFont(new Font("Railway", Font.PLAIN, 20));
        lblname.setBounds(30, 160, 100, 20);
        frame.add(lblname);

        tfname = new JTextField();
        // tfname.setFont(new Font("Railway", Font.PLAIN, 20));
        tfname.setBounds(200, 160, 150, 25);
        frame.add(tfname);

        lblcheckin = new JLabel("Checkin Time");
        // lblcheckin.setFont(new Font("Railway", Font.PLAIN, 20));
        lblcheckin.setBounds(30, 200, 100, 20);
        frame.add(lblcheckin);

        tfcheckin = new JTextField();
        // tfcheckin.setFont(new Font("Railway", Font.PLAIN, 20));
        tfcheckin.setBounds(200, 200, 150, 25);
        frame.add(tfcheckin);

        lblpaid = new JLabel("Amount Paid");
        // lblpaid.setFont(new Font("Railway", Font.PLAIN, 20));
        lblpaid.setBounds(30, 240, 150, 20);
        frame.add(lblpaid);

        tfpaid = new JTextField();
        // tfpaid.setFont(new Font("Railway", Font.PLAIN, 20));
        tfpaid.setBounds(200, 240, 150, 25);
        frame.add(tfpaid);

        lblpending = new JLabel("Pending Amount");
        // lblpending.setFont(new Font("Railway", Font.PLAIN, 20));
        lblpending.setBounds(30, 280, 100, 20);
        frame.add(lblpending);

        tfpending = new JTextField();
        // tfpending.setFont(new Font("Railway", Font.PLAIN, 20));
        tfpending.setBounds(200, 280, 150, 25);
        frame.add(tfpending);

        check = new JButton("CHECK");
        check.setBounds(30, 340, 100, 30);
        check.addActionListener(this); //action to be performed here
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        // back.setBorder(emptyBorder);
        frame.add(check);

        update = new JButton("UPDATE");
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this); //action to be performed here
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        // update.setBorder(emptyBorder);
        frame.add(update);

        back = new JButton("BACK");
        back.setBounds(270, 340, 100, 30);
        back.addActionListener(this); //action to be performed here
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        // back.setBorder(emptyBorder);
        frame.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));  // sheckout nine
        // Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        //ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        frame.add(image);

        frame.setLayout(null);
        frame.setBounds(300, 200, 980, 500);
        frame.setVisible(true);

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

                    tfname.setText(rs.getString("name"));

                    tfcheckin.setText(rs.getString("checkintime"));

                    tfpaid.setText(rs.getString("deposit"));

                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText("" + amountPaid);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            try {
                Conn c = new Conn();

                String s1 = ccustomer.getSelectedItem();
                String room = tfroom.getText(); //room_number;    
                String name = tfname.getText(); //name    

                String deposite = tfpaid.getText(); //deposit    
                
                      if (name.equals("") )
         {
              JOptionPane.showMessageDialog(null,"Something is missing","Alert",JOptionPane.WARNING_MESSAGE); 
             return;
         }

                c.s.executeUpdate("update customer set room = '" + room + "', name = '" + name + "', deposit = '" + deposite + "' where number = '" + s1 + "'");

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                new Reception().setVisible(false);
                setVisible(false);
            } catch (Exception ee) {
                System.out.println(ee);
            }
            

        }
        else if (ae.getSource() == back) {
            new Reception().setVisible(false);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateCheck();

    }

}
