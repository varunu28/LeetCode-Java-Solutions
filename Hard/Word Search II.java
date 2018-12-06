class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int row = board.length;
        int col = board[0].length;

        Set<String> set = new HashSet<>();
        
        for (String word : words) {
            boolean[][] visited = new boolean[row][col];
            for (int i=0; i<row; i++) {
                for (int j=0; j<col; j++) {
                    if (dfs(board, i, j, word, 0, row, col, visited, dirs)) {
                        set.add(word);
                    }
                }
            }   
        }
        
        return new ArrayList<>(set);
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int start, int row, int col, boolean[][] visited, int[][] dirs) {
        if (board[i][j] != word.charAt(start)) {
            return false;
        }

        if (start + 1 == word.length()) {
            return true;
        }

        visited[i][j] = true;
        
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y]) {
                continue;
            }

            if (dfs(board, x, y, word, start + 1, row, col, visited, dirs)) {
                return true;
            }
        }

        visited[i][j] = false;

        return false;
    }
}
