package testpackage.threads;

public class TestInteruptions {

	public static void main(String[] args) {
	
		StringBuffer helloOK = new StringBuffer("1");
		
		Thread t1 = new Thread(new PrintTask(helloOK),"helloThread");
		Thread t2 = new Thread(new PrintTaskWorld(helloOK),"worldThread");
		t2.start();
		t1.start();
		t1.interrupt();
		t2.interrupt();
	}

}

class PrintTask implements Runnable {
	
	private StringBuffer lock;
	
	public PrintTask(StringBuffer lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		
		int ii=0;
		
		System.out.println(Thread.currentThread().getName() + ": "+Thread.currentThread().isInterrupted());
		
		while(ii<10) {
			System.out.println(Thread.currentThread().getName() + ": loop starts "+ii);
			synchronized (lock) {
				if(lock.length()>0) {
					System.out.print("Hello ");
					lock.deleteCharAt(0);
					ii++;
					lock.notifyAll();
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
			}
			System.out.println(Thread.currentThread().getName() + ": loop ends "+ii);
		}
	}
}


class PrintTaskWorld implements Runnable {
	
	public PrintTaskWorld(StringBuffer lock) {
		super();
		this.lock = lock;
	}

	private StringBuffer lock;
	

	@Override
	public void run() {
	int ii=0;
	System.out.println(Thread.currentThread().getName() + ": "+Thread.currentThread().isInterrupted());
	
		while(ii<10) {
			
			System.out.println(Thread.currentThread().getName() + ": loop starts "+ii);
			
			synchronized (lock) {
				if(lock.length()==0) {
					System.out.println("World");
					lock.append("2");
					ii++;
					lock.notifyAll();
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
			}
			System.out.println(Thread.currentThread().getName() + ": loop ends "+ii);
		}
	}
}