
public class ExpenseList
{
	private List<Expense> expenses;
	
	
	public ExpenseList()
	{
		expenses = new List<Expense>();
	}
	public void add(Expense exp)
	{
		expenses.add(exp);
	}
	
	public boolean isEmpty()
	{
		return expenses.isEmpty();
	}
	public boolean contains(Expense exp)
	{
		return expenses.contains(exp);
	}
	public Expense first()
	{
		return expenses.first();
	}
	public Expense next()
	{
		return expenses.next();
	}
	public void enumerate()
	{
		expenses.enumerate();
	}
	
	public double maxExpense()
	{
		double max =0.0, amt;
		Expense exp = expenses.first();
		while (exp!=null)
		{
			amt = exp.getAmount();
			if (amt>max)
				max = amt;
			exp = expenses.next();
		}
		return max;
	}
	public double minExpense()
	{
		double min =Double.MAX_VALUE, amt;
		Expense exp = expenses.first();
		if (exp==null) return 0.0;
		else
		{
		
			while (exp!=null)
			{
				amt = exp.getAmount();
				if (amt<min)
					min = amt;
				exp = expenses.next();
			}
		}
		return min;
	}
	public double avgExpense()
	{
		double sum=0;
		Expense exp = expenses.first();
		while(exp!=null)
		{
			sum+=exp.getAmount();
			exp = expenses.next();
		}
		if (expenses.size()==0)
			return 0.0;
		else
			return (sum/expenses.size());
	}
	public double totalExpense()
	{
		double sum =0;
		Expense exp = expenses.first();
		while(exp!=null)
		{
			sum+=exp.getAmount();
			exp = expenses.next();
		}
		return sum;
	}
	public double amountSpentOn(String expItem)
	{
		double sum=0;
		Expense exp = expenses.first();
		while(exp!=null)
		{
			if (expItem.equals(exp.getItem()))
				sum+=exp.getAmount();
			exp = expenses.next();
		}
		return sum;
	}
	
	
}