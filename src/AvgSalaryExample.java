
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class AvgSalaryExample {
    public static void main(String[] args) throws Exception {
        String sql="SELECT * from EMP";
        Connection con=Utility.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        int n=0;
        int sum=0;
        while(rs.next()){
            sum=sum+rs.getInt("sal");
            n++;
        }
        System.out.println("Avg Salary : "+(sum/n));
        con.close();
    }
}
