class Solution {
    public int countDigits(int num) {
        int count = 0;
        int copy = num;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            if (digit != 0 && copy % digit == 0) {
                count++;
            }
        }
        return count;
    }
}
