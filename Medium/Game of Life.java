class Solution {
    public void gameOfLife(int[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                int aliveNeighbours = getLiveCount(board, i, j);
                boolean selfAlive = isAlive(board, i, j);
                if (selfAlive) {
                	if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                		board[i][j] = selfAlive ? 2 : 0;
                	}
                }
                else {
            		if (aliveNeighbours == 3) {
            			board[i][j] = selfAlive ? 1 : 3;
            		}
            	}
            }
        }
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                board[i][j] = board[i][j] == 1 || board[i][j] == 3 ? 1 : 0;
            }
        }
    }

    private boolean isAlive(int[][] board, int row, int col) {
		return row >= 0 && row < board.length && col >= 0 && col < board[0].length && (board[row][col] == 1 || board[row][col] == 2);
    }

    private int getLiveCount(int[][] board, int i, int j) {
        int liveCount = 0;

        int[][] possibleCoordinates = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        for (int[] coordinate : possibleCoordinates) {
        	if (isAlive(board, i + coordinate[0], j + coordinate[1])) {
        		liveCount++;
        	}
        }

        return liveCount;
    }
}
