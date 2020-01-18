
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DataEntry {
    public static void main(String[] args){
        
        try{
        //step-1 (Driver Loading)
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Successfully Loaded");
            
        //step-2 (Connectional Establishment)
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data430", "root", "root");
            System.out.println("Connected Successfully");
            
        //step-3 (Define a SQL to perform CRUD operation)
        String sql="insert into emp values(115,'eee',50000)";
        
        //step-4 (Create a Statement Object to send SQL to DB)
        Statement stmt=con.createStatement();
        
        //step-5 (Send the SQL to DB)
        int n=stmt.executeUpdate(sql);
        System.out.println(n+" row addded ");
        
        //step-6 (Close the Connection)
        con.close();
        
        
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
       
    
    }
}
