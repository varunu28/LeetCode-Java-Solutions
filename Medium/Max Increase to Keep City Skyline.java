class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] top = new int[grid.length];
        int[] left = new int[grid.length];
        int j = 0;

        for (int[] g : grid) {
            int max = Integer.MIN_VALUE;
            for (int i=0; i<g.length; i++) {
                max = Math.max(max, g[i]);
            }

            left[j++] = max;
        }

        j = 0;
        for (int i=0; i<grid.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int k=0; k<grid.length; k++) {
                max = Math.max(grid[k][i], max);
            }

            top[j++] = max;
        }
        
        int increase = 0;

        for (int i=0; i<grid.length; i++) {
            for (int k=0; k<grid[0].length; k++) {
                increase += Math.min(left[i], top[k]) - grid[i][k];
            }
        }
        
        return increase;
    }
}
