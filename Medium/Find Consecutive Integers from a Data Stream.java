class DataStream {
    
    private int k;
    private int value;
    private int counter;

    public DataStream(int value, int k) {
        this.k = k;
        this.value = value;
        this.counter = 0;
    }
    
    public boolean consec(int num) {
        counter = value == num ? (counter + 1) : 0;
        return counter >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
