class Solution {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    // We begin with boundary & push smallest height on top of priority queue.
    // Then when the internal cell is used it is already using min of max height
    // So we calculate height correctly by substracting the internal cell from min of all max height of its boundaries
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    pq.add(new int[]{heightMap[i][j], i, j});
                    heightMap[i][j] = -1;
                }
            }
        }
        int result = 0;
        int maxHeight = 0;
        while (!pq.isEmpty()) {
            int[] removed = pq.remove();
            maxHeight = Math.max(maxHeight, removed[0]);
            result += maxHeight - removed[0];
            for (int[] dir : DIRS) {
                int newX = removed[1] + dir[0];
                int newY = removed[2] + dir[1];
                if (newX < 0 || newY < 0 || newX >= rows || newY >= cols || heightMap[newX][newY] == -1) {
                    continue;
                }
                pq.add(new int[]{heightMap[newX][newY], newX, newY});
                heightMap[newX][newY] = -1;
            }
        }
        return result;
    }
}
