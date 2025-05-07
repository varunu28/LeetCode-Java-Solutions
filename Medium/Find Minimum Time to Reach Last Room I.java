class Solution {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        boolean[][] visited = new boolean[n][m];
        Integer[][] minTime = new Integer[n][m];
        minTime[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] removed = pq.remove();
            int x = removed[0];
            int y = removed[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            for (int[] dir : DIRS) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    int distance = Math.max(minTime[x][y], moveTime[newX][newY]) + 1;
                    int currMinTime = minTime[newX][newY] == null ? Integer.MAX_VALUE : minTime[newX][newY];
                    if (currMinTime > distance) {
                        minTime[newX][newY] = distance;
                        pq.add(new int[]{newX, newY, distance});
                    }
                }
            }
        }
        return minTime[n - 1][m - 1];
    }
}
