class mutable1
{
	public static void main(String[] args) 
	{
		StringBuilder sb1 = new StringBuilder("hello");
		StringBuilder sb2 = sb1;
		sb1.append("world");
		System.out.println("sb1: " + sb1.toString() + " sb2: " + sb2.toString() );
		sb2.reverse();
		System.out.println("sb1: " + sb1.toString() + " sb2: " + sb2.toString() );
	}
}
