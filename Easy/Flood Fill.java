class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            if (sr >= 1) dfs(image, sr-1, sc, color, newColor);
            if (sc >= 1) dfs(image, sr, sc-1, color, newColor);
            if (sr+1 < image.length) dfs(image, sr+1, sc, color, newColor);
            if (sc+1 < image[0].length) dfs(image, sr, sc+1, color, newColor);
        }
    } 
}
