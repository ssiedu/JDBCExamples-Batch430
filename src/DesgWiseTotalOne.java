
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DesgWiseTotalOne {
     public static void main(String[] args) throws Exception {
        String sql="SELECT * from EMP";
        Connection con=Utility.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        int tot1=0, tot2=0;
        while(rs.next()){
            String dg=rs.getString(4);
            switch(dg){
                case "Clerk":
                    tot1=tot1+rs.getInt(3);
                break;
                case "Manager":
                    tot2=tot2+rs.getInt(3);
                break;
            }
        }
        System.out.println("Clerk Total : "+tot1);
        System.out.println("Manager Total : "+tot2);
        con.close();
    }
}
