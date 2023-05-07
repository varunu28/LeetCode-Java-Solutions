class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int lisLength = 0;
        int[] result = new int[n];
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            int height = obstacles[i];
            int idx = bisect(lis, height, lisLength);
            if (idx == lisLength) {
                lisLength++;
            }
            lis[idx] = height;
            result[i] = idx + 1;
        }
        return result;
    }
    
    private int bisect(int[] lis, int target, int right) {
        if (right == 0) {
            return 0;
        }
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (lis[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
