class Solution {
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int squareSum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            digitSum += digit;
            squareSum += digit * digit;
        }
        return squareSum - digitSum >= 50;
    }
}
