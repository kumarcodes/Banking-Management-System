import java.io.*;                                                                                                                                                                                                                                                                                                                                                                                                                                          import java.io.*;
import java.sql.*;
import java.util.Date; 

class UserAccount {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void createAccount() throws Exception {
        int accno = 0;
        connect c = new connect();
        Connection con = c.fetchcon();
        Statement stmt = con.createStatement();
        String q1 = "select max(accno) from bank_user";
        ResultSet rs = stmt.executeQuery(q1);
        if (rs.next())
            accno = rs.getInt(1);
        accno = accno + 1;
        System.out.println("New Account Number is: "+accno);
        System.out.println("Enter Account Holder Name:");
        String name = br.readLine();
        System.out.println("Enter Address Details: ");
        String addr = br.readLine();
        System.out.println("Enter Contact Number: ");
        String phno = br.readLine();
        System.out.println("Enter AadhaarID: ");
        String aid = br.readLine();
        System.out.println("Enter DATE OF BIRTH: ");
        String dob = br.readLine();
        System.out.println("Enter email address: ");
        String email = br.readLine();
        System.out.println("Enter Account Opening Balance: ");
        double oppbal = Double.parseDouble(br.readLine());
        String q2 = "insert into bank_user values('"+accno+"','"+name+"','"+addr+"','"+phno+"','"+aid+"','"+dob+"','"+email+"')";
        int t = stmt.executeUpdate(q2);
        int tid = 1;
        double damt = oppbal;
        double wamt = 0;
         Date date = new Date();
		 String dt1 = String.format("%tc", date );
        double balance = oppbal;
        String q3 = "insert into bank_transaction values('"+tid+"','"+accno+"','"+damt+"','"+wamt+"','"+dt1+"','"+balance+"')";
        int t1 = stmt.executeUpdate(q3);
        if (t > 0 && t1 > 0)
            System.out.println("Account Created Successfully: ");
        con.close();
    }
    public void AccDetails() throws Exception {
        System.out.println("Enter Account Number: ");
        int accno = Integer.parseInt(br.readLine());
        connect c = new connect();
        Connection con = c.fetchcon();
        Statement stmt = con.createStatement();
        String q2 = "select * from bank_user where accno="+accno;
        ResultSet rs = stmt.executeQuery(q2);
        if (rs.next()) {
            System.out.println("Account Number: "+rs.getInt(1));
			System.out.println("Account Holder Name: "+rs.getString(2));
			System.out.println("Address: "+rs.getString(3));
			System.out.println("Contact Number: "+rs.getString(4));
			System.out.println("Aadhaar ID: "+rs.getString(5));
			System.out.println("Date of Birth: "+rs.getString(6));
			System.out.println("email address: "+rs.getString(7));
        } 
		else
            System.out.println("Invalid Account Number::");
        con.close();
    }
	void changepass()throws Exception
	{
		System.out.println("Enter USERID: ");
        String uid = br.readLine();
		System.out.println("Enter Old Password: ");
        String opass = br.readLine();
		System.out.println("Enter New Password: ");
        String npass = br.readLine();
		connect c = new connect();
        Connection con = c.fetchcon();
		Statement stmt=con.createStatement();
        String q1 = "update bank_authentication set password='"+npass+"' where userid='"+uid+"' and password='"+opass+"'";
		int t=stmt.executeUpdate(q1);
		if(t>0){
			System.out.println("Password Updated Successfully");
		}
		else
			System.out.println("Incorrect old Password");
		con.close();
	}
}

