class Immutable2
{
	public static void main(String[] args) 
	{
		String s1 = "hello";
		String s2 = s1;
		s1.concat("world");
		//s1 = s1 + "world2";
		System.out.println("s1 " + s1 + " s2 " + s2);
		s2 = s2.toUpperCase();
		System.out.println("s1 " + s1 + " s2 " + s2);
	}
}
