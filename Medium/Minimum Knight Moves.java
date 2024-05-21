class Solution {

    private static final int[][] MOVES = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[607][607];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] removed = queue.remove();
                if (removed[0] == x && removed[1] == y) {
                    return steps;
                }
                for (int[] move : MOVES) {
                    int newX = removed[0] + move[0];
                    int newY = removed[1] + move[1];
                    if (!visited[newX + 302][newY + 302]) {
                        visited[newX + 302][newY + 302] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            steps++;
        }
        return steps;
    }
}
