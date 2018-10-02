class Solution {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] start = points[0];
        int count = 1;

        for (int i=1; i<points.length; i++) {
            if (points[i][0] <= start[1]) {
                start[1] = Math.min(start[1], points[i][1]);
                continue;
            }
            else {
                count++;
                start = points[i];
            }
        }

        return count;
    }
}
