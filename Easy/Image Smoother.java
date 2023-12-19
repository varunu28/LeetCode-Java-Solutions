class Solution {

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};

    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double sum = img[i][j];
                int count = 1;
                for (int[] dir : DIRS) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cols) {
                        sum += img[row][col];
                        count++;
                    }
                }
                double smoothImage = sum / count;
                result[i][j] = (int) smoothImage;
            }
        }
        return result;
    }
}
