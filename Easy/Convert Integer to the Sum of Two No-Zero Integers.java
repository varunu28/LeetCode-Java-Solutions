class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int numOne = i;
            int numTwo = n - i;
            if (String.valueOf(numOne).contains("0") || String.valueOf(numTwo).contains("0")) {
                continue;
            }
            return new int[]{numOne, numTwo};
        }
        return new int[]{};
    }
}
