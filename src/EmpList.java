
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpList {

    public static void main(String[] args) throws Exception {
        String sql = "SELECT eno,ename,sal,sal*12 as annual FROM emp";
        Connection con = Utility.connect();
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            String s1 = rs.getString("eno");
            String s2 = rs.getString("ename");
            String s3 = rs.getString("sal");
            String s4 = rs.getString("annual");
            System.out.println(s1+","+s2+","+s3+","+s4);
            
            //int bonus=s3*10/100;
            //System.out.println(s1 + "," + s2 + "," + s3+","+bonus);

        }

    }
}
/*
    Ctrl+Shift+I    (Fixing Import Statements)
 */
