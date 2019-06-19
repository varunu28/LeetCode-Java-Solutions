class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (n != 1) {
            int sumOfDigitSquare = getSumOfDigitSquare(n);
            if (set.contains(sumOfDigitSquare)) {
                return false;
            }
            
            set.add(sumOfDigitSquare);
            n = sumOfDigitSquare;
        }
        
        return true;
    }
    
    private int getSumOfDigitSquare(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        
        return sum;
    }
}
