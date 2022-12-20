package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;

    JButton back, submit;

    JComboBox bedtype;

    JCheckBox available , cleaned , all;

    SearchRoom() {
        
         JFrame frame = new JFrame("Search Rooms");
        Border emptyBorder = BorderFactory.createEmptyBorder();
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Search for Rooms");
        text.setFont(new Font("Railway", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
         frame.add(text);

        JLabel lblbed = new JLabel("Room Number");
        lblbed.setBounds(50, 100, 100, 20);
         frame.add(lblbed);

        bedtype = new JComboBox(new String[]{"Single Bed", "Double Bed "});
        bedtype.setBounds(150, 100, 150, 20);
        bedtype.setBackground(Color.white);
         frame.add(bedtype);

        available = new JCheckBox("Only Display Available");
        available.setBounds(350, 100, 150, 20);
        available.setBackground(Color.white);
         frame.add(available); 
         
         cleaned = new JCheckBox("Only Display Cleaned");
        cleaned.setBounds(550, 100, 150, 20);
        cleaned.setBackground(Color.white);
         frame.add(cleaned); 
         
        
        all = new JCheckBox("All Rooms");
        all.setBounds(750, 100, 150, 20);
        all.setBackground(Color.white);
        frame.add(all);
        
         
           
         

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
         frame.add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270, 160, 100, 20);
         frame.add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(450, 160, 100, 20);
         frame.add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(670, 160, 100, 20);
         frame.add(l4);
         
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870, 160, 100, 20);
         frame.add(l5);

        table = new JTable();
        table.setBounds(50, 200, 1000, 300);
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
                
                String r = (String) bedtype.getSelectedItem();
                String query1="select * from room where bed_type = '"+bedtype.getSelectedItem()+"'";
                String query2="select * from room where availability ='Available' AND bed_type = '"+bedtype.getSelectedItem()+"'" ;
                String query3="select * from room where cleaning_status ='Cleaned' AND bed_type = '"+bedtype.getSelectedItem()+"' " ;
                String query4="select * from room ";
                Conn conn = new Conn();
                 ResultSet rs = null;
                 
                if(available.isSelected())
                {
                 rs = conn.s.executeQuery(query2);
                }
                else if(cleaned.isSelected())
                {
                 rs = conn.s.executeQuery(query3);
                }
                else if (all.isSelected())
                {
                    rs = conn.s.executeQuery(query4);
                }
                else
                {
                    rs = conn.s.executeQuery(query1);  
                }
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
        new SearchRoom();
    }
}
