class Solution {

    private static final int[][] DIRECTIONS = {
        {1, 3},
        {0, 2, 4},
        {1, 5},
        {0, 4},
        {3, 5, 1},
        {4, 2}
    };

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        Map<String, Integer> visited = new HashMap<>();
        dfs(sb.toString(), visited, sb.indexOf("0"), 0);
        return visited.getOrDefault("123450", -1);
    }

    private void dfs(String state, Map<String, Integer> visited, int zeroIdx, int moves) {
        if (visited.containsKey(state) && visited.get(state) <= moves) {
            return;
        } 
        visited.put(state, moves);
        for (int next : DIRECTIONS[zeroIdx]) {
            String newState = swap(state, zeroIdx, next);
            dfs(newState, visited, next, moves + 1);
        }
    }

    private String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        return sb.toString();
    }
}
