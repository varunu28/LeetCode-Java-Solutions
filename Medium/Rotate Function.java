class Solution {
    public int maxRotateFunction(int[] A) {
        
        if (A.length == 0) return 0;
        int maxVal = Integer.MIN_VALUE;
        
        int c = 1;
        
        while (c <= A.length) {
            int temp = 0;
            for (int i=0;i<A.length;i++) {
                temp += i*A[i];
            }

            maxVal = Math.max(maxVal, temp);

            rotateArr(A);
            c++;
        }
        
        return maxVal;
    }
    
    public void rotateArr(int[] arr) {
        int last = arr[arr.length-1];
        for (int i = arr.length-1;i>0;i--) {
            arr[i] = arr[i-1];
        }
        
        arr[0] = last;
    }
}
