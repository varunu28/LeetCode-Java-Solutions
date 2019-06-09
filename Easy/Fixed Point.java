class Solution {
    public int fixedPoint(int[] A) {
        int low = 0;
        int high = A.length - 1;
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] - mid < 0) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        return low == A[low] ? low : -1;
    }
}
