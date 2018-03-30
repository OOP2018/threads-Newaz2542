import java.util.concurrent.atomic.AtomicLong;
/**
 * use AtomicLong to sum result. 
 * @author Vichakorn
 *
 */
public class AtomicCounter extends Counter {
	private AtomicLong total;
	
	public AtomicCounter() {
		total = new AtomicLong();
	}
	
	public void add(int amount) {
		total.getAndAdd(amount);
	}
}
