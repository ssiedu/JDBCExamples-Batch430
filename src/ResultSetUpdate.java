
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetUpdate {
    public static void main(String args[]) throws Exception {
        String sql="SELECT * FROM emp";
        Connection con=Utility.connect();
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
        }
        System.out.println("______________________________");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Row No : ");
        int row=sc.nextInt();
        System.out.println("Enter New Salary : ");
        int newsal=sc.nextInt();
        //step-1 (moving the cursor to row to be updated)
        rs.absolute(row);
        //step-2 (call updatter method to change col value)
        rs.updateInt(3, newsal);
        //step-3 (save the changes to underlying database)
        rs.updateRow();
        System.out.println("SALARY CHANGED : ");
        System.out.println("New-Data : ");
        rs.beforeFirst();
        while(rs.next()){
            System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
        }
        
        con.close();
    }
}
