class Solution {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    traverse(land, i, j, visited, result);
                }
            }
        }
        return result.stream()
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    private static void traverse(int[][] land, int i, int j, boolean[][] visited, List<int[]> result) {
        int rows = land.length;
        int cols = land[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] leftMost = {i, j};
        int[] rightMost = {i, j};
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            int x = removed[0];
            int y = removed[1];
            leftMost[0] = Math.min(leftMost[0], x);
            leftMost[1] = Math.min(leftMost[1], y);
            rightMost[0] = Math.max(rightMost[0], x);
            rightMost[1] = Math.max(rightMost[1], y);
            for (int[] dir : DIRS) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && !visited[newX][newY] && land[newX][newY] == 1) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        result.add(new int[]{leftMost[0], leftMost[1], rightMost[0], rightMost[1]});
    }
}
