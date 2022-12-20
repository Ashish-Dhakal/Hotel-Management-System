package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;

    JButton back;

    CustomerInfo() {
        
        JFrame frame = new JFrame("Customer Information");
    
        Border emptyBorder = BorderFactory.createEmptyBorder();
        frame.getContentPane().setBackground(Color.WHITE);

        

        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10, 10, 100, 20);
        frame.add(l1);

        JLabel l2 = new JLabel("Number");
        l2.setBounds(140, 10, 100, 20);
        frame.add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(270, 10, 100, 20);
        frame.add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410, 10, 100, 20);
        frame.add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(535, 10, 100, 20);
        frame.add(l5);
        
        JLabel l6 = new JLabel("Room NO");
        l6.setBounds(660, 10, 100, 20);
        frame.add(l6);
        
        JLabel l7 = new JLabel("CheckinTime");
        l7.setBounds(800, 10, 100, 20);
        frame.add(l7);
        
        JLabel l8 = new JLabel("Deposite");
        l8.setBounds(890, 10, 100, 20);
        frame.add(l8);
        
        
        

        table = new JTable();
        table.setBounds(20, 40, 1000, 400);
        frame.add(table);
        table.setOpaque(false);
        //table.setShowGrid(false);
        table.setBackground(new Color(0, 0, 0, 0F));


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBounds(200, 500, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        frame.add(back);
        back.setBorder(emptyBorder);
        back.addActionListener(this);
        
        frame.setLayout(null);
 

        frame.setBounds(150, 90, 1050, 600);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {if (ae.getSource() == back) 
    {
                setVisible(false); new Reception();;
               //new Reception();
    }
        
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
