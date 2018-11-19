class Solution {
    public boolean validMountainArray(int[] A) {
        int i = 0;
        int j = A.length - 1;
        int n = A.length - 1;
        while (i + 1 < n && A[i] < A[i+1]) {
            i++;
        }
        
        while (j > 0 && A[j] < A[j-1]) {
            j--;
        }
        
        return i > 0 && i == j && j < n;
    }
}
