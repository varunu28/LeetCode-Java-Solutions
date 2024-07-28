class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleDigitSum = 0;
        int doubleDigitSum = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() > 1) {
                doubleDigitSum += num;
            } else {
                singleDigitSum += num;
            }
        }
        return singleDigitSum > doubleDigitSum || doubleDigitSum > singleDigitSum;
    }
}
