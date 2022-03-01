package question2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;

public class que2c {
	public static void main(final String[] args) throws InterruptedException {
		ExecutorService exe = Executors.newFixedThreadPool(5);
		ThreadPoolExecutor my_pool = (ThreadPoolExecutor) exe;
		System.out.println("Size of my_pool: " + my_pool.getPoolSize());
		exe.submit(new Threadimpl());
		exe.shutdown();
	}
	
	static class Threadimpl implements Runnable {
		public void run() {
			try {
				Long no = (long) (Math.random() * 40);
				System.out.println("Thread Name - " + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(no);
				System.out.println("Thread Name after sleep - " +Thread.currentThread().getName());
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
