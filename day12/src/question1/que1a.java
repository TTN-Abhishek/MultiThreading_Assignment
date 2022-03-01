package question1;

class que1a extends Thread {
	public void run() {
		Thread t1 = Thread.currentThread();
		System.out.println("Current thread - " + t1.getName());
		System.out.println("Is Alive - " + t1.isAlive());
	}
	
	public static void main(String args[]) throws Exception{
		Thread t1 = new Thread(new que1a());
		t1.start();
		
		t1.join(150);
		System.out.println("\nJoining in 150" + " ms: \n");
		System.out.println("Current thread: " + t1.getName());
		System.out.println("Is Alive - ");
	}
	
}
	

