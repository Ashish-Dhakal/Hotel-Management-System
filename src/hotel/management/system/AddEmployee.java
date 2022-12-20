
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;



public class AddEmployee extends JFrame implements ActionListener 
{
    
    JTextField tfname ,tfage ,tfemail , tfsalary ,tfphone ,tfcitizenship ;
    JLabel lblname, lblage, lblemail ,lblsalary , lblphone, lblgender ,lbljob ,lblcitizenship;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox  cbjob;
    AddEmployee()
    {
        setLayout(null);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        
        
        
        //for name text field
        lblname = new JLabel ("NAME:");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setForeground(Color.white);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        //for age field        
        lblage = new JLabel ("AGE:");
        lblage.setForeground(Color.white);
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        //for gender label
        lblgender = new JLabel ("GENDER:");
        lblgender.setForeground(Color.white);
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
        
        
        //for gender button
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setForeground(Color.white);
        rbmale.setBackground(Color.black);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setForeground(Color.white);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.black);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        //for job 
        lbljob = new JLabel ("JOB:");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setForeground(Color.white);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);
        
        String str[]={"Manager","Accountant","Chefs","Font Desk Clerk","House Keeping","Waiter/Waitress","Kitchen Staff","Porters"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150,30);
        cbjob.setBackground(Color.white);
        add(cbjob);
        
        
        lblsalary = new JLabel ("SALARY:");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setForeground(Color.white);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
        
        
        lblemail = new JLabel ("EMAIL:");
        lblemail.setBounds(60, 280, 120, 30);
        lblemail.setForeground(Color.white);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 280, 150, 30);
        add(tfemail);
        
        
        lblphone = new JLabel ("PHONE NO:");
        lblphone.setBounds(60, 330, 120, 30);
        lblphone.setForeground(Color.white);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 330, 150, 30);
        add(tfphone);
        
        lblcitizenship = new JLabel ("Citizenship:");
        lblcitizenship.setBounds(60, 380, 120, 30);
        lblcitizenship.setForeground(Color.white);
        lblcitizenship.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcitizenship);
        
        tfcitizenship = new JTextField();
        tfcitizenship.setBounds(200, 380, 150, 30);
        add(tfcitizenship);
        
        
        
        submit = new JButton ("Submit");
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this); //action to be performed here
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBorder(emptyBorder);
        add(submit);
        
        
        
        
	
        
            
            
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/employee.jpg"));
            Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
            ImageIcon i3 =  new ImageIcon(i2);
            JLabel image =new JLabel(i3);
            add(image);
            image.setBounds(380, 20,450, 450);
                

        
        
        getContentPane().setBackground(Color.black); 
      
        setBounds(300, 100, 850, 540);
        setVisible(true);
        
            }
    
     public void actionPerformed(ActionEvent ae)
     {
         String name = tfname.getText();
         String age = tfage.getText();
         String email = tfemail.getText();
         String phone = tfphone.getText();
         String salary =tfsalary.getText();
         String citizenship =tfcitizenship.getText();
         
        
         
         
         
         String gender =null;
       
         
         
           if (name.equals("")|| age.equals("") || email.equals("") || phone.equals("") || salary.equals("") || citizenship.equals(""))
         {
              JOptionPane.showMessageDialog(null,"Something is missing","Alert",JOptionPane.WARNING_MESSAGE); 
             return;
         }
         
           
         if( (email.length()<4) ||!email.contains("@gmail.com") )
         {
             JOptionPane.showMessageDialog(null,"invalid Email","Alert",JOptionPane.WARNING_MESSAGE); 
             return ;
         }
         
         
         
  
         
      
        
         if(rbmale.isSelected())
         {
             gender="Male";
             
         }
         else if(rbfemale.isSelected())
         {
             gender ="Female";
         }
         
         String job =(String) cbjob.getSelectedItem();
         try
         {
             Conn c = new Conn();
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+citizenship+"','"+email+"')";
            
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee Added sucessfully");
            setVisible(false);
             
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
         
          
         
         
     }
    
    public static void main(String[] arg)
    {
        new AddEmployee();
    }
}
