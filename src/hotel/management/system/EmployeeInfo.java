package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import java.sql.*;
import javax.swing.table.*;
import net.proteanit.sql.*;

import javax.swing.table.TableColumnModel;

public class EmployeeInfo extends JFrame implements ActionListener {

    JTable table;

    JButton back, display;
    JCheckBox manager;

    EmployeeInfo() {
        
         JFrame frame = new JFrame("Employee Info");
        Border emptyBorder = BorderFactory.createEmptyBorder();
        getContentPane().setBackground(Color.WHITE);

        manager = new JCheckBox("Only Display Manager");
        manager.setBounds(350, 100, 150, 20);
        manager.setBackground(Color.white);
        frame.add(manager);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(10, 10, 100, 20);
        frame.add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(140, 10, 100, 20);
        frame.add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(270, 10, 100, 20);
        frame.add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(370, 10, 100, 20);
        frame.add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(480, 10, 100, 20);
        frame.add(l5);

        JLabel l6 = new JLabel("phone");
        l6.setBounds(590, 10, 100, 20);
        frame.add(l6);

        JLabel l7 = new JLabel("Citizen");
        l7.setBounds(700, 10, 100, 20);
        frame.add(l7);

        JLabel l8 = new JLabel("Email");
        l8.setBounds(830, 10, 100, 20);
        frame.add(l8);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        table.setOpaque(false);
        table.setShowGrid(false);
        table.setBackground(new Color(0, 0, 0, 0F));
        frame.add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBounds(420, 500, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        frame.add(back);
        back.setBorder(emptyBorder);
        back.addActionListener(this);

        display = new JButton("Display");
        display.setBounds(200, 500, 120, 30);
        display.setBackground(Color.black);
        display.setForeground(Color.white);
        frame.add(display);
        display.setBorder(emptyBorder);
        display.addActionListener(this);

        frame.setLayout(null);
        frame.setBounds(300, 200, 1000, 600);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        } else if (ae.getSource() == display) {
            try {

                String query3 = "select * from employee where job ='Manager' ";

                Conn conn = new Conn();
                ResultSet rs = null;

                if (manager.isSelected()) {
                    rs = conn.s.executeQuery(query3);
                }

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new EmployeeInfo();
    }
}
