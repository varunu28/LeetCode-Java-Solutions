class Solution {
    public int minMaxDifference(int num) {
        char digitsOne[] = String.valueOf(num).toCharArray();
        char digitsTwo[] = String.valueOf(num).toCharArray();
        char firstDigitOne = digitsOne[0];
        char firstDigitTwo = digitsOne[0];
        for (int i = 0; i < digitsOne.length; i++) {
            if (digitsOne[i] != '9') {
                firstDigitOne = digitsOne[i];
                break;
            }
        }
        for (int i = 0; i < digitsOne.length; i++) {
            if (digitsOne[i] == firstDigitOne) {
                digitsOne[i] = '9';
            }
        }
        for(int i = 0; i < digitsOne.length; i++) {
            if (digitsTwo[i] == firstDigitTwo) {
                digitsTwo[i] = '0';
            }
        }
        return Integer.parseInt(String.valueOf(digitsOne)) - Integer.parseInt(String.valueOf(digitsTwo));
    }
}
