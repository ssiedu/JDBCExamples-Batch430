
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BelowAvgTwo {
public static void main(String[] args) throws Exception {
        String sql="SELECT * from EMP WHERE sal<= (SELECT AVG(sal) FROM EMP)";
        Connection con=Utility.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
                System.out.println(rs.getString("ename")+","+rs.getString("sal"));
        }
        
        
    }    
}
