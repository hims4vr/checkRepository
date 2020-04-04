package testpackage;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class TestProducerConsumer {

public static void main(String[] args) {
	Queue<Integer> que = new LinkedBlockingQueue<Integer>();
	Producer pp = new Producer(que);
	
	Consumer cc = new Consumer(que);

	
	pp.produce();
	cc.consume();
}	

	
	
	
}
class Producer{
	
	Queue<Integer> que;

	public Producer(Queue<Integer> que) {
		super();
		this.que = que;
	}
	
	public void produce() {
		Random  random= new Random();
		int aa =random.nextInt();
		
		que.add(aa);
	}
	
}

class Consumer{
	
	Queue<Integer> que;

	public Consumer(Queue<Integer> que) {
		super();
		this.que = que;
	}
	
	public void consume() {
		que.poll();
	}
	
}