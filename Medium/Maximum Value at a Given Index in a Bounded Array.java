class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int start = 1;
        int end = maxSum;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (findSum(index, mid, n) <= maxSum) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    
    private long findSum(int index, int targetIndex, int n) {
        long count = 0;
        if (targetIndex > index) {
            count += (long) (2 * targetIndex - index) * (index + 1) / 2;
        } else {
            count += (long) (targetIndex + 1) * targetIndex / 2 + index - targetIndex + 1;
        }
        if (targetIndex >= n - index) {
            count += (long) (targetIndex + targetIndex - n + 1 + index) * (n - index) / 2;
        } else {
            count += (long) (targetIndex + 1) * targetIndex / 2 + n - index - targetIndex;
        }   
        return count - targetIndex;
    }
}
