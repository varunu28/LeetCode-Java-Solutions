class Solution {
    public double equalizeWater(int[] buckets, int loss) {
        double start = 0;
        double end = 100000;
        double retention = (100.0 - loss) / 100;
        while (end - start > 0.00001) {
            double mid = (start + end) / 2;
            double need = 0;
            double have = 0;
            for (int bucket : buckets) {
                if (bucket >= mid) {
                    have += bucket - mid;
                } else {
                    need += mid - bucket;
                }
            }
            if (have * retention >= need) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
