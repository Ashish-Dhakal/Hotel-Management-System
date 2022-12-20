package hotel.management.system;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import javax.swing.border.Border;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel text, lblid, lblnumber, lblname, lblgender, lblcountry, lblroom, lbltime, lbldeposite,  checkintimee;

    JComboBox comboid;

    JTextField tfnumber, tfname, tfcountry, tfdeposite;

    JRadioButton rbmale, rbfemale;

    Choice croom;

    JButton add, back;

    AddCustomer() {
        
        JFrame frame = new JFrame("New Customer Form");

        Border emptyBorder = BorderFactory.createEmptyBorder();
        getContentPane().setBackground(Color.white);
        frame.setLayout(null);

        text = new JLabel("NEW CUSTOMER FORM");
        text.setFont(new Font("Railway", Font.PLAIN, 20));
        text.setBounds(100, 20, 300, 30);
        
         frame.add(text);

        lblid = new JLabel("ID ");
        lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        lblid.setBounds(35, 80, 100, 20);
         frame.add(lblid);

        comboid = new JComboBox(new String[]{"Passport", "Citizenship", "Voter Id", "Driving license"});
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
         frame.add(comboid);

        lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Railway", Font.PLAIN, 20));
        lblnumber.setBounds(35, 120, 100, 20);
         frame.add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
         frame.add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setFont(new Font("Railway", Font.PLAIN, 20));
        lblname.setBounds(35, 160, 100, 20);
         frame.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
         frame.add(tfname);

        lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Railway", Font.PLAIN, 20));
        lblgender.setBounds(35, 200, 100, 20);
         frame.add(lblgender);

        //for gender button
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 200, 60, 25);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setForeground(Color.black);
        rbmale.setBackground(Color.white);
         frame.add(rbmale);

        rbfemale = new JRadioButton("Female",true);
        rbfemale.setBounds(270, 200, 100, 25);
        rbfemale.setForeground(Color.black);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.white);
         frame.add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        lblcountry = new JLabel("Country");
        lblcountry.setFont(new Font("Railway", Font.PLAIN, 20));
        lblcountry.setBounds(35, 240, 100, 20);
         frame.add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
         frame.add(tfcountry);

        lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Railway", Font.PLAIN, 20));
        lblroom.setBounds(35, 280, 150, 25);
         frame.add(lblroom);

        croom = new Choice();
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room where availability ='Available'");
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(200, 280, 150, 25);
         frame.add(croom);

        lbltime = new JLabel("Check in Time");
        lbltime.setFont(new Font("Railway", Font.PLAIN, 20));
        lbltime.setBounds(35, 320, 150, 25);
         frame.add(lbltime);

        Date date = new Date();
      
      // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      // String strn = formatter.format(date);
       checkintimee = new JLabel(""+date);
      // checkintimee.setFont(new Font("Railway", Font.PLAIN, 14));  
       checkintimee.setBounds(200, 320, 250, 30);
        frame.add(checkintimee);
        

        lbldeposite = new JLabel("Deposite");
        lbldeposite.setFont(new Font("Railway", Font.PLAIN, 20));
        lbldeposite.setBounds(35, 360, 100, 20);
         frame.add(lbldeposite);

        tfdeposite = new JTextField();
        tfdeposite.setBounds(200, 360, 150, 25);
         frame.add(tfdeposite);

        add = new JButton("ADD");
        add.setBounds(200, 430, 150, 30);
        add.addActionListener(this); //action to be performed here
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBorder(emptyBorder);
         frame.add(add);

        back = new JButton("BACK");
        back.setBounds(390, 430, 150, 30);
        back.addActionListener(this); //action to be performed here
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBorder(emptyBorder);
         frame.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/client.png"));
        Image i3 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(420, 10, 400, 400);
         frame.add(l1);

         frame.setBounds(250, 100, 850, 550);
         frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        
          
        if (ae.getSource() == add) {
           String document  = (String) comboid.getSelectedItem();
           String number  = tfnumber.getText();
           String name  = tfname.getText();
           String gender  = null;
           
           
           
                 if(rbmale.isSelected())
                {
                    gender="Male";
                    
                }
                 else if(rbfemale.isSelected())
                {
                    gender="Female";
                }
                 else if (name.equals("")|| document.equals("") )
         {
              JOptionPane.showMessageDialog(null,"Something is missing","Alert",JOptionPane.WARNING_MESSAGE); 
             return;
         }
             
             
            String country  = tfcountry.getText();
            String room  = croom.getSelectedItem();
            String checkintimeee = checkintimee.getText() ;
            String deposit  = tfdeposite.getText();

            try {
               

                String query1 = "INSERT INTO customer values('" + document + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + checkintimeee + "','" + deposit + "')";
                String query2 = "UPDATE room set availability = 'Occupied' where roomnumber = '" + room + "' ";
                String query3 = " UPDATE room set cleaning_status = 'Dirty' where roomnumber = '" + room + "' " ;
                Conn conn = new Conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Customer  Successfully Added");

                setVisible(false);
                new Reception().setVisible(true);
            } catch (Exception e) {
                
                e.printStackTrace();

            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();

        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
