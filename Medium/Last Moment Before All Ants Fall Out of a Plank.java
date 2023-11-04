class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int result = 0;
        for (int num : left) {
            result = Math.max(result, num);
        }
        for (int num : right) {
            result = Math.max(result, n - num);
        }
        return result;
    }
}
