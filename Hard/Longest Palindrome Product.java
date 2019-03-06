class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        
        int upperBound = (int) Math.pow(10, n) - 1;
        int lowerBound = upperBound / 10;
        
        long maxNum = (long) upperBound * (long) upperBound;
        int firstHalf = (int) (maxNum / (long) Math.pow(10, n));
        
        boolean isPalindrome = false;
        long palindrome = 0;
        
        while (!isPalindrome) {
            palindrome = createPalindromeHelper(firstHalf);
            
            for (long i = upperBound; upperBound > lowerBound; i--) {
                if (palindrome > maxNum || i * i < palindrome) {
                    break;
                }
                
                if (palindrome % i == 0) {
                    isPalindrome = true;
                    break;
                }
            }
            
            firstHalf--;
        }
        
        return (int) (palindrome % 1337);
    }
    
    private long createPalindromeHelper(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }
}
