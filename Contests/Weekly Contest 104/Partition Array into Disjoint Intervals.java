class Solution {
    public static int partitionDisjoint(int[] A) {
        int[] min = new int[A.length];
        int minVal = Integer.MAX_VALUE;

        for (int i=A.length-1; i>=0; i--) {
            minVal = Math.min(minVal, A[i]);
            min[i] = minVal;
        }

        int[] max = new int[A.length];
        int maxVal = Integer.MIN_VALUE;

        for (int i=0; i<A.length; i++) {
            maxVal = Math.max(maxVal, A[i]);
            max[i] = maxVal;

            if (i < A.length-1 && max[i] <= min[i+1]) {
                return i + 1;
            }
        }

        return A.length;
    }
}
