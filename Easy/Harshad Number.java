class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int digitSum = getDigitSum(x);
        return x % digitSum == 0 ? digitSum : -1;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
