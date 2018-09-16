class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) return true;
        boolean pattern = A[A.length-1] > A[0] ? true : false;
        
        for (int i=1; i<A.length; i++) {
            if (A[i] < A[i-1] && pattern == true) {
                return false;
            }
            if (A[i] > A[i-1] && pattern == false) {
                return false;
            }
        }
        return true;
    }
}
