class AssertionDemo 
{
	int addPos(int x, int y)
  	{
    	assert(x > 0);
    	assert(y > 0) : "Y is less than zero " + y;
    	return x + y;
  	}

	public static void main(String [] args) 
	{
    	AssertionDemo ad = new AssertionDemo();
    	System.out.println("output is " + ad.addPos(2, -3));
  	}	
}