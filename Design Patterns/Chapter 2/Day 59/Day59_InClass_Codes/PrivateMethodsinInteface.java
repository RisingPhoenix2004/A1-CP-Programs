interface One{
	private void commonCode(){
		System.out.println("Common Code");
	}
	private static void commonCode2(){
		System.out.println("Common Code2");
	}
	default void m1(){
		commonCode();
		System.out.println("m1 called");
	}
	default void m2(){
		commonCode();
		System.out.println("m2 called");
	}
	default void m3(){
		commonCode();
		System.out.println("m3 called");
	}
	static void m4(){
		commonCode2();
	}
}
class Test implements One{
	public static void main(String[] args){
		Test t = new Test();
		t.m1();
		t.m2();
		t.m3();
		One.m4();
	}
}
