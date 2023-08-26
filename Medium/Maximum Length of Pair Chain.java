class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int curr = Integer.MIN_VALUE;
        int result = 0;
        for (int[] pair : pairs) {
            if (pair[0] > curr) {
                result++;
                curr = pair[1];
            }
        }
        return result;
    }
}
