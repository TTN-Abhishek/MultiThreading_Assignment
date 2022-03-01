package question2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class que2 {
	public static void main(final String[] arguments) throws InterruptedException{
		ExecutorService ex = Executors.newSingleThreadExecutor();
	
		try {
			ex.submit(new Task());
			System.out.println("Shutdown Executor");
			ex.shutdown();
			ex.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch(InterruptedException e){
			System.out.println("Interruption Caused");
		}
		finally {
			if(!ex.isTerminated()) {
				System.out.println("End all in-complete tasks");
			}
			ex.shutdownNow();
			System.out.println("Shut-Down Executed");
		}
	}
	
	static class Task implements Runnable{
		public void run() {
			try {
				Long duration = (long) (Math.random()* 10);
				System.out.println("Task in Running mode");
				TimeUnit.SECONDS.sleep(duration);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}