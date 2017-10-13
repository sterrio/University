import java.util.Scanner;
import java.io.*;
public class ExpenseListDemo
{
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		ExpenseList sepexpenses = new ExpenseList();
		String date, desc, cost;
		Expense exp=null;
		
		while (inputFile.hasNext())
		{
			date = inputFile.nextLine();
			desc = inputFile.nextLine();
			cost = inputFile.nextLine();
			exp = new Expense(date, desc, Double.parseDouble(cost));
			sepexpenses.add(exp);
		}
		
		inputFile.close();		
		
		System.out.println("Sep Expenses");
		sepexpenses.enumerate();
		System.out.println("The max expense was: " + sepexpenses.maxExpense());
		System.out.println("The min expense was: " + sepexpenses.minExpense());
		System.out.println("The avg expense was: " + sepexpenses.avgExpense());
		System.out.println("The amount spent on groceries was: " + sepexpenses.amountSpentOn("Groceries"));
		System.out.println("The total expenses were: " + sepexpenses.totalExpense());
		
		//add other test statements here
		
	}
}