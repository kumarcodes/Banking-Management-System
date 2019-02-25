import java.io.*;
import java.sql.*;
import java.util.Date; 

class Transaction
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
void deposit()throws Exception
{
System.out.println("Enter Account No. to Deopsit: ");
String accno=br.readLine();
System.out.println("Enter Amount to be deposited: ");
double damt=Double.parseDouble(br.readLine());
connect c=new connect();
Connection con=c.fetchcon();
Statement stmt=con.createStatement();
String q1="select tid,balance from bank_transaction where accno='"+accno+"' and tid=(select max(tid) from bank_transaction where accno="+accno+")";
ResultSet rs=stmt.executeQuery(q1);
int tid=0;
double balance=0;
if(rs.next())
{
tid=rs.getInt(1);
balance=rs.getDouble(2);
}
tid=tid+1;
double wamt=0;
Date date = new Date();
		 String dt = String.format("%tc", date );
		 balance=balance+damt;
		 String q2 = "insert into bank_transaction values('"+tid+"','"+accno+"','"+damt+"','"+wamt+"','"+dt+"','"+balance+"')";
        int t1 = stmt.executeUpdate(q2);
        if (t1 > 0)
            System.out.println("Deposited Successfully: ");
		con.close();
}

void withdrawal()throws Exception
{
System.out.println("Enter Account No. to Withdrawal: ");
int accno=Integer.parseInt(br.readLine());
System.out.println("Enter Amount to be Withdrawal: ");
double wamt=Double.parseDouble(br.readLine());
connect c=new connect();
Connection con=c.fetchcon();
Statement stmt=con.createStatement();
String q1="select tid,balance from bank_transaction where accno='"+accno+"' and tid=(select max(tid) from bank_transaction where accno="+accno+")";
ResultSet rs=stmt.executeQuery(q1);
int tid=0;
double balance=0;
if(rs.next())
{
tid=rs.getInt(1);
balance=rs.getDouble(2);
}
if(balance-wamt>=500)
{
double damt=0;
Date date = new Date();
		 String dt = String.format("%tc", date );
		 balance=balance-wamt;
		 String q2 = "insert into bank_transaction values('"+tid+"','"+accno+"','"+damt+"','"+wamt+"','"+dt+"','"+balance+"')";
        int t1 = stmt.executeUpdate(q2);
        if (t1 > 0)
            System.out.println("Debited Successfully: ");
}
else
	System.out.println("INSUFFICENT BALANCE: ");
		con.close();

}

void ministatement()throws Exception
{
System.out.println("Enter Account No.: ");
int accno=Integer.parseInt(br.readLine());
connect c=new connect();
Connection con=c.fetchcon();
Statement stmt=con.createStatement();
System.out.println("TID\tAccno\tCREDIT\t\tDEBIT\t\t\tDATE\t\t\t\t\tBALANCE");
String q1="select * from bank_transaction where accno="+accno;

ResultSet rs=stmt.executeQuery(q1);
while(rs.next())
{
	System.out.println(rs.getInt(1) +"\t"+rs.getInt(2) +"\t"+rs.getDouble(3) +"\t"+"\t"+"\t"+ rs.getDouble(4)+"\t"+rs.getString(5) +"\t"+ rs.getDouble(6));
}
con.close();
}
void balcheck()throws Exception
{
System.out.println("Enter Account No.: ");
int accno=Integer.parseInt(br.readLine());
connect c=new connect();
Connection con=c.fetchcon();
Statement stmt=con.createStatement();
String q1="select tid,balance from bank_transaction where accno="+accno+" and tid=(select max(tid) from bank_transaction where accno="+accno+")";
ResultSet rs=stmt.executeQuery(q1);
double balance=0;
if(rs.next())
balance=rs.getDouble(2);
System.out.println("Remaining Balance: "+balance);
con.close();
}
}
		