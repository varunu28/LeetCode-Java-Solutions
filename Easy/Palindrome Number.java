class Solution {
    public boolean isPalindrome(int x) {
        return x < 0 ? false : x == getReverseDigit(x);
    }
    
    private int getReverseDigit(int x) {
        int num = 0;
        while (x > 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        
        return num;
    }
}
