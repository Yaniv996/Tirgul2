public class ThreadCheckArray implements Runnable 
{
	private boolean flag;
	private boolean [] winArray;
	SharedData sd;
	int[] array;
	int b;
	private long startTime;
    private long endTime;
	
	public ThreadCheckArray(SharedData sd) 
	{
		this.sd = sd;	
		synchronized (sd) 
		{
			array = sd.getArray();
			b = sd.getB();
		}		
		winArray = new boolean[array.length];
		startTime = 0; //CHANGE
        endTime = 0; //CHANGE
	}
	
	void rec(int n, int b)
	{
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		if (n == 1)
		{
			if(b == 0 || b == array[n-1])
			{
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}			
			}
			if (b == array[n-1])
				winArray[n-1] = true;
			return;
		}
		
		rec(n-1, b - array[n-1]);
		if (flag)
			winArray[n-1] = true;
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		rec(n-1, b);
	}
	
	/**
	 * The method begins the run of both threads.
	 */
	public void run() {
		
		startTime = System.nanoTime(); //CHANGE: Record start time
		
		if (array.length != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				rec(array.length-1, b - array[array.length - 1]);
			else 
				rec(array.length-1, b);
		if (array.length == 1)
			if (b == array[0] && !flag)
			{
				winArray[0] = true;
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}
			}
		if (flag)
		{
			if (Thread.currentThread().getName().equals("thread1"))
				winArray[array.length - 1] = true;
			synchronized (sd) 
			{
				sd.setWinArray(winArray);
			}	
		}
		endTime = System.nanoTime(); // Record end time
		if (flag) {
            synchronized (sd) {
                if (sd.getWinningThread() == null) {
                    sd.setWinningThread(Thread.currentThread().getName());
                }
            }
        }
	}
	
	/**
	 * USER 1 CHANGE: 
	 * The methods calculates the total runtime of a thread and returns it.
	 * @return the runtime of the thread.
	 */
	public long getRuntime() {
        return endTime - startTime;
	}
	
	//////////////////////CHANGEEEEEEEEEEEEE////////////////////////////
}
