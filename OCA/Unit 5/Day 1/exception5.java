/* Checked exceptions have Exception in their hierarchy but not RuntimeException.
  They must be handled or declared. Errors extend the Error class. 
  They are thrown by the JVM and should not be handled or declared. */

class Exception5{
  static String strObj;
  public static int addPositive(int x, int y) throws Exception{
    if (x < 0 || y < 0)
      throw new Exception("arguments cannot be negative");
    return x + y;
  }
  static {
    int[] count = new int[3];
    int num = count[-1];    // ExceptionInInitializerError
  }
public static void main(String[] args)  {
    String str = "kmit";
    Object obj = str;
	try{
    Integer number = (Integer) obj;   // class cast exception
    System.out.println(addPositive(-1, 3));
	}
	catch(Exception e){
		e.printStackTrace();
	}
    //System.out.println(strObj.length());  // NullPointerException

   // System.out.println(Integer.parseInt("kmit")); // NumberFormatException
	}
}
