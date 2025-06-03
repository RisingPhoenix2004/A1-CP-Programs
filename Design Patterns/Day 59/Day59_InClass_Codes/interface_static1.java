interface One
{
  static int getInt() 
  {
    return 1;
  }
}

// The static methods are not inherited by a class implementing the interface

class test implements One
{  
  public static void main(String[] args)
  {
    test obj = new test();
    // obj.getInt();    // Uncomment to see the error
    
    System.out.println(One.getInt());
  }
}
