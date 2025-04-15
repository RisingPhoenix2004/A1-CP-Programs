import java.util.*;
class Exception1 {
	public static void main(String [] args) {
		try {
      System.out.println("Start of try block");
      Scanner sc = new Scanner (System.in);
			int i = sc.nextInt();
			if(i == 0)	throw new Exception () ;
			System.out.println("End of try block");
		}
		catch(Exception e) {
			System.out.println("Inside the catch block");
		}
		System.out.println("Program End");
	}
}
