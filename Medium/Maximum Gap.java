class Solution {

    static class Bucket {
        boolean used = false;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
    }

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        } 
        int minNum = nums[0];
        int maxNum = nums[0];
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        int bucketSize = Math.max(1, (maxNum - minNum) / (n - 1));
        int bucketCount = (maxNum - minNum) / bucketSize + 1;
        Bucket[] buckets = new Bucket[bucketCount];
        for (int num : nums) {
            int bucketIdx = (num - minNum) / bucketSize;
            if (buckets[bucketIdx] == null) {
                buckets[bucketIdx] = new Bucket();
            }
            buckets[bucketIdx].used = true;
            buckets[bucketIdx].minVal = Math.min(num, buckets[bucketIdx].minVal);
            buckets[bucketIdx].maxVal = Math.max(num, buckets[bucketIdx].maxVal);
        }
        int prevBucketMax = minNum;
        int maxGap = 0;
        for (Bucket bucket : buckets) {
            if (bucket != null) {
                maxGap = Math.max(maxGap, bucket.minVal - prevBucketMax);
                prevBucketMax = bucket.maxVal;
            }
        }
        return maxGap;
    }
}
