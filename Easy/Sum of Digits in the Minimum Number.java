class Solution {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int num : A) {
            min = Math.min(min, num);
        }
        
        return getDigitSum(min) % 2 == 0 ? 1 : 0;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        return sum;
    }
}
