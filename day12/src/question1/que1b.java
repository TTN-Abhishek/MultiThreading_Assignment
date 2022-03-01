package question1;

class que1b implements Runnable {
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Thread-1");
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		que1b s = new que1b();
		Thread t1 = new Thread(s);
		t1.start();
	}
}
