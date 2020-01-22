
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataReading {
    public static void main(String[] args) throws Exception {
        String sql="SELECT * FROM emp";
        Connection con=Utility.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            System.out.println(s1+","+s2+","+s3);
        }
        System.out.println("_______________________________");
        //rs.first(); //afterLast->first
        rs.beforeFirst();
        while(rs.next()){   //first->second
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            System.out.println(s1+","+s2+","+s3);
        }
        System.out.println("_______________________________");
        rs.absolute(2); //
        System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
        
        //rs.first();
        //System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
        
        /*
        while(rs.previous()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            System.out.println(s1+","+s2+","+s3);
        }
        */
        
        
        
        
    }
}
