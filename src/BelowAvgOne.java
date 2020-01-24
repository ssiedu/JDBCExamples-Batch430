
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BelowAvgOne {
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
        int avg=sum/n;
        //System.out.println("Avg Salary : "+(sum/n));
        rs.beforeFirst();
        while(rs.next()){
            int sal=rs.getInt("sal");
            if(sal<avg){
                System.out.println(rs.getString("ename")+","+rs.getString("sal"));
            }
                
        }
        
        
        con.close();
    }    
}
