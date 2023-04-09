class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int maxPrime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j || i + j == n - 1) && isPrime(nums[i][j])) {
                    maxPrime = Math.max(maxPrime, nums[i][j]);
                }
            }
        }
        return maxPrime;
    }
    
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        int midPoint = ((int) Math.sqrt(n)) + 1;
        for (int i = 2; i <= midPoint; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    } 
}
