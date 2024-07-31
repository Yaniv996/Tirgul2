public class ThreadCheckArray implements Runnable 
{
	private boolean flag;
	private boolean [] winArray;
	SharedData sd;
	int[] array;
	int b;
	
	 /**
     * Constructor for ThreadCheckArray.
     * 
     * @param sd the shared data object
     */
	public ThreadCheckArray(SharedData sd) 
	{
		this.sd = sd;	
		synchronized (sd) 
		{
			array = sd.getArray();
			b = sd.getB();
		}		
		winArray = new boolean[array.length];
	}
	
	/**
     * Recursively checks if there is a subset of the array that sums to the given number.
     * 
     * @param n the current index in the array
     * @param b the remaining sum to check
     */
	
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
					// sd.setFlag(true);orignal
					if (!sd.getFlag()) {
                        sd.setFlag(true);
                        sd.setWinningThread(Thread.currentThread().getName());
					}
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
     * Runs the thread, checking for the subset sum.
     */
	public void run() {
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
					//sd.setFlag(true);
					 if (!sd.getFlag()) {
	                        sd.setFlag(true);
	                        sd.setWinningThread(Thread.currentThread().getName());
	                    }
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
	}
}
