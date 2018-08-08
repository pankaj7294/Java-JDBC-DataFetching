/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstjdbcproject;
import java.sql.*;
/**
 *
 * @author pankajbharati
 */
public class FirstJDBCProject {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    public FirstJDBCProject()
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("JDBC:mysql://localhost:3306/MYJDBC","root","pass123");
           st=con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e.getMessage());
        }
        
    }
    public void getData()
        {
            try
            {
             String query="select * from login";  
             rs=st.executeQuery(query);
             System.out.println("Record from Database");
             while(rs.next())
             {
                 String id=rs.getString("id");
                 String name=rs.getString("name");
                 
                 String password=rs.getString("password");
                 System.out.println("ID: "+id+"  NAME :    "+name+"    PASSWORD :  "+password);
             }
            }
            catch(Exception e)
                    {
                        System.out.println("Exception :   "+e.getMessage());
                    }
        }
        
    public static void main(String[] args) {
        // TODO code application logic here
        
         FirstJDBCProject c=new FirstJDBCProject();
         c.getData();
    }
    
}
