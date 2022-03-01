package question4;

public class que4b {
	public static void main(String agrs[]) {
		System.out.println("Thread main - " + Thread.currentThread().getName());
		Thread t = new Thread(new que4b().new run());
		t.start();
	}
	private class run implements Runnable{
		public void run() {
			System.out.println(Thread.currentThread().getName() + " Run method executed.");
		}
	}
}
