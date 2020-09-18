class Solution {
    public int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] image, int x, int y, int newColor, int oldColor) {
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] == newColor) {
            return;
        }
        
        if (image[x][y] == oldColor) {
            image[x][y] = newColor;
            for (int[] dir : dirs) {
                dfs(image, x + dir[0], y + dir[1], newColor, oldColor);
            }
        }
    }
}
