
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetInsert {

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
        System.out.println("Do You Wish To Add More Record : press 1 to yes");
        int ch = sc.nextInt();
        if (ch == 1) {
            System.out.println("Enter Eno : ");
            int eno = sc.nextInt();
            System.out.println("Enter Ename : ");
            String name = sc.next();
            System.out.println("Enter Salary : ");
            int sal = sc.nextInt();
            System.out.println("Now Inserting.... ");
            //step-1 (creating a row)
            rs.moveToInsertRow();
            //step-2 (update the cols for new row)
            rs.updateInt(1, eno);
            rs.updateString(2, name);
            rs.updateInt(3, sal);
            //step-3 (save the new row to DB)
            rs.insertRow();
            System.out.println("ROW ADDED : ");
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3));

            }
            System.out.println("______________________________");
        } else {
            System.out.println("You Dont Want To Add");
        }

        con.close();
    }
}
