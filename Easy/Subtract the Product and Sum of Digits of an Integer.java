class Solution {
    public int subtractProductAndSum(int n) {
        return getProduct(n) - getSum(n);
    }
    
    private int getProduct(int n) {
        if (n == 0) {
            return 0;
        }
        int fact = 1;
        while (n > 0) {
            fact *= n % 10;
            n /= 10;
        }
        return fact;
    }
    
    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
