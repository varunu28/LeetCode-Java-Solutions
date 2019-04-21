class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] points = new int[R * C][2];
        Queue<int[]> queue = new LinkedList<>();
        int idx = 0;
        queue.add(new int[]{r0, c0});
        boolean[][] visited = new boolean[R][C];
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            if (r < 0 || r >= R || c < 0 || c >= C || visited[r][c]) {
                continue;
            }
            
            points[idx++] = curr;
            visited[r][c] = true;
            
            queue.add(new int[]{r, c - 1});
            queue.add(new int[]{r, c + 1});
            queue.add(new int[]{r - 1, c});
            queue.add(new int[]{r + 1, c});
        }
        
        return points;
    }
}
