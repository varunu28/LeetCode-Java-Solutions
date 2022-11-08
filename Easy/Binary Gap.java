class Solution {
    public int binaryGap(int n) {
        int lastOnePosition = -1;
        int currPosition = 0;
        int maxGap = 0;
        while (n > 0) {
            int rem = n % 2;
            n /= 2;
            if (rem == 1) {
                if (lastOnePosition != -1) {
                    maxGap = Math.max(maxGap, currPosition - lastOnePosition);
                }
                lastOnePosition = currPosition;
            }
            currPosition++;
        }
        return maxGap;
    }
}
