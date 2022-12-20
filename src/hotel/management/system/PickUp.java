package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import java.sql.*;
import net.proteanit.sql.*;

public class PickUp extends JFrame implements ActionListener {

    JTable table;

    JButton back, submit;

    JComboBox bedtype;

    JCheckBox available , cleaned , all;
    
    Choice ccompany ;

    PickUp() {
        
         JFrame frame = new JFrame("Pickup ");
        Border emptyBorder = BorderFactory.createEmptyBorder();
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Railway", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
         frame.add(text);

        JLabel lblbed = new JLabel("Car Company");
        lblbed.setBounds(50, 100, 100, 20);
         frame.add(lblbed);
         
         ccompany = new Choice();
        // lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        ccompany.setBounds(150, 100, 150, 20);
        frame.add(ccompany);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            while (rs.next()) {

                ccompany.add(rs.getString("company"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       

        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 160, 100, 20);
         frame.add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(210, 160, 100, 20);
         frame.add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(380, 160, 100, 20);
         frame.add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(530, 160, 100, 20);
         frame.add(l4);
         
         JLabel l5 = new JLabel("Location");
        l5.setBounds(890, 160, 100, 20);
         frame.add(l5);
         
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(700, 160, 100, 20);
         frame.add(l6);

        table = new JTable();
        table.setBounds(50, 200, 1000, 300);
         frame.add(table);
        table.setOpaque(false);
        table.setShowGrid(false);
        table.setBackground(new Color(0, 0, 0, 0F));

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        submit = new JButton("SUBMIT");
        submit.setBounds(200, 500, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
         frame.add(submit);
        submit.setBorder(emptyBorder);
        submit.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(330, 500, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
         frame.add(back);
        back.setBorder(emptyBorder);
        back.addActionListener(this);

         frame.setLayout(null);
         frame.setBounds(150, 90, 1050, 600);
         frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                
               // String r = (String) bedtype.getSelectedItem();
                String query1="select * from driver where company = '"+ccompany.getSelectedItem()+"'";
              //  String query2="select * from room where availability ='Available' AND bed_type = '"+bedtype.getSelectedItem()+"'" ;
               // String query3="select * from room where cleaning_status ='Cleaned' AND bed_type = '"+bedtype.getSelectedItem()+"' " ;
               // String query4="select * from room ";
                Conn conn = new Conn();
                 ResultSet rs = null;
                 rs = conn.s.executeQuery(query1);
             
                 table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();

        }

    }

    public static void main(String[] args) {
        new PickUp();
    }
}
