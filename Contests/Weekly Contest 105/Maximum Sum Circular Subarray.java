class Solution {
    public static  int maxSubarraySumCircular(int[] A) {
        int max = kadane(A);
        int wrap = 0;
        
        for(int i=0; i < A.length; i++) {
            wrap = wrap+A[i];
            A[i] *= -1;
        }
        
        wrap = wrap + kadane(A);
        
        return Math.abs(wrap) < Math.abs(max) ? max : wrap;
    }


    private static int kadane(int[] a){
        int maxSoFar=a[0];
        int maxGlobal =a[0];
        
        for(int i=1; i<a.length; i++) {
            maxSoFar = Math.max(a[i], maxSoFar + a[i]);
            maxGlobal =Math.max(maxGlobal, maxSoFar);
        }
        
        return maxGlobal;
    }
}
