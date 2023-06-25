class Solution {
    public int countBeautifulPairs(int[] nums) {
        int pairCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int lastDigit = nums[i] % 10;
            for (int j = 0; j < i; j++) {
                int firstDigit = getFirstDigit(nums[j]);
                pairCount += gcd(firstDigit, lastDigit) == 1 ? 1 : 0;
            }
        }
        return pairCount;
    }
    
    private static int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
