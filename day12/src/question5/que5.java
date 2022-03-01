package question5;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class que5 {
	Lock lock_1 = new ReentrantLock(true);
	Lock lock_2 = new ReentrantLock(true);
	public void aquireLock(Lock lock_1, Lock lock_2) {
		boolean L1 = lock_1.tryLock();
		boolean L2 = lock_2.tryLock();
		
		if(L1 && L2) {
			return;
		}
		if(L1) {
			lock_1.unlock();
		}
		if(L2) {
			lock_2.unlock();
		}
	}
	public void worker_1() {
		aquireLock(lock_1, lock_2);
		System.out.println("Lock 1 - Worker 1");
		System.out.println("Lock 2 - Worker 2\n");
		lock_2.unlock();
		lock_1.unlock();
	}
	public void worker_2() {
		aquireLock(lock_1, lock_2);
		System.out.println("Lock 1 - Worker 1");
		System.out.println("Lock 2 - Worker 2\n");
		lock_1.unlock();
		lock_2.unlock();
	}
	public static void main(String[] args) {
		que5 temp = new que5();
		Thread t1 = new Thread (new Runnable() {
			@Override
			public void run() {
				temp.worker_1();
			}
		});
		Thread t2 = new Thread (new Runnable() {
			@Override
			public void run() {
				temp.worker_2();
			}
		});
		t1.start();
		t2.start();
//		t1.join();
//		t2.join();
	}
}
