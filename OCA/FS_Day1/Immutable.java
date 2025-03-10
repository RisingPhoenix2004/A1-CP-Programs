class Immutable 
{
	public static void main(String[] args) 
	{
		Integer i = 10;
		Integer j = i;
		System.out.println("i " + i + " j " + j);
		i = i + 2;
		j = j + 5;
		System.out.println("i " + i + " j " + j);
	}
}
