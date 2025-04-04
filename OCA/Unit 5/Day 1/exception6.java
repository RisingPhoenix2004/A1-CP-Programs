class insuffbalance extends Exception
{
	private double balance;
 	public insuffbalance(String str, double amt)
 	{
		super(str);
		balance = amt;
	}
 	public  double getbalance()
 	{
		return balance;
	}
}

class account
{
  private int account_no;
  private String account_name;
  private double balance;
  final double MIN_BAL = 1000.0D;

	public account(int acc_no, String account_name, double init_amt)
  {
    this.account_no = account_no;
    this.account_name = account_name;
    balance = init_amt;
  }

	public void deposit(double amt)
	{
		balance += amt;
	}

	public void withdraw(double amt) throws insuffbalance
	{
		double new_bal = balance - amt;
    if(new_bal > MIN_BAL)
    {
      balance = new_bal;
    }
		else
    {
      insuffbalance insb = new insuffbalance(
        "Insufficient balance in your account", amt);
        throw insb;
    }
  }

  public static void main(String[] args) 
	{
		account accountount;
		try
		{
      accountount = new account(101, "Test", 1500);
      accountount.deposit(1000);
      accountount.withdraw(3000);
		}
    catch(insuffbalance insb)
		{
      System.out.println("Withdrawal amount is " + insb.getbalance());
      System.out.println(insb.getMessage());
      insb.printStackTrace();
		}        
   	finally
		{
			System.out.println("I am in finally block");
		}
	}
}
