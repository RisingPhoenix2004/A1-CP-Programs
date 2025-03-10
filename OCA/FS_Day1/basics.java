public class basics
{
	public static void main(String[] args) 
	{
		System.out.println("Main of basics class");
	}

	public int main() 
	{
		System.out.println("Main of basics class with no argument");
		return 1;
	}
}

class test
{
	public static void main(String[] args) 
	{
		System.out.println("Main of test class");
	}
}

class demo
{
	public static void main(String[] args) 
	{
		System.out.println("Main of demo class");
	}
}

class testing
{
	public static void main(String[] args) 
	{
		basics obj = new basics();
		obj.main();
	}
}