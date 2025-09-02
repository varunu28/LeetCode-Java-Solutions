class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] != o2[0]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });
        int n = points.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            int curr = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (points[j][1] >= points[i][1] && curr > points[j][1]) {
                    result++;
                    curr = points[j][1];
                }
            }
        }
        return result;
    }
}
