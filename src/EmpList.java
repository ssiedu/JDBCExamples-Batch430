
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpList {

    public static void main(String[] args) throws Exception {
        String sql = "SELECT * FROM emp WHERE sal>=30000";
        Connection con = Utility.connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            String s1 = rs.getString("eno");
            String s2 = rs.getString("ename");
            int s3 = rs.getInt("sal");
            int bonus=s3*10/100;
            System.out.println(s1 + "," + s2 + "," + s3+","+bonus);

        }

    }
}
/*
    Ctrl+Shift+I    (Fixing Import Statements)
 */
