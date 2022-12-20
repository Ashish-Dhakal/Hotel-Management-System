package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {

    JTable table;

    JButton back;

    
    Department() {
        Border emptyBorder = BorderFactory.createEmptyBorder();
        getContentPane().setBackground(Color.WHITE);

         JFrame frame = new JFrame();
         frame.setSize(300, 300); ;
        

        JLabel l1 = new JLabel("Department");
        l1.setBounds(30, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(280, 10, 100, 20);
        add(l2);


        
        

        table = new JTable();
        table.setBounds(20, 40, 500, 400);
        add(table);
        table.setOpaque(false);
        table.setShowGrid(false);
        table.setBackground(new Color(0, 0, 0, 0F));


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
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
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 600);
        add(image);

        setBounds(150, 90, 600, 600);
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
        new Department();
    }
}
