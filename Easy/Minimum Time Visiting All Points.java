class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int idx = 0;
        while (idx < points.length - 1) {
            time += calculateTime(points[idx], points[idx + 1]);
            idx++;
        }
        return time;
    }
    
    private static int calculateTime(int[] p1, int[] p2) {
        int x = Math.abs(p1[0] - p2[0]);
        int y = Math.abs(p1[1] - p2[1]);
        return Math.max(x, y);
    }
}
