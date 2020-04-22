package testpackage.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrintHelloWorld {

		public static void main(String[] args) {
		
			StringBuffer helloOK = new StringBuffer("1");
			
//			TreeMap<K, V>
//			Collections
//			String			
			
			ExecutorService ee = Executors.newFixedThreadPool(2);
			Runnable rr = () -> System.out.println();
			Callable<Object> ss = () -> {
				System.out.println();
				return null;
			};
			
			Future<?>  dd= ee.submit(rr);

			
			
			PrintTask1 lets = null;
			
			if(null != lets)
				System.out.println("abc");
			
			
			
			Thread t1 = new Thread(new PrintTask1(helloOK),"helloThread");
			Thread t2 = new Thread(new TaskWorld12(helloOK),"worldThread");
			t2.start();
			t1.start();
			
			while(t1.isAlive() || t2.isAlive()) {
				System.out.println("Thread state :"+t1.getName()+" : "+t1.getState().name());
				System.out.println("Thread state :"+t2.getName()+" : "+t2.getState().name());
			}
			
//			t1.interrupt();
//			t2.interrupt();
		}

	}

	class PrintTask1 implements Runnable {
		
		private StringBuffer lock;
		
		public StringBuffer getLock() {
			return lock;
		}

		public PrintTask1(StringBuffer lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			
			int ii=0;
			
			System.out.println(Thread.currentThread().getName() + ": "+Thread.currentThread().isInterrupted());
			
			synchronized (lock) {
				while(ii<10) {
//				System.out.println(Thread.currentThread().getName() + ": loop starts "+ii);
					if(lock.length()>0) {
						System.out.println("Hello ");
						lock.deleteCharAt(0);
						ii++;
//						lock.notifyAll();
					}
					else {
						try {
//							System.out.println(Thread.currentThread().getName() + ": calls wait");
							lock.wait();
//							System.out.println(Thread.currentThread().getName() + ": after wait");
						} catch (InterruptedException e) {
//							System.out.println(Thread.currentThread().getName() + ": interupted");
//							e.printStackTrace();
						}
					}
					lock.notifyAll();
				}
//				System.out.println(Thread.currentThread().getName() + ": loop ends "+ii);
			}
		}
	}


	class TaskWorld12 implements Runnable {
		
		public TaskWorld12(StringBuffer lock) {
			super();
			this.lock = lock;
		}

		private StringBuffer lock;
		

		@Override
		public void run() {
		int ii=0;
		System.out.println(Thread.currentThread().getName() + ": "+Thread.currentThread().isInterrupted());
		
		synchronized (lock) {
			while(ii<10) {
				
//				System.out.println(Thread.currentThread().getName() + ": loop starts "+ii);
				
					if(lock.length()==0) {
						System.out.println("World");
						lock.append("2");
						ii++;
//						lock.notifyAll();
					}
					else {
						try {
//							System.out.println(Thread.currentThread().getName() + ": calls wait");
							lock.wait();
//							System.out.println(Thread.currentThread().getName() + ": after wait");

						} catch (InterruptedException e) {
//							System.out.println(Thread.currentThread().getName() + ": interupted");
//							e.printStackTrace();
						}
					}
					lock.notifyAll();	
			}
//				System.out.println(Thread.currentThread().getName() + ": loop ends "+ii);
			}
		}
	}
