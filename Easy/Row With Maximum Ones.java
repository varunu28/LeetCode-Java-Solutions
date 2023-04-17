class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes = 0;
        int maxOnesRow = 0;
        for (int i = 0; i < mat.length; i++) {
            int oneCount = 0;
            for (int num : mat[i]) {
                oneCount += num == 1 ? 1 : 0;
            }
            if (oneCount > maxOnes) {
                maxOnes = oneCount;
                maxOnesRow = i;
            }
        }
        return new int[]{maxOnesRow, maxOnes};
    }
}
