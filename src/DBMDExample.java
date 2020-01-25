
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;


public class DBMDExample {

    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        DatabaseMetaData dbmd=con.getMetaData();
        String dbpName=dbmd.getDatabaseProductName();
        String dbpVer=dbmd.getDatabaseProductVersion();
        String drvName=dbmd.getDriverName();
        String drvVer=dbmd.getDriverVersion();
        int jdbcVer=dbmd.getJDBCMajorVersion();
        ResultSet rs=dbmd.getTables(null, null, null, null);
        System.out.println(dbpName);
        System.out.println(dbpVer);
        System.out.println(drvName);
        System.out.println(drvVer);
        System.out.println(jdbcVer);
        System.out.println("Database Elements : ");
        while(rs.next()){
            System.out.println(rs.getString("TABLE_NAME")+","+rs.getString("TABLE_TYPE"));
        }
        
        con.close();
    }
}
