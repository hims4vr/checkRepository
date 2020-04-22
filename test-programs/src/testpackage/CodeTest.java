package testpackage;

public class CodeTest {
	
	transient int i =10;
	static int j = 90;
	volatile int k = 18;
	
	public static void main(String[] args) {
		
		String system = null;
		System.out.println("hiiiiiiii");

		
		Runnable rr = () -> CodeTest.method1();
		Runnable rr2 = () -> CodeTest.method2();
		
		Thread t1 = new Thread(rr);
		Thread t2 = new Thread(rr2);
		
		t1.start();
		t2.start();
		
		new CodeTest();
		
		int _52 = 99;
		
		int x1 = _52; // This is an identifier, not a numeric literal.

		int x2 = 5_2; // OK. (Decimal literal)

//		int x2 = 52_; // Illegal. (Underscores must always be between digits)

		int x3 = 5_______2; // OK. (Decimal literal.)

//		int x4 = 0_x52; // Illegal. Can't put underscores in the "0x" radix prefix.

//		int x5 = 0x_52; // Illegal. (Underscores must always be between digits)

		int x6 = 0x5_2; // OK. (Hexadecimal literal)

//		int x6 = 0x52_; // Illegal. (Underscores must always be between digits)

		int x61 = 0x99_99; // Illegal. (Not valid with the underscore removed)

		int x7 = 0_52; // OK. (Octal literal)

		int x71 = 05_2; // OK. (Octal literal)
		

//		int x8 = 052_; // Illegal. (Underscores must always be between digits)


		
	}
	
	private static Object lock = new Object();
	
	
	public synchronized static void method1() {
		System.out.println("method1-start");
		synchronized(lock){
			try {
				System.out.println("method1-start-syncß");
				Thread.sleep(10000);
				
			}catch (Exception e) {
			}
			System.out.println("method1-end-syncß");
		}
		System.out.println("method1-end");
	}
	
	
	public synchronized static void method2() {
		System.out.println("method2-start");
		synchronized(lock){
			try {
				System.out.println("method2-start-syncß");
				Thread.sleep(10000);
				
			}catch (Exception e) {
			}
			System.out.println("method2-end-syncß");
		}
		System.out.println("method2-end");
	}
	
//	FileInputStream
	
	
	Foo dd = new Foo("Hi");
	static Foo rr = new Foo("hey");

}



class Foo{
	
	Foo(String a){
		System.out.println(a);
		
	}
	
}