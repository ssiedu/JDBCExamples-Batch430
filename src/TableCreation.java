
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableCreation {
 public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data430", "root", "root");
        String sql="CREATE TABLE DUMMY (COL1 CHAR, COL2 CHAR)";
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate(sql);
        System.out.println(n);
        con.close();
    }    
}
