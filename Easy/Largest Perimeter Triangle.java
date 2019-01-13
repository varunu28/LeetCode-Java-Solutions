class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        
        for (int i=n-1; i>1; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        
        return 0;
    }
}
