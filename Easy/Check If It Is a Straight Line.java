class Solution {    
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaY = getYDiff(coordinates[1], coordinates[0]);
        int deltaX = getXDiff(coordinates[1], coordinates[0]);
        for (int i = 2; i < coordinates.length; i++) {
            if (deltaY * getXDiff(coordinates[i], coordinates[0]) != deltaX * getYDiff(coordinates[i], coordinates[0])) {
                return false;
            }
        }
        return true;
    }
    
    private int getYDiff(int[] a, int[] b) {
        return a[1] - b[1];
    }

    private int getXDiff(int[] a, int[] b) {
        return a[0] - b[0];
    }

}
