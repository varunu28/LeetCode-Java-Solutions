class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int maxLength = 0;
            for (int j = 0; j < grid.length; j++) {
                maxLength = Math.max(maxLength, String.valueOf(grid[j][i]).length());
            }
            result[i] = maxLength;
        }
        return result;
    }
}
