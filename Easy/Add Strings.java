class Solution {
    public String addStrings(String num1, String num2) {
        String big = num2;
        String small = num1;
        if (num1.length() > num2.length()) {
            big = num1;
            small = num2;
        }
        
        StringBuilder answer = new StringBuilder("");
        int small_i = small.length() - 1;
        int big_i = big.length() - 1;
        
        int carryOver = 0;
        
        while (small_i >= 0) {
            int mid = Integer.parseInt(String.valueOf(small.charAt(small_i))) + Integer.parseInt(String.valueOf(big.charAt(big_i))) + carryOver;
            carryOver = mid/10;
            mid = mid%10;
            answer.append(String.valueOf(mid));
            small_i--;
            big_i--;
        }
        
        while (big_i >= 0) {
            int mid = Integer.parseInt(String.valueOf(big.charAt(big_i))) + carryOver;
            carryOver = mid/10;
            mid = mid%10;
            answer.append(String.valueOf(mid));
            big_i--;
        }
        
        return carryOver > 0 ? String.valueOf(carryOver) + answer.reverse().toString() : answer.reverse().toString();
    }
}
