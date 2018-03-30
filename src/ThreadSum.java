/**
 * ThreadSum is testing the threads safe in 3 ways
 * @author Vichakorn
 *
 */
public class ThreadSum {
	public static void main(String[] arg) {
		final int LIMIT = 10000000;
		Counter counter = new AtomicCounter();
		
		runThreads(counter,LIMIT);
	}
	/**
	 * run threads to show the result.
	 * @param counter
	 * @param limit
	 */
	public static void runThreads(Counter counter, int limit) {
		AddTask addtask = new AddTask(counter,limit);
		SubtractTask subtask = new SubtractTask(counter,limit);
		
		Thread thread1 = new Thread(addtask);
		Thread thread2 = new Thread(subtask);
		
		System.out.println("Starting threads");
		long startTime = System.nanoTime();
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		}
		catch(InterruptedException e) {
			System.out.println("Threads interrupted");
		}
		double elapsed = 1.0E-9*(System.nanoTime()-startTime);
		System.out.printf("Count 1 to % ,d in %.6f sec \n", limit,elapsed);
		
		System.out.printf("Counter total is %d\n", counter.get());
	}
	
}
