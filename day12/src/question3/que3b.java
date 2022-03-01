package question3;

class process {
	synchronized public void getLine() {
		for(int i=0; i<4; i++) {
			System.out.println(i);
			try {
				Thread.sleep(600);
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class Train extends Thread {
	
	process pro;

	Train(process pro){
		this.pro = pro;
	}
	
	@Override
	public void run() {
		pro.getLine();
	}
}

class que3b{
	public static void main(String[] args) {
		process obj = new process();
		
		Train train1 = new Train(obj);
		Train train2 = new Train(obj);
		
		train1.start();
		train2.start();
	}
}
