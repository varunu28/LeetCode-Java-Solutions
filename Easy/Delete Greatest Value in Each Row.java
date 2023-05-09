class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] g : grid) {
            Arrays.sort(g);
        }
        int result = 0;
        for (int i = grid[0].length - 1; i >= 0; i--) {
            int maxValue = Integer.MIN_VALUE;
            for (int[] g : grid) {
                maxValue = Math.max(maxValue, g[i]);
            }
            result += maxValue;
        }
        return result;
    }
}
