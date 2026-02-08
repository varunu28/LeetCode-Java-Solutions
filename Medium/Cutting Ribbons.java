class Solution {
    public int maxLength(int[] ribbons, int k) {
        int start = 1;
        int end = ribbons[0];
        for (int ribbon : ribbons) {
            end = Math.max(ribbon, end);
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(ribbons, k, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    private boolean isPossible(int[] ribbons, int k, int x) {
        int count = 0;
        for (int ribbon : ribbons) {
            count += ribbon / x;
        }
        return count >= k;
    }
}
