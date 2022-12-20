package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {

    JTable table;

    JButton back;

    Room() {
        
        JFrame frame = new JFrame("Rooms");
        Border emptyBorder = BorderFactory.createEmptyBorder();
        getContentPane().setBackground(Color.WHITE);

        

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 10, 100, 20);
        frame.add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120, 10, 100, 20);
        frame.add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(230, 10, 100, 20);
        frame.add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(330, 10, 100, 20);
        frame.add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(410, 10, 100, 20);
        frame.add(l5);
        
        

        table = new JTable();
        table.setBounds(20, 40, 500, 400);
        frame.add(table);
        table.setOpaque(false);
        table.setShowGrid(false);
        table.setBackground(new Color(0, 0, 0, 0F));


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBounds(200, 300, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        frame.add(back);
        back.setBorder(emptyBorder);
        back.addActionListener(this);
        
        frame.setLayout(null);
 

        frame.setBounds(350, 90, 550, 400);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {if (ae.getSource() == back) 
    {
                setVisible(false);
                new Reception();
    }
        
    }

    public static void main(String[] args) {
        new Room();
    }
}
