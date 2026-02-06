class Solution {
    public int countMonobit(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += isMonobit(i) ? 1 : 0;
        }
        return count;
    }

    private boolean isMonobit(int num) {
        int bit = -1;
        while (num > 0) {
            int currBit = num % 2;
            if (bit == -1) {
                bit = currBit;
            } else if (bit != currBit) {
                return false;
            }
            num /= 2;
        }
        return true;
    }
}
