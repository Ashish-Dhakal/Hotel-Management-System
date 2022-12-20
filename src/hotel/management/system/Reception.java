package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;

public class Reception extends JFrame implements ActionListener {

    JButton newCustomer, room, department, allEmployee, customers, managerinfo, checkouts, update, roomStatus, pickup, searchRoom, logout;

    Reception() {
        JFrame frame = new JFrame("Reception");

        frame.getContentPane().setBackground(Color.black);
        frame.setBounds(250, 100, 1050, 580);
        Border emptyBorder = BorderFactory.createEmptyBorder();

        frame.setVisible(true);
        frame.setLayout(null);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.black);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        frame.add(newCustomer);

        newCustomer.setBorder(emptyBorder);

        room = new JButton("Rooms");
        room.setBounds(10, 70, 200, 30);
        room.setBackground(Color.black);
        room.setForeground(Color.white);
        frame.add(room);
        room.addActionListener(this);
        room.setBorder(emptyBorder);

    
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 110, 200, 30);
        searchRoom.setBackground(Color.black);
        searchRoom.setForeground(Color.white);
        searchRoom.addActionListener(this);
        frame.add(searchRoom);
        searchRoom.setBorder(emptyBorder);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(Color.black);
        allEmployee.setForeground(Color.white);
        allEmployee.addActionListener(this);
        frame.add(allEmployee);
        allEmployee.setBorder(emptyBorder);

        customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(Color.black);
        customers.setForeground(Color.white);
        customers.addActionListener(this);
        frame.add(customers);
        customers.setBorder(emptyBorder);

        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10, 230, 200, 30);
        managerinfo.setBackground(Color.black);
        managerinfo.setForeground(Color.white);
        frame.add(managerinfo);
        managerinfo.addActionListener(this);
        managerinfo.setBorder(emptyBorder);

        checkouts = new JButton("Checkouts");
        checkouts.setBounds(10, 270, 200, 30);
        checkouts.setBackground(Color.black);
        checkouts.setForeground(Color.white);
        checkouts.addActionListener(this);
        frame.add(checkouts);
        checkouts.setBorder(emptyBorder);

        update = new JButton("Check Bill");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(Color.black);
        update.addActionListener(this);
        update.setForeground(Color.white);
        frame.add(update);
        update.setBorder(emptyBorder);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.black);
        roomStatus.addActionListener(this);
        roomStatus.setForeground(Color.white);
        frame.add(roomStatus);
        roomStatus.setBorder(emptyBorder);  

        pickup = new JButton("Pick UP Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.black);
        pickup.addActionListener(this);
        pickup.setForeground(Color.white);
        frame.add(pickup);
        pickup.setBorder(emptyBorder);

        
        
        department = new JButton("Department");
        department.setBounds(10, 430, 200, 30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        frame.add(department);
        department.setBorder(emptyBorder);

        /*logout = new JButton("Logout");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        frame.add(logout);
        logout.setBorder(emptyBorder);*/

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addemployee.jpg"));
        //Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        //   ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i1);
        image.setBounds(210, 20, 800, 494);
        frame.add(image);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == room) {
            setVisible(false);
            new Room();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == allEmployee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == managerinfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == checkouts) {
            setVisible(false);
            new CheckOut();
        } else if (ae.getSource() == update) {
            setVisible(false);
              new UpdateCheck();
        } else if (ae.getSource() == roomStatus) {
            setVisible(false);
               new UpdateRoom();
        } else if (ae.getSource() == pickup) {
            setVisible(false);
            new PickUp();
        } else if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            //   new Logout();
        }
    }

    public static void main(String[] args) {
        new Reception();

    }

}
