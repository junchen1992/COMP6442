package q2_v2;

public class Counter {
	private int counter = 0;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Counter(int counter) {
		super();
		this.counter = counter;
	}
	
	public void inc() {
		counter ++;
	}
	
	public void reset() {
		counter = 0;
	}
}
