class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        TreeSet<Integer> set = new TreeSet<>();
        int maxSum = -1;
        
        for (int i = 0; i < A.length; i++) {
            int diff = K - A[i];
            if (diff > 0) {
                Integer second = set.lower(diff);
                if (second != null) {
                    maxSum = Math.max(maxSum, A[i] + second);
                }
            }
            
            set.add(A[i]);
        }

        return maxSum;
    }
}
