import java.io.*;
import java.sql.*; 

class Authentication
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
public int ValidateUser()
{
int t=0;
try{

System.out.println("Enter UserID");
String userid=br.readLine();
System.out.println("Enter Password");
String password=br.readLine();
connect c=new connect();
Connection con=c.fetchcon();
Statement stmt=con.createStatement();
String q1="select * from bank_authentication where userid='"+userid+"' and password='"+password+"'";
ResultSet rs=stmt.executeQuery(q1);
if(rs.next())
t=1;
con.close();
}
catch(Exception e)
{
}
return t;
}
}
