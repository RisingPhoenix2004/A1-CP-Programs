class myThread2 extends Thread
{
	double myamount;
	int op_type;
	static bankapp2 bank = new bankapp2();
	myThread2(double amt, int j)
	{
		myamount = amt;
		op_type = j;
	}

	public void run()
	{
		if(op_type == 1)
		{
			bank.deposit(myamount);                 
		}
		else if(op_type == 2)
		{
			bank.withdraw(myamount);                    
		}
	}
}

class bankapp2
{
	double amount = 5000;
	double getBalance()
	{
		return amount;
	}

	void setBalance(double a)
	{
		amount = a;
	}
	
  void deposit(double a)
	{
		String str = Thread.currentThread().getName();
		System.out.println(str + " In Deposit");
		try
		{
      synchronized(this) {
        double amount=getBalance();
        System.out.println(str + " Got the initial balance as " + amount);
        amount += a;
        Thread.sleep(2000);
        System.out.println(str + " Deposit Amount is " + a);
        setBalance(amount);
        show();
      }
			System.out.println(str + " Balance " + getBalance());
		}
		catch(Exception e) {}
	}

	void show()
	{
    synchronized(this) {
      String str = Thread.currentThread().getName();
      System.out.println(str+" In Show  ");
      double amount = getBalance();
      System.out.println(str+" total amount is: " + getBalance());
    }
	}

	void withdraw(double a)
	{
		String str=Thread.currentThread().getName();
		System.out.println(str+" In Withdraw");
		try
		{
      synchronized(this) {
        double amount = getBalance();
        System.out.println(str + " Got the balance as " + amount);
        System.out.println(str + " Withdraw amount is "+ a);
        double diff = amount - a;
        if(diff > amount)
          System.out.println("Your balance is less");
        else
          amount -= a;
        System.out.println(str + " Current balance is "+ amount);
        setBalance(amount);
        show();
      }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		myThread2 u1 = new myThread2(1000, 1);
		myThread2 u2 = new myThread2(2000, 2);
		u1.start();
		u2.start();
	}
}