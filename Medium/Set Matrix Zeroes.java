class Solution {
    public void setZeroes(int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) {
            return;
        }


        int numOfRows = arr.length;
        int numOfCols = arr[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < numOfCols; i++) {
            if (arr[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < numOfRows; i++) {
            if (arr[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                if (arr[i][j] == 0) {
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < numOfRows; i++) {
            if (arr[i][0] == 0) {
                for (int j = 1; j < numOfCols; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < numOfCols; i++) {
            if (arr[0][i] == 0) {
                for (int j = 1; j < numOfRows; j++) {
                    arr[j][i] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int i = 0; i < numOfCols; i++) {
                arr[0][i] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < numOfRows; i++) {
                arr[i][0] = 0;
            }
        }
    }
}
