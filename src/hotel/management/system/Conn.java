//5 step to connect the JDBC Connectivity (Java Database Connectivity) 
//1.Register the driver class (using...librery...com.mysql.jdbc...Driver)
//2.Creating the connection
//3.Creating statement



package hotel.management.system;

import java.sql.*; 

public class Conn
{
    Connection c;    //step2
    Statement s; //to exicute sql query
    Conn()
    {
        try    //try is used  because mysql is external entity which can cause runtime errror
            {  
                Class.forName("com.mysql.jdbc.Driver");  //connectiong thr driver
                c =DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","");  
                s=c.createStatement();  
            }
        catch(Exception e)
            {
            e.printStackTrace();
            } 
    }
}
