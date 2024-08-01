public class SharedData 
{
	private int [] array;
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	private String winningThread; //CHANGE
	
	/**
	 * Constructor of SharedData
	 * @param array - array of numbers
	 * @param b - Sum to find.
	 */
	public SharedData(int[] array, int b) {
		
		this.array = array;
		this.b = b;
	}
	
	/**
	 * 
	 * @return the array of the solution.
	 */
	public boolean[] getWinArray() 
	{
		return winArray;
	}
	
	/**
	 * Sets the solution array into SharedData.
	 * @param winArray - the solution array to set.
	 */
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}
	
	/**
	 * 
	 * @return the input array from the user.
	 */
	public int[] getArray() 
	{
		return array;
	}
	
	/**
	 * @return the sum that the user asked to find.
	 */
	public int getB() 
	{
		return b;
	}
	
	/**
	 * 
	 * @return the flag's  boolean value.
	 */
	public boolean getFlag() 
	{
		return flag;
	}
	
	/**
	 * Sets the boolean value of the flag
	 * @param flag -> boolean value to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	/**
	 * 
	 * @return the thread that found the solution first.
	 */
	public String getWinningThread() 
    {
        return winningThread;
    }
	
	/**
	 * Saved the winning thread.
	 * @param winningThread 
	 */
	public void setWinningThread(String winningThread) 
    {
        this.winningThread = winningThread;
    }

}
