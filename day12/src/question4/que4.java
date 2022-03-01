package question4;

import java.util.Random;
import java.util.concurrent.Callable;

class que4 implements Callable{
	public static void main(String args[]) {
		Random generator = new Random();
		
		Integer random_no = generator.nextInt(5);
		try {
			Thread.sleep(random_no * 100);
			System.out.println("Random output");
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("temp");
		}
		return;
	}
	
	@Override
	public Object call() throws Exception {
		return "xyz";
	}
}
