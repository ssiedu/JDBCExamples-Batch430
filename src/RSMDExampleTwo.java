
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class RSMDExampleTwo {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Table Name : ");
        String table=sc.next();
        
        String sql="SELECT * FROM "+table;
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
