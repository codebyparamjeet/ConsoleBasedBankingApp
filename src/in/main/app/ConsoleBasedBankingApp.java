// Package declaration for this Java file
package in.main.app;

// Importing Scanner class 
import java.util.Scanner;

/*
 * This is a Stand-alone Application which perform actions like 
 * adding money into account 
 * withdraw money, 
 * checking balance or exit
 * it is also validating while reading invalid user inputs and suggest then to re-enter again
 */


// Class Declaration for ConsoleBaseBankingApp
public class ConsoleBasedBankingApp {

	//variable declares to store values like AccountHolderName -> accHolderName, AccountNumber -> accNumber, AccountBalance -> accBalance
	static String accHolderName= "";
	static String accNumber = "";
	static double accBalance = 0d;


	// Main method to start the application
	public static void main(String[] args) {

		//Welcome message to the user
		System.out.println("Welcome to Banking System");

		//Prompting user to enter their name in console
		System.out.print("Enter you're name :: ");

		// Creating an object of Scanner class to read input from the console
		Scanner scanner = new Scanner(System.in);

		// reading AccountHolderName and storing into accHolderName static variable
		accHolderName = scanner.nextLine();
		
		// validating user input for accountHolder name by using string matches() that works on regular expression(Regex)
		while(!accHolderName.matches("[a-zA-Z ]+")) {
		    System.out.println("Invalid name. Please enter a valid name without any digits or special characters.");
		    accHolderName = scanner.nextLine();
		}

		//Prompting user to enter their name in console
		System.out.print("Enter your Account Number :: \t");

		// Reading accnumber from the console and handling invalid input
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid account number. Please enter a valid number.");
			scanner.next(); // consume the invalid input
		}

		// Assigning the valid account number to the accNumber static variable
		accNumber = scanner.next();

		// Implemented while loop to provide Banking app menu options to the user until user exits
		while(!accHolderName.isEmpty() && !accNumber.isEmpty())
		{
			// Displaying menu options to user
			System.out.println("=====================================");
			System.out.println("Select number for particular task ");
			System.out.println("1. Check Balance \t 2. Deposit \t 3. Withdraw \t 4. exit");

			// Reading user choice from console
			int userChoice = scanner.nextInt();

			// Using switch-case statement to perform operation on userChoice input
			switch(userChoice)
			{
			// case 1: Here call to a method which check Balance in account entered by user
			case 1:
				checkBalance();
				break;

				// case 2: Here call to a method which deposit amount entered by user in provided account number
			case 2:
				depositAmount(scanner);
				break;

				// case 3: Here call to a method which Withdraw money from account number provided by user also validate if amount is available or not, if not then Insufficient balance message return
			case 3:
				withdrawAmount(scanner);
				break;

				// case 4: Exit application
			case 4:
				System.out.println("Take out your debit card from machine");
				System.exit(0);
				break;

				// Default case: For invalid choice
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		}
	}


	// Method to check account balance
	public static void checkBalance()
	{
		System.out.println("Account Balance :" + accBalance);
	}

	// Method to deposit money into account
	public static void depositAmount(Scanner scanner)
	{
		System.out.print("Enter Deposit Amount : ");

		// Reading the deposited amount from the console and then handling it if invalid input
		while(!scanner.hasNextDouble())
		{
			System.out.println("Please enter valid number");
			scanner.next();
		}
		// Assigning the valid deposit amount -> depositAmount variable
		double depositAmount = scanner.nextDouble();
		if(depositAmount <= 0)
		{
			System.out.println("Please enter valid input");
		}
		else {
			accBalance += depositAmount;
			System.out.println("Money has been credited! \n\n");
		}
	}

	// Method to withdraw amount from accoutnumber
	public static void withdrawAmount(Scanner scanner)
	{
		//Prompting user to enter withdrawl amount from account in console
		System.out.print("Enter amount to withdraw: ");

		// Reading the withdrawl amount from the console and then handling it if invalid input
		while(!scanner.hasNextDouble())
		{
			System.out.println("Please enter valid number");
			scanner.next();
		}

		double withdrawAmount = scanner.nextDouble();

		// Checking the valid amount then cut it from account number
		if(withdrawAmount <= 0)
		{
			System.out.println("Please enter a valid amount.");
		}
		else if(withdrawAmount > accBalance)
		{
			System.out.println("Insufficient balance :: " + accBalance);
		}
		else {
			accBalance -= withdrawAmount;
			System.out.println("Collect cash \n");
		}
	}
}
