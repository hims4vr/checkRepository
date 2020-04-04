package testpackage.threads.xcutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecuterEx {

	
	 public static void main(String[] args) {
		
		ExecutorService my = Executors.newFixedThreadPool(5);
		List<Callable<Integer>> calls = new ArrayList<Callable<Integer>>();
		
		Object abc = null;
		
		
		final AtomicInteger intt = new AtomicInteger(0);

		while(intt.get()<3) {
			System.out.println("counter"+intt.getAndIncrement());
			
			try {
			my.submit(() -> {
				System.out.println("abc : "+intt.get());
				try {
					Thread.sleep(100);
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				return intt.getAndIncrement();});
			}catch (Exception e) {
				e.printStackTrace();
				break;
			}
			
			if(intt.get()==50) {
				intt.compareAndSet(50, 99);
				my.shutdown();
			}
		}
	
		System.out.println("wating for termination"+System.currentTimeMillis());		
		try {
			my.awaitTermination(100, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("wating for shutting down"+System.currentTimeMillis());
		
		System.out.println(my.isShutdown());
		
		System.out.println("exit main");
		
//		List<Runnable> cc =my.shutdownNow();
//		System.out.println("rejected task: "+cc.size());
		
	}
	
}
