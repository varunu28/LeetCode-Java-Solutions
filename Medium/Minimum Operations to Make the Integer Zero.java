class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int count = 1;
        while (true) {
            long x = num1 - (long) num2 * count;
            if (x < count) {
                return -1;
            }
            if (count >= Long.bitCount(x)) {
                return count;
            }
            count++;
        }
    }
}
