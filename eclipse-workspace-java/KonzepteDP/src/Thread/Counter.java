package Thread;

public class Counter extends Thread{
	private boolean[] array;
	private int start;
	private int end;
	private int result;
	private int sleepTime;
	
	public Counter(boolean[] array, int start, int end, int sleepTime) {
		this.array = array; 
		this.start = start;
		this.end = end;
		this.result = 0;
		this.sleepTime = sleepTime;
	}

	public int getResult() {
		return result;
	}
	
	public void run() {
		for (int i = start; i <= end; i++) {
			if (array[i]) {
				result++;
			}
			if(sleepTime > 0)
				try {
					Thread.sleep(sleepTime);
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
	}
	
	
}
