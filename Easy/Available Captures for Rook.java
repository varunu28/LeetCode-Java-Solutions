class Solution {
    public int numRookCaptures(char[][] board) {
        int numOfPawns = 0;
        
        int[] rookPos = getRookPos(board);
        int row = rookPos[0];
        int col = rookPos[1];
        
        for (int i = col + 1; i < board[0].length; i++) {
            if (board[row][i] == '.') {
                continue;
            }
            
            if (board[row][i] == 'B') {
                break;
            }
            
            if (board[row][i] == 'p') {
                numOfPawns++;
                break;
            }
        }
        
        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] == '.') {
                continue;
            }
            
            if (board[row][i] == 'B') {
                break;
            }
            
            if (board[row][i] == 'p') {
                numOfPawns++;
                break;
            }
        }
        
        for (int i = row + 1; i < board.length; i++) {
            if (board[i][col] == '.') {
                continue;
            }
            
            if (board[i][col] == 'B') {
                break;
            }
            
            if (board[i][col] == 'p') {
                numOfPawns++;
                break;
            }
        }
        
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == '.') {
                continue;
            }
            
            if (board[i][col] == 'B') {
                break;
            }
            
            if (board[i][col] == 'p') {
                numOfPawns++;
                break;
            }
        }
        
        return numOfPawns;
    }
    
    private int[] getRookPos(char[][] board) {
        int[] pos = new int[2];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        
        return pos;
    }
}
