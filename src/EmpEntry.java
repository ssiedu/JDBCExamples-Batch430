import java.sql.*;
import java.util.Scanner;
public class EmpEntry {
    public static void main(String[] args) throws Exception {
        Connection con=Utility.connect();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Eno : ");
        int x=sc.nextInt();
        System.out.println("Enter Ename : ");
        String y=sc.next();
        System.out.println("Enter Salary : ");
        int z=sc.nextInt();
        String sql="insert into emp values(?,?,?)";
        //to execute parameterized queries, we need PreparedStatement object.
        PreparedStatement ps=con.prepareStatement(sql);
        //we need to set the parameter values
        ps.setInt(1, x);
        ps.setString(2, y);
        ps.setInt(3, z);
        int n=ps.executeUpdate();
        System.out.println(n+" row added");
        con.close();
    }
}
