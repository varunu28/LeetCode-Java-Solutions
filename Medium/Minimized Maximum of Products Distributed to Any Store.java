class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 0;
        int right = 0;
        for (int quantity : quantities) {
            right = Math.max(right, quantity);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (isPossible(n, mid, quantities)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isPossible(int n, int min, int[] quantities) {
        int idx = 0;
        int remaining = quantities[idx];
        for (int i = 0; i < n; i++) {
            if (remaining <= min) {
                idx++;
                if (idx == quantities.length) {
                    return true;
                } else {
                    remaining = quantities[idx];
                }
            } else {
                remaining -= min;
            }
        }
        return false;
    }
}
