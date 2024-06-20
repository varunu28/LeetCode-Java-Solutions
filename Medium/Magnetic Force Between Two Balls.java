class Solution {
    public int maxDistance(int[] position, int m) {
        int result = 0;
        int n = position.length;
        Arrays.sort(position);
        int left = 1;
        int right = (int) Math.ceil(position[n - 1] / (m - 1.0));
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(position, mid, m)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] position, int distance, int m) {
        int prevBall = position[0];
        int ballCount = 1;
        for (int i = 1; i < position.length && ballCount < m; i++) {
            int curr = position[i];
            if (curr - prevBall >= distance) {
                ballCount++;
                prevBall = curr;
            }
        }
        return ballCount == m;
    }
}
