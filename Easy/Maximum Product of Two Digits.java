class Solution {
    public int maxProduct(int n) {
        int maximum = Integer.MIN_VALUE;
        int secondMaximum = Integer.MIN_VALUE;
        while (n > 0) {
            int num = n % 10;
            n /= 10;
            if (num > maximum) {
                secondMaximum = maximum;
                maximum = num;
            } else if (num > secondMaximum) {
                secondMaximum = num;
            }
        }
        return maximum * secondMaximum;
    }
}
