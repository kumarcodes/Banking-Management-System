import java.io.*;
import java.sql.*;

class fetch
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
String q1="select * from student where SID='"+SID+"'";
ResultSet rs=stmt.executeQuery(q1);
if(rs.next())
{
System.out.println("SID="+rs.getString(1));
System.out.println("NAME="+rs.getString(2));
System.out.println("COLLEGE="+rs.getString(3));
System.out.println("PHONE="+rs.getString(4));
}
else
System.out.println("No Data Found");
con.close();
}
catch(Exception e)
{
}
}
}