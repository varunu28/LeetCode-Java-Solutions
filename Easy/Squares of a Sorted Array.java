class Solution {
    public int[] sortedSquares(int[] A) {
        int[] arr = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        int idx = A.length - 1;
        
        while (start <= end) {
            if (Math.abs(A[start]) < Math.abs(A[end])) {
                arr[idx--] = A[end] * A[end];
                end--;
            }
            else {
                arr[idx--] = A[start] * A[start];
                start++;
            }
        }
        
        return arr;
    }
}
