
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard  extends JFrame implements ActionListener
{
    Dashboard() 
        {
            
             JFrame frame = new JFrame("Dashboard");
            frame.setBounds(-10, 0, 1950, 1000);
            frame.setLayout(null);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
            Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2); 
	    JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 1950, 1000); 
            frame.add(image);
            
            JLabel text= new JLabel(" THE XYZ GROUP WELCOMES YOU ");
	    text.setForeground(Color.white);
            text.setFont(new Font("Tahoma", Font.PLAIN, 46));
	    text.setBounds(400, 70, 1000, 50);
	    image.add(text); //text added in image
            
              JMenuBar mb = new JMenuBar();
             mb.setBounds(0,  0, 1250, 30);
             image.add(mb);
             
             JMenuBar mb1 = new JMenuBar();
             mb1.setBounds(1250,  0, 200, 30);
             image.add(mb1);
             
             JMenu hotel = new JMenu("HOTEL MANAGEMENT");
             hotel.setForeground(Color.black);
	     mb.add(hotel);
             
             JMenu admin = new JMenu("Admin");
             admin.setForeground(Color.black);
	     mb.add(admin);
             
             JMenu user = new JMenu("User-Admin");
             user.setForeground(Color.black);
	     mb1.add(user);
             
             JMenuItem reception = new JMenuItem("Reception");
             reception.addActionListener(this);
             reception.setForeground(Color.black);
	     hotel.add(reception);
             
             JMenuItem addemployee = new JMenuItem("Add Employee");
             addemployee.addActionListener(this);
             addemployee.setForeground(Color.BLUE);
	     admin.add(addemployee);
             
             JMenuItem addroom = new JMenuItem("Add Room");
             addroom.addActionListener(this);
             addroom.setForeground(Color.BLUE);
	     admin.add(addroom);
             
             JMenuItem adddrivers = new JMenuItem("Add Driver");
             adddrivers.addActionListener(this);
             adddrivers.setForeground(Color.BLUE);
	     admin.add(adddrivers);
             
             JMenuItem addfoood = new JMenuItem("Add Food");
             addfoood.addActionListener(this);
             addfoood.setForeground(Color.BLUE);
	     admin.add(addfoood);
             
             JMenuItem logout = new JMenuItem("Logout");
             logout.addActionListener(this);
             logout.setForeground(Color.black);
	     user.add(logout);
             
      
            
            frame.setVisible(true);
        }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Add Employee"))
        {
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("Add Room"))
        {
            new AddRooms();
        }
         else if(ae.getActionCommand().equals("Add Driver"))
        {
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("Reception"))
        {
            new Reception();
        }
         else if(ae.getActionCommand().equals("Add Food"))
       {
           new AddFood();
       }
        else if(ae.getActionCommand().equals("Logout"))
        {
           setVisible(false);
           System.exit(0);
        }
        
        
        
    }
    public static void main(String[] args) 
    {
        new Dashboard();
    }

}
