class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int i = 0;
        int j = 0;
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        int dir = 0;
        int count = 0;
        int limit = matrix.length * matrix[0].length;

        while (count < limit) {
            if (dir == 0) {
                while (j < right) {
                    list.add(matrix[i][j++]);
                    count++;
                }
                dir++;
                right--;
                i++;
                j--;
            }
            else if (dir == 1) {
                while (i < bottom) {
                    list.add(matrix[i++][j]);
                    count++;
                }
                dir++;
                bottom--;
                i--;
                j--;
            }
            else if (dir == 2) {
                while (j >= left) {
                    list.add(matrix[i][j--]);
                    count++;
                }
                dir++;
                i--;
                j++;
                left++;
            }
            else if (dir == 3) {
                while (i > top) {
                    list.add(matrix[i--][j]);
                    count++;
                }
                dir = 0;
                top++;
                i++;
                j++;
            }
        }

        return list;
    }
}
