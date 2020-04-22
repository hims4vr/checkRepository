package testpackage;

public class OverLoadingTest {

	
	private void method(String ss) 
	{
		System.out.println("String");
		System.out.println(ss);
	}
	
	private void method(Object ob) {
		System.out.println("object wala");
		System.out.println(ob);
	}
	
	private void method(Integer ii) {
		System.out.println("Integer wala");
	}
	
	public static void main(String[] args) {
		OverLoadingTest tt = new OverLoadingTest();
		
		tt.method("ss");
		tt.method(12);
		tt.method(1.1);
//		tt.method(null);
	}
}
