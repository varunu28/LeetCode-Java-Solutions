class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        
        for (int i=0; i<A.length - 1; i++) {
            if (i > 0 && Check(A, i)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean Check(int[] arr, int idx) {
        for (int i=0; i<idx; i++) {
            if (arr[i] >= arr[i+1]) {
                return false;
            }
        }
        
        for (int i=idx; i<arr.length-1; i++) {
            if (arr[i] <= arr[i+1]) {
                return false;
            }
        }
        
        return true;
    }
}
