class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] result = new int[n];
        int leftIdx = 0;
        int rightIdx = n - 1;
        int resultIdx = a >= 0 ? n - 1 : 0;
        int resultDelta = a >= 0 ? -1 : 1;
        while (leftIdx <= rightIdx) {
            int leftValue = nums[leftIdx];
            int rightValue = nums[rightIdx];
            int leftResult = a * (leftValue * leftValue) + b * leftValue + c;
            int rightResult = a * (rightValue * rightValue) + b * rightValue + c;
            if (a >= 0) {
                if (leftResult > rightResult) {
                    result[resultIdx] = leftResult;
                    leftIdx++;
                } else {
                    result[resultIdx] = rightResult;
                    rightIdx--;
                }
            } else {
                if (leftResult < rightResult) {
                    result[resultIdx] = leftResult;
                    leftIdx++;
                } else {
                    result[resultIdx] = rightResult;
                    rightIdx--;
                }
            }
            resultIdx += resultDelta;
        }
        return result;
    }
}
