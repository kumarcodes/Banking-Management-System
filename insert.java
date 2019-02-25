import java.io.*;
import java.sql.*;

class insert
{
public static void main(String args[])
{
try{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter SID");
String SID=br.readLine();
System.out.println("Enter Name");
String NAME=br.readLine();
System.out.println("Enter COLLEGE");
String COLLEGE=br.readLine();
System.out.println("Enter Phone No.");
String PHONE=br.readLine();
Class.forName("oracle.jdbc.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
Statement stmt=con.createStatement();
String q1="INSERT INTO STUDENT VALUES('"+SID+"','"+NAME+"','"+COLLEGE+"','"+PHONE+"')";
int t=stmt.executeUpdate(q1);
if(t>0)
System.out.println("Inserted Successfully");
con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}
