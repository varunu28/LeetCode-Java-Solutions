class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        int i = 0;
        int j = 0;
        int top = 0;
        int bottom = n;
        int left = 0;
        int right = n;
        int dir = 0;
        int count = 1;
        int limit = n*n;

        while (count <= limit) {
            if (dir == 0) {
                while (j < right) {
                    matrix[i][j++] = count;
                    count++;
                }
                dir++;
                right--;
                i++;
                j--;
            }
            else if (dir == 1) {
                while (i < bottom) {
                    matrix[i++][j] = count;
                    count++;
                }
                dir++;
                bottom--;
                i--;
                j--;
            }
            else if (dir == 2) {
                while (j >= left) {
                    matrix[i][j--] = count;
                    count++;
                }
                dir++;
                i--;
                j++;
                left++;
            }
            else if (dir == 3) {
                while (i > top) {
                    matrix[i--][j] = count;
                    count++;
                }
                dir = 0;
                top++;
                i++;
                j++;
            }
        }

        return matrix;
    }
}
