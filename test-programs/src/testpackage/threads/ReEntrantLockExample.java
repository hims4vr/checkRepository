package testpackage.threads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample {
	

	

	public static void main(String[] args) {
		

		ReentrantLock helloOK = new ReentrantLock();
//		ConcurrentHashMap<K, V>
		boolean isHelloOk = false;

		helloOK.newCondition();
		
		Thread t1 = new Thread(new PrintTaskRe(helloOK),"helloThread");
		Thread t2 = new Thread(new TaskWorldre(helloOK),"worldThread");
//	t2.start();
//	t1.start();
//	t1.interrupt();
//	t2.interrupt();
	}
	
	
}

class PrintTaskRe implements Runnable {
	
	private ReentrantLock lock;
	
	
	public PrintTaskRe(ReentrantLock helloOK) {
		super();
		this.lock = lock;
	}


	@Override
	public void run() {
		
		int ii=0;
		
		System.out.println(Thread.currentThread().getName() + ": "+Thread.currentThread().isInterrupted());
		
		synchronized (lock) {
			while(ii<10) {
			System.out.println(Thread.currentThread().getName() + ": loop starts "+ii);
//				if(lock.length()>0) {
					System.out.print("Hello ");
//					lock.deleteCharAt(0);
					ii++;
//					lock.notifyAll();
				}
//				else {
					try {
						System.out.println(Thread.currentThread().getName() + ": calls wait");
						lock.wait();
						System.out.println(Thread.currentThread().getName() + ": after wait");
					} catch (InterruptedException e) {
						System.out.println(Thread.currentThread().getName() + ": interupted");
//						e.printStackTrace();
					}
//				}
				lock.notifyAll();
			}
			System.out.println(Thread.currentThread().getName() + ": loop ends "+ii);
		}
//	}
}


class TaskWorldre implements Runnable {
	
	public TaskWorldre(StringBuffer lock) {
		super();
		this.lock = lock;
	}

	public TaskWorldre(ReentrantLock helloOK) {
		// TODO Auto-generated constructor stub
	}

	private StringBuffer lock;
	

	@Override
	public void run() {
	int ii=0;
	System.out.println(Thread.currentThread().getName() + ": "+Thread.currentThread().isInterrupted());
	
	synchronized (lock) {
		while(ii<10) {
			
			System.out.println(Thread.currentThread().getName() + ": loop starts "+ii);
			
				if(lock.length()==0) {
					System.out.println("World");
					lock.append("2");
					ii++;
//					lock.notifyAll();
				}
				else {
					try {
						System.out.println(Thread.currentThread().getName() + ": calls wait");
						lock.wait();
						System.out.println(Thread.currentThread().getName() + ": after wait");

					} catch (InterruptedException e) {
						System.out.println(Thread.currentThread().getName() + ": interupted");
//						e.printStackTrace();
					}
				}
				lock.notifyAll();	
		}
			System.out.println(Thread.currentThread().getName() + ": loop ends "+ii);
		}
	}
}