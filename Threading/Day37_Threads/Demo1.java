class threadapp extends Thread{
	String name_of_thread;
	threadapp(String s){
		name_of_thread = s;
	}
	public void run(){
		try {
			for(int i = 0; i < 3; i++){	
				System.out.println(name_of_thread + ": " + i);
				Thread.sleep(1500);
				System.out.println(Thread.activeCount());
			}
		} 
		catch(InterruptedException ie) {}
	}
}	
	
class Demo1 {
	public static void main(String[]args){
		threadapp  arr[] = new threadapp[3];
		
		for(int i = 0; i < 3; i++) {
			arr[i] = new threadapp("Thread " + i);
			//arr[i].setDaemon(true);
			arr[i].start();	// replace with run
		}
		System.out.println("main ends");
	}
}
