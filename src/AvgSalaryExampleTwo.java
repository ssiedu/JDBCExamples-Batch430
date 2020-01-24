
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AvgSalaryExampleTwo {
    public static void main(String[] args) throws Exception {
        String sql="SELECT AVG(sal) from EMP";
        Connection con=Utility.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        rs.next();
        System.out.println("Avg Salary : "+rs.getInt(1));
        con.close();
    }
}
