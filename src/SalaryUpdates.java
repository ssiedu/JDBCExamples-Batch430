
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class SalaryUpdates {

    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ECode : ");
        int x=sc.nextInt();
        System.out.println("Enter Increment Amount : ");
        int y=sc.nextInt();
        Connection con=Utility.connect();
        //user will provide eno and increment amount
        //this program will increase the salary of given emp
        //with given amount
        String sql="update emp set sal=sal+? where eno=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, y);
        ps.setInt(2, x);
        int n=ps.executeUpdate();
        System.out.println(n+" row updated ");
        
        con.close();
        
    }
}
