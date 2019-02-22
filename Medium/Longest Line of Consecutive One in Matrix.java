class Solution {
    public int longestLine(int[][] M) {
        List<List<Integer>> points = new ArrayList<>();
        for (int i=0; i<M.length; i++) {
            for (int j=0; j<M[i].length; j++) {
                if (M[i][j] == 1) {
                    points.add(Arrays.asList(i, j));
                }
            }
        }
        
        int max = 0;
        
        for (List<Integer> point : points) {
            int rowCount = rowLength(M, point.get(0), point.get(1), M[0].length);
            int colCount = colLength(M, point.get(0), point.get(1), M.length);
            int firstDiagonalCount = firstDiagnol(M, point.get(0), point.get(1), M.length, M[0].length);
            int secondDiagonalCount = secondDiagnol(M, point.get(0), point.get(1), M.length, M[0].length);
            
            int maxOnes = Math.max(Math.max(rowCount, colCount), Math.max(firstDiagonalCount, secondDiagonalCount));
            
            max = Math.max(max, maxOnes);
        }
        
        return max;
    }
    
    private int rowLength(int[][] M, int row, int col, int size) {
        int count = 1;
        int leftIdx = col - 1;
        int rightIdx = col + 1;
        
        while (leftIdx >= 0) {
            if (M[row][leftIdx] != 1) {
                break;
            }
            
            leftIdx--;
            count++;
        }
        
        while (rightIdx < size) {
            if (M[row][rightIdx] != 1) {
                break;
            }
            
            rightIdx++;
            count++;
        }
        
        return count;
    }
    
    private int colLength(int[][] M, int row, int col, int size) {
        int count = 1;
        int leftIdx = row - 1;
        int rightIdx = row + 1;
        
        while (leftIdx >= 0) {
            if (M[leftIdx][col] != 1) {
                break;
            }
            
            leftIdx--;
            count++;
        }
        
        while (rightIdx < size) {
            if (M[rightIdx][col] != 1) {
                break;
            }
            
            rightIdx++;
            count++;
        }
        
        return count;
    }
    
    private int firstDiagnol(int[][] M, int row, int col, int rows, int cols) {
        int count = 1;
        int rightRowIdx = row - 1;
        int rightColIdx = col - 1;
        int downRowIdx = row + 1;
        int downColIdx = col + 1;
        
        while (rightRowIdx >= 0 && rightColIdx >= 0) {
            if (M[rightRowIdx][rightColIdx] != 1) {
                break;
            }
            
            rightRowIdx--;
            rightColIdx--;
            count++;
        }
        
        while (downRowIdx < rows && downColIdx < cols) {
            if (M[downRowIdx][downColIdx] != 1) {
                break;
            }
            
            downRowIdx++;
            downColIdx++;
            count++;
        }
        
        return count;
    }
    
    private int secondDiagnol(int[][] M, int row, int col, int rows, int cols) {
        int count = 1;
        int rightRowIdx = row - 1;
        int rightColIdx = col + 1;
        int leftRowIdx = row + 1;
        int leftColIdx = col - 1;
        
        while (rightRowIdx >= 0 && rightColIdx < cols) {
            if (M[rightRowIdx][rightColIdx] != 1) {
                break;
            }
            
            rightRowIdx--;
            rightColIdx++;
            count++;
        }
        
        while (leftRowIdx < rows && leftColIdx >= 0) {
            if (M[leftRowIdx][leftColIdx] != 1) {
                break;
            }
            
            leftRowIdx++;
            leftColIdx--;
            count++;
        }
        
        return count;
    }
}
