import java.io.*;
import java.sql.*;

class delete
{
public static void main(String args[])
{
try{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter SID");
String SID=br.readLine();
Class.forName("oracle.jdbc.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
Statement stmt=con.createStatement();
String q1="delete from student where SID='"+SID+"'";
int t=stmt.executeUpdate(q1);
if(t>0)
System.out.println("Deleted Successfully");
con.close();
}
catch(Exception e)
{
}
}
}