
import java.sql.*;

public class SalaryIncrement {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data430", "root", "root");
        String sql="UPDATE EMP SET sal=sal+1000 where eno=111";
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate(sql);
        System.out.println(n+" rows modified");
        con.close();
    }
}
