
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class RSMDExample {
    public static void main(String[] args) throws Exception {
        String sql="SELECT * FROM emp";
        Connection con=Utility.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        ResultSetMetaData rsmd=rs.getMetaData();
        int n=rsmd.getColumnCount();
        System.out.println("________________________________________");
        for(int i=1; i<=n; i++){
            System.out.print(rsmd.getColumnName(i)+"\t");
        }
        System.out.println();
        System.out.println("________________________________________");
        while(rs.next()){
            for(int i=1; i<=n; i++){
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println();
        }
        System.out.println("________________________________________");
        con.close();
    }
}
