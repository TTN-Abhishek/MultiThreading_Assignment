package question3;

class sync {
	void printTable(int n) {
		synchronized (this) {
			for(int i=1; i<=5; i++) {
				System.out.println(n*i);
				try {
					Thread.sleep(500);
				}
				catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}

class thread1 extends Thread {
	sync syn;
	
	thread1(sync syn) {
		this.syn = syn;
	}
	public void run() {
		syn.printTable(10);
	}
}

class thread2 extends Thread {
	sync syn;

	thread2(sync syn) {
		this.syn = syn;
	}
	public void run() {
		syn.printTable(100);
	}
}

public class que3 {
	public static void main(String args[]) {
		sync obj = new sync();
		thread1 t1 = new thread1(obj);
		thread2 t2 = new thread2(obj);
		t1.start();
		t2.start();
	}
}
