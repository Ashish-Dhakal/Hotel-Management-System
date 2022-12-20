
package hotel.management.system;
import javax.swing.*; //jbutton jlabel
import java.awt.*; //GUI interface
import java.awt.event.*; //event handling
import javax.swing.border.Border;

public class HotelManagementSystem extends JFrame implements ActionListener{ 
    
    HotelManagementSystem(){
        JFrame frame = new JFrame("Hotel Management System");
         //   setSize(0,100,1366, 565); 
            frame.setBounds(70,35,1200,675);
          //  setLocation(0 ,0);
           Border emptyBorder = BorderFactory.createEmptyBorder();
            
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
            JLabel image =new JLabel(i1);
             image.setBounds(400, 50, 1200, 675);
            frame.add(image);
            
         //    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        // Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        //ImageIcon i2 = new ImageIcon(i3);
    //    JLabel image = new JLabel(i1);
    //    image.setBounds(400, 50, 1200, 675);
     //   add(image);
         
   /*    JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
            text.setBounds(20,430,1000,90);
            text.setFont(new Font("serif",Font.PLAIN,50));
            text.setForeground(Color.white);
            image.add(text);
     */       
        JButton next = new JButton ("Next");
            next.setBounds(950,580,150,50);
            next.addActionListener(this); //action to be performed here
            next.setFont(new Font("Railway",Font.BOLD,25));
            next.setForeground(Color.white);
            next.setBorder(emptyBorder);
            next.setOpaque(false);
            next.setContentAreaFilled(false);
            next.setBorderPainted(false);
            
            image.add(next);
            
            
      
       
        frame.setVisible(true);
        
      /*  while(true){
                    text.setVisible(false); 
                        try
                        {
                            Thread.sleep(500); 
                        }
                        catch(Exception e)
                        { 
                            e.printStackTrace();
                        }
                        
                    text.setVisible(true);
                        try
                        {
                        Thread.sleep(500);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                }
        
        */
        
    
    }
    
     public void actionPerformed(ActionEvent ae){
                new Login();setVisible(true); //open the login portion
                this.setVisible(false); //close the intro pannel
     }

  
    public static void main(String[] args) {
       new HotelManagementSystem();
       
    }
    
}
