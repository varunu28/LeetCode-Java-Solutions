class Solution {
    int[] rowCount;
    int[] colCount;
    int[] diagCount;
    public String tictactoe(int[][] moves) {
        rowCount = new int[3];
        colCount = new int[3];
        diagCount = new int[2];
        int numOfMoves = 0;
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            int move = i % 2 == 0 ? 1 : -1;
            updateBoard(x, y, move);
            numOfMoves++;
            if (checkForWinner(x, y)) {
                return i % 2 == 0 ? "A" : "B";
            }
        }
        return numOfMoves == 9 ? "Draw" : "Pending";
    }
    
    private boolean checkForWinner(int x, int y) {
        if (rowCount[x] == 3 || rowCount[x] == -3) {
            return true;
        }
        if (colCount[y] == 3 || colCount[y] == -3) {
            return true;
        }
        if (x == y && (diagCount[0] == 3 || diagCount[0] == -3)) {
            return true;
        }
        if (x + y == 2 && (diagCount[1] == 3 || diagCount[1] == -3)) {
            return true;
        }
        return false;
    }
    
    private void updateBoard(int x, int y, int move) {
        rowCount[x] += move;
        colCount[y] += move;
        if (x == y) {
            diagCount[0] += move;
        }
        if (x + y == 2) {
            diagCount[1] += move;
        }
    }
}
