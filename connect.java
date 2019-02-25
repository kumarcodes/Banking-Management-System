import java.sql.*;

class connect
{
Connection con=null;
public Connection fetchcon()
{
try
{
Class.forName("oracle.jdbc.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
}
catch(Exception e)
{
}
return con;
}
}