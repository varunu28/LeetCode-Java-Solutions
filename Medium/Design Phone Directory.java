class PhoneDirectory {

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    int[] directory;
    int pos;
    public PhoneDirectory(int maxNumbers) {
        directory = new int[maxNumbers];
        for (int i=0; i<maxNumbers; i++) {
            directory[i] = (i+1)%maxNumbers;
        }
        pos = 0;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (directory[pos] == -1) {
            return -1;
        }

        int val = pos;
        pos = directory[pos];
        directory[val] = -1;
        return val;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return directory[number] != -1;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (directory[number] != -1) {
            return;
        }
        directory[number] = pos;
        pos = number;
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
