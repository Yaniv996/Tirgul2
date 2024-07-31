
public class SharedData {
    
    private int[] array;
    private boolean[] winArray;
    private boolean flag;
    private final int b;
    private String winningThread;


    /**
     * Constructs a SharedData object with the specified array and integer value b.
     * 
     * @param array the array of integers
     * @param b the integer value
     */
    public SharedData(int[] array, int b) {
        this.array = array;
        this.b = b;
    }

    /**
     * Returns the boolean array indicating the winning conditions.
     * 
     * @return the boolean array indicating the winning conditions
     */
    public boolean[] getWinArray() {
        return winArray;
    }

    /**
     * Sets the boolean array indicating the winning conditions.
     * 
     * @param winArray the boolean array to set
     */
    public void setWinArray(boolean[] winArray) {
        this.winArray = winArray;
    }

    /**
     * Returns the array of integers.
     * 
     * @return the array of integers
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Returns the constant integer value b.
     * 
     * @return the integer value b
     */
    public int getB() {
        return b;
    }

    /**
     * Returns the flag indicating some condition.
     * 
     * @return the flag
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * Sets the flag indicating some condition.
     * 
     * @param flag the flag to set
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    /**
     * Returns the name of the thread that found the solution.
     * 
     * @return the name of the winning thread
     */
    public String getWinningThread() {
        return winningThread;
    }
    
    /**
     * Sets the name of the thread that found the solution.
     * 
     * @param winningThread the name of the winning thread to set
     */
    public void setWinningThread(String winningThread) {
        this.winningThread = winningThread;
    }
}
