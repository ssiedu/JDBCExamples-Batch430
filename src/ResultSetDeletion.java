
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetDeletion {
  public static void main(String args[]) throws Exception {
        String sql = "SELECT * FROM emp";
        Connection con = Utility.connect();
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3));
        }
        System.out.println("______________________________");
        Scanner sc = new Scanner(System.in);
        System.out.println("Do You Wish To Delete Record : press 1 to yes");
        int ch = sc.nextInt();
        if (ch == 1) {
            System.out.println("Enter Row No : ");
            int rno = sc.nextInt();
            //step-1 move the cursor to the row to be deleted
            rs.absolute(rno);
            //step-2 call deleteRow method on resultSet obj
            rs.deleteRow();
            System.out.println("ROW DELETED : ");
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3));

            }
            System.out.println("______________________________");
        } else {
            System.out.println("You Dont Want To Delete");
        }

        con.close();
    }    
}
