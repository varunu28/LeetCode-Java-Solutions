class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 0;
        int right = 0;
        for (int day : bloomDay) {
            right = Math.max(right, day);
        }
        int days = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numberOfBouquet(bloomDay, mid, k) >= m) {
                days = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return days;
    }

    private int numberOfBouquet(int[] bloomDay, int mid, int k) {
        int bouquetCount = 0;
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                bouquetCount++;
                count = 0;
            }
        }
        return bouquetCount;
    }
}
