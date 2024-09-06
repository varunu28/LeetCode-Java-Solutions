class Solution {

    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int tag = 2;
        int result = 0;
        Map<Integer, Integer> tagToAreaMapping = new HashMap<>();
        // Calculate area without changing 0 to 1 & tag each island for future reference
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    tagToAreaMapping.put(tag, dfs(grid, i, j, tag));
                    result = Math.max(result, tagToAreaMapping.get(tag));
                    tag++;
                }
            }
        }
        // Now start changing each 0 to 1 & add the area of all connected islands by referencing their tags
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> visited = new HashSet<>();
                    int currArea = 1;
                    List<int[]> moves = getMoves(i, j, n);
                    for (int[] move : moves) {
                        int x = move[0];
                        int y = move[1];
                        int currTag = grid[x][y];
                        if (currTag > 1 && visited.add(currTag)) {
                            currArea += tagToAreaMapping.get(currTag);
                        }
                    }
                    result = Math.max(result, currArea);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int x, int y, int tag) {
        int area = 1;
        int n = grid.length;
        grid[x][y] = tag;
        List<int[]> moves = getMoves(x, y, n);
        for (int[] move : moves) {
            int i = move[0];
            int j = move[1];
            if (grid[i][j] == 1) {
                area += dfs(grid, i, j, tag);
            }
        }
        return area;
    }

    private List<int[]> getMoves(int x, int y, int n) {
        List<int[]> moves = new ArrayList<>();
        for (int[] dir : DIRS) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                moves.add(new int[]{newX, newY});
            }
        }
        return moves;
    }
}
