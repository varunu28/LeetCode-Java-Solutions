class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int p = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 1) {
                    if (i-1 >= 0) {
                        if (grid[i-1][j] == 0) {
                            p++;
                        }
                    }
                    else {
                        p++;
                    }
                    if (i+1 < n) {
                        if (grid[i+1][j] == 0) {
                            p++;
                        }
                    }
                    else {
                        p++;
                    }
                    if (j-1 >= 0) {
                        if (grid[i][j-1] == 0) {
                            p++;
                        }
                    }
                    else {
                        p++;
                    }
                    if (j+1 < m) {
                        if (grid[i][j+1] == 0) {
                            p++;
                        }
                    }
                    else {
                        p++;
                    }
                }
            }
        }
        return p;
    }
}
