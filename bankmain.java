import java.io.*;

class bankmain
{
public static void main(String args[])throws Exception
{
Authentication aut=new Authentication();
int t=aut.ValidateUser();
if(t==1)
{
System.out.println("ROOT ACCESS GRANTED");
System.out.println("***********************************Welcome to Bank Online Banking System*************************************");

service s=new service();
s.menu();
}
else
System.out.println("Invalid login credentials");
}
}