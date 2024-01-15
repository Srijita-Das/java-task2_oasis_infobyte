/*
We have all come across ATMs in our cities and it is built on Java. 
This complex project consists of five different classes and is a console-based 
application. When the system starts the user is prompted with user id and user pin.
On entering the details successfully, then ATM functionalities
are unlocked. The project allows to perform following operations:

1. Transactions History
2. Withdraw
3. Deposit
4. Transfer
5. Quit */


package Task3;

import java.util.Scanner;

public class ATM_Interface 
{
	public static void login()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user id");
		String id=sc.next();
		System.out.println("Enter user pin");
		int pin=sc.nextInt();
		String uid="Srijita";
		int upin=1234;
		if(id.equals(uid) && pin ==upin)
		{
			System.out.println("Login success");
		}
		else
		{
			System.out.println("Enter your credentials properly");
		}
		
	}
public static void main(String[] args) 
{
	double balance=60000;
	int transaction=0;
	String transaction_history="";
	Scanner sc=new Scanner(System.in);
	System.out.println("Welcome to ATM Interface");
	login(); 
	System.out.println("Initial balance in your account is: "+ balance);
	System.out.println("\nMENU \n1. Transaction History \n2. Withdraw \n3. Deposit \n4. Transfer \n5. Quit");
	int ch;
	ch=sc.nextInt();
	switch(ch)
	{
	case 1: 
		Transaction.view_transaction(balance, transaction);
		break;
	case 2:
		Withdraw.withdraw(balance,transaction);
		break;
	case 3: 
		Deposit.deposit(balance, transaction);
		break;
	case 4:
		Transfer.transfer(balance, transaction);
		break;
	case 5:
		Quit.quit();
		break;
	default:
		System.out.println("Enter valid choice");
		break;
	}
	
	
}

}
class Transaction
{
	static void view_transaction(double balance, int transaction)
	{
		String transaction_history="";
		if(transaction == 0)
		{
			System.out.println("No transactions found");
		}
		else
		{
			System.out.println(transaction_history);
		}
	}
}
class Withdraw
{
	static void withdraw(double balance, int transaction)
	{
		String transaction_history="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount to be withdrawn");
		double amt=sc.nextDouble();
		if (balance < amt)
		{
			System.out.println("Insufficient balance");
			
		}
		else
		{
			balance= balance-amt;
			transaction++;
			String str= "Rs. " + amt + " withdrawn";
			transaction_history=transaction_history.concat(str);
		}
		System.out.println("Account balance "+ balance);
		System.out.println(transaction_history);
		}
}
class Deposit
{
	static void deposit(double balance, int transaction)
	{
		String transaction_history="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount to be depositted");
		double amt=sc.nextDouble();
		balance= balance+amt;
		transaction++;
		String str= "Rs. " + amt + " depositted";
		transaction_history=transaction_history.concat(str);
		System.out.println("Account balance "+ balance);
		System.out.println(transaction_history);
	}
}
class Transfer
{
	static void transfer(double balance,int transaction)
	{
		String transaction_history="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Recipient's name");
		String name=sc.next();
		System.out.println("Enter amount to be transferred");
		double amt=sc.nextDouble();
		if(balance >= amt)
		{
			if(amt <= 50000)
			{
				balance=balance-amt;
				System.out.println("Amount successfully transferred to "+ name);
				transaction++;
				String str= "Rs. " + amt + " transferred to "+ name;
				transaction_history=transaction_history.concat(str);
				System.out.println("Account balance "+ balance);
				System.out.println(transaction_history);
			}
			else
			{
				System.out.println("Sorry limit is Rs. 50000");
			}
		}
		else
		{
			System.out.println("Insuficient balance");
		}
	}
}
class Quit
{
	static void quit()
	{
		System.out.println("Logout of the system");
	}
}
