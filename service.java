import java.io.*;

class service
{
	public void menu()throws Exception
	{
		while(true)
		{
	System.out.println("Enter 1 to Create New Account.");
	System.out.println("Enter 2 for Deposit.");
	System.out.println("Enter 3 for Withdrawl.");
	System.out.println("Enter 4 for MiniStatement");
	System.out.println("Enter 5 for Balance Enquiry.");
	System.out.println("Enter 6 for Changing Password.");
	System.out.println("Enter 7 for Account Details.");
	System.out.println("Enter 8 to  Exit.");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter your Choice.");
int choice=Integer.parseInt(br.readLine());
UserAccount uc=new UserAccount();
Transaction t=new Transaction();
switch(choice)
{
	case 1:
	uc.createAccount();
	break;
	case 2:
	t.deposit();
	break;
	case 3:
	t.withdrawal();
	break;
	case 4:
	t.ministatement();
	break;
	case 5:
	t.balcheck();
	break;
	case 6:
	uc.changepass();
	break;
	case 7:
	uc.AccDetails();
	break;
	case 8:
	System.exit(0);
}
}
}
}
