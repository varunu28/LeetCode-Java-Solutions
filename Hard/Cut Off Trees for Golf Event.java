class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        int[] rowMovement = {-1, 1, 0, 0};
        int[] colMovement = {0, 0, -1, 1};
        
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
        
        int totalDist = 0;
        int startRow = 0;
        int startCol = 0;
        
        for (int[] tree : trees) {
            int dist = getDistance(forest, startRow, startCol, tree[1], tree[2]);
            if (dist < 0) {
                return -1;
            }

            totalDist += dist;
            startRow = tree[1];
            startCol = tree[2];
        }
        
        return totalDist;
    }
    
    private int getDistance(List<List<Integer>> forest, int startRow, int startCol, int desRow, int desCol) {
        if(startRow == desRow && startCol == desCol) {
            return 0;
        }
        
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        int[][] visited = new int[forest.size()][forest.get(0).size()];
        visited[startRow][startCol] = 1;
        
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            steps++;
            
            while(queueSize-- > 0) {
                int[] cur = queue.poll();
                int currRow = cur[0];
                int currCol = cur[1];
                
                for(int k = 0; k < 4; k++) {
                    int x = currRow + dir[k][0];
                    int y = currCol + dir[k][1];
                    if(x >= 0 && x < forest.size() && y >= 0 && y < forest.get(0).size() && forest.get(x).get(y) > 0 && visited[x][y] == 0) {
                        if(x == desRow && y == desCol) {
                            return steps;
                        }
                        visited[x][y] = 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        
        return -1;
    }
}
