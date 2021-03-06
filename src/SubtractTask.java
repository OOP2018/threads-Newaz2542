/**
 * subtract value and save to count.
 * @author Vichakorn
 *
 */
public class SubtractTask implements Runnable{
	private Counter counter;
	private int limit;
	
	public SubtractTask(Counter counter,int limit) {
		this.counter = counter;
		this.limit = limit;
	}
	/**
	 * add subtract that k <= limit.
	 */
	public void run() {
		for(int k=1; k <= limit; k++) {
			counter.add(-k);
		}
		System.out.println("Done "+Thread.currentThread().getName());
	}
}
