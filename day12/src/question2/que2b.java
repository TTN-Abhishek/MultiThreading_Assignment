package question2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class que2b {
	public static void main(final String[] args) throws InterruptedException {
		ThreadFactory ThreadFactory = Executors.defaultThreadFactory();
		ExecutorService exe = Executors.newCachedThreadPool(ThreadFactory);
		ThreadPoolExecutor mypool = (ThreadPoolExecutor) exe;
		System.out.println("My pool Size: " + mypool.getPoolSize());
		for(int i=0; i<=4; i++) {
			exe.submit(new Threadimpl());
		}
		exe.shutdown();
	}
	
	static class Threadimpl implements Runnable{
		public void run() {
			try {
				Long num = (long) (Math.random()/30);
				System.out.println("Thread Name: " +Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(num);
				System.out.println("after sleep Tread Name: " +Thread.currentThread().getName());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
