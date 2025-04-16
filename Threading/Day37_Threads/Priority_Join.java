class threadapp extends Thread{
  static public int tick = 1;
  String name_of_thread;

	threadapp(String s){
		name_of_thread = s;
	}

	public void run(){
    while(tick < 5000000) {
        tick++;
        if((tick % 1000000) == 0)
          System.out.println(name_of_thread + ": " + tick);
    }    
  }
}	
	
class Priority_Join {
	public static void main(String[]args){
		threadapp  arr[] = new threadapp[3];

		for(int i = 0; i < 3; i++) 
{
			arr[i] = new threadapp("Thread "+i);

      if(i == 0)
          arr[i].setPriority(Thread.MAX_PRIORITY);
      else if(i == 1)
          arr[i].setPriority(Thread.MIN_PRIORITY);

			arr[i].start();

      try {
        // arr[i].join();
      }
      catch(Exception e)
      {
        System.out.println("Join exception is " + e.getMessage());
      }
		}
    System.out.println("main ends");
	}
}
