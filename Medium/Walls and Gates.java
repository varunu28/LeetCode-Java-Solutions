class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int numRows = rooms.length;
        int numCols = rooms[0].length;
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (rooms[i][j] == 0) {
                    int key = i * numCols + j;
                    queue.add(key);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            int x = removed / numCols;
            int y = removed % numCols;
            
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX < 0 || newX >= numRows || newY < 0 || newY >= numCols || rooms[newX][newY] != 2147483647) {
                    continue;    
                }
                
                rooms[newX][newY] = rooms[x][y] + 1;
                int newKey = newX * numCols + newY;
                queue.add(newKey);
            }
        }
    }
}
