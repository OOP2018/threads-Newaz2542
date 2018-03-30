/**
 * use Synchronized to lock thread
 * @author Vichakorn
 *
 */
public class SynchronousCounter extends Counter {
	
	@Override
	public synchronized void add(int amount) {
		total += amount;
	}
}
