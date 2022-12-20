package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {

    JTable table;

    JButton back;

    ManagerInfo() {
        Border emptyBorder = BorderFactory.createEmptyBorder();
        getContentPane().setBackground(Color.WHITE);

        

        JLabel l1 = new JLabel("Name");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(140, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(270, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(370, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(480, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Citizenship");
        l6.setBounds(590, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Phone");
        l7.setBounds(700, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Email");
        l8.setBounds(830, 10, 100, 20);
        add(l8);
        
        
        

        table = new JTable();
        table.setBounds(20, 40, 1000, 400);
        add(table);
        table.setOpaque(false);
        table.setShowGrid(false);
        table.setBackground(new Color(0, 0, 0, 0F));


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job = 'Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBounds(200, 500, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.setBorder(emptyBorder);
        back.addActionListener(this);
        
        setLayout(null);
 

        setBounds(150, 90, 1050, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {if (ae.getSource() == back) 
    {
                setVisible(false);
                new Reception();
    }
        
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}
