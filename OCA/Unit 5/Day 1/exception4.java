class Exception4{
	static void fun(String s) throws Exception {
		String not_allowed[]={"a","b","c"};
		for(int i=0; i<3; i++)
			if(s.equals(not_allowed[i]))
				throw new Exception();
	}
	public static void main(String[]args){
		String str[]={"a","e","c","m"};
		for(int i=0;i<4;i++) {
			try {
				fun(str[i]);
				System.out.println(str[i].toUpperCase());
			} 
			catch(Exception e){
				System.out.println(str[i]+" is not processed");
			}
		}
	}
}
