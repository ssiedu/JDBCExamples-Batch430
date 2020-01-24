
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class ResultSetMutlipleTableExample {

    public static void main(String[] args) throws Exception {
        String sql="SELECT rno,sname,btime,subject,fname FROM students,batches,faculties WHERE students.bcode=batches.bcode AND batches.fcode=faculties.fcode";
        Connection con=Utility.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getString(5));
        }
        con.close();
    }
}
