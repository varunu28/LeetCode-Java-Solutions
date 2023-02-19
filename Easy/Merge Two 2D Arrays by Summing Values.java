class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] totalSum = new int[1001];
        int count = nums1.length;
        for (int i = 0; i < nums1.length; i++) {
            int id = nums1[i][0];
            int val = nums1[i][1];
            totalSum[id] = val;
        }
        for (int i = 0; i < nums2.length; i++) {
            int id = nums2[i][0];
            int val = nums2[i][1];
            if (totalSum[id] == 0) {
                count++;
            }
            totalSum[id] += val;
        }
        int[][] result = new int[count][2];
        int idx = 0;
        for (int i = 1; i <= 1000; i++) {
            if (totalSum[i] != 0) {
                result[idx++] = new int[]{i, totalSum[i]};
            }
        }
        return result;
    }
}
