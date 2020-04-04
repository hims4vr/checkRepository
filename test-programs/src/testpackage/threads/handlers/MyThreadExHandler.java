package testpackage.threads.handlers;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyThreadExHandler implements UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {

		System.out.println("uncaughtException Thead: "+Thread.currentThread().getName());
		System.out.println("Thread exception wala: "+t.getName());
		System.out.println("Current Thead: "+e);
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Current Thead: "+Thread.currentThread().getName());
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Current Thead: "+Thread.currentThread().getName());
				Integer.parseInt("al");
				//throw new RuntimeException("test Exception");
				System.out.println("ooooooooooo");
			
			}
		});
		
		t1.setUncaughtExceptionHandler(new MyThreadExHandler());
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("end Thead: "+Thread.currentThread().getName())	;	
	}	
	

}
