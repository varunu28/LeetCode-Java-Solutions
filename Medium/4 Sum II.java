class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new  HashMap<>();
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        
        int ans = 0;
        
        for (int i=0; i<C.length; i++) {
            for (int j=0; j<D.length; j++) {
                ans += map.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        
        return ans;
    }
}
