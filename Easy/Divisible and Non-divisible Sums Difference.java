class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = n * (n + 1) / 2;
        int num2 = n / m;
        num2 = m * num2 * (num2 + 1) / 2;
        return num1 - 2 * num2;
    }
}
