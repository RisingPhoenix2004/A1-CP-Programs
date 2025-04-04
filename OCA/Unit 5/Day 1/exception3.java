class Exception3 {
	public static void main(String [] args) {
		for(int i=1; i <= 6; i++){
			try {
				if(i%3 == 0) throw new Exception();
				System.out.println("outer try : "+i);			
				try {
					if(i%2 == 0) throw new Exception();
					System.out.println("inner try : "+i);	}
				catch(Exception e){
					i--;
					System.out.println("inner catch : "+i);}
				finally {
					i++;
					System.out.println("inner finally : "+i);}}
			catch(Exception e)  {
				i--;
				System.out.println("outer catch : "+i);}
			finally{
				i++;
				System.out.println("outer finally : "+i);}
		}
	}
}

