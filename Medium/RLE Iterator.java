class RLEIterator {
    int[] arr;
    int idx;
    int len;
    public RLEIterator(int[] A) {
        arr = A;
        idx = 0;
        len = A.length;
    }
    
    public int next(int n) {
        while (idx < len - 1 && (arr[idx] - n) < 0) {
            n -= arr[idx] > 0 ? arr[idx] : 0;
            updateIdx();
            
            if (idx >= len - 1) {
                return -1;
            }
        }
        
        if (idx < len - 1 && arr[idx] > 0) {
            if (arr[idx] - n >= 0) {
                int temp = arr[idx+1];
                arr[idx] -= n;
                
                return temp;
            }
        }
        
        return -1;
    }
    
    private void updateIdx() {
       idx += 2;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
