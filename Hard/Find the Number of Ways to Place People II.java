class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            int c = o1[0] - o2[0];
            if (c == 0) {
                return o2[1] - o1[1];
            }
            return c;
        });
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int minX = point[0] - 1;
            int maxX = Integer.MAX_VALUE;
            int minY = Integer.MIN_VALUE;
            int maxY = point[1] + 1;
            for (int j = i + 1; j < points.length; j++) {
                int[] nextPoint = points[j];
                if (nextPoint[0] > minX && nextPoint[0] < maxX && nextPoint[1] > minY && nextPoint[1] < maxY) {
                    result++;
                    minX = nextPoint[0];
                    minY = nextPoint[1];
                }
            }
        }
        return result;
    }
}
