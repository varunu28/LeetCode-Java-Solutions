class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n<1) {
            return 1;
        }
        
        int nums = 10;
        int base = 9;
        for (int i=2;i<=n && i<= 10; i++) {
            base = base * (9 - i + 2);
            nums += base;
        }
        
        return nums;
    }
}
