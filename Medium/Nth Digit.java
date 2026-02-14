class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        int numOfDigits = 9;
        while (n - numOfDigits > 0) {
            n -= numOfDigits;
            digit++;
            numOfDigits = 9 * ((int) Math.pow(10, digit - 1)) * digit;
            if (numOfDigits < 0) {
                break;
            }
        }
        int base = ((int) Math.pow(10, digit - 1));
        int number = base + (n - 1) / digit;
        char digitInNumber = String.valueOf(number).charAt((n - 1) % digit); 
        return digitInNumber - '0';
    }
}
