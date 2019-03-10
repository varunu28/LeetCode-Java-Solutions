class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] aCount = new int[7];
        int[] bCount = new int[7];
        int[] sameCount = new int[7];
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                sameCount[A[i]]++;
            }
            else {
                aCount[A[i]]++;
                bCount[B[i]]++;
            }
        }
        
        for (int i = 1; i <= 6; i++) {
            if (aCount[i] + bCount[i] + sameCount[i] == A.length) {
                return sameCount[i] == A.length ? 0 : Math.min(aCount[i], bCount[i]);
            }
        }
        
        return -1;
    }
}
