import java.util.*;

// When System.exit is called in the try or catch
// block, finally does not run.
class Exception2 {
	public static void main(String [] args) throws Exception{
		try {
      System.out.println("Start of try block");
      Scanner sc = new Scanner (System.in);
			int i = sc.nextInt();
			if(i == 0)	throw new Exception ("Input supplied is zero") ;
			System.out.println("End of try block");
		}
		finally {
			System.out.println("Inside finally block");
		}
		System.out.println("Program End");
	}
}
