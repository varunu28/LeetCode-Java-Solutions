class Solution {

    private static final Map<Integer, Integer> FACTORIAL_MAP = Map.of(
        0, 1,
        1, 1,
        2, 2, 
        3, 6, 
        4, 24,
        5, 120, 
        6, 720,
        7, 5040,
        8, 40320,
        9, 362880
    );

    public boolean isDigitorialPermutation(int n) {
        int[] digitFreq = findDigitFrequency(n);
        int sum = 0;
        while (n > 0) {
            sum += FACTORIAL_MAP.get(n % 10);
            n /= 10;
        }
        int[] sumDigitFreq = findDigitFrequency(sum);
        return Arrays.equals(digitFreq, sumDigitFreq);
    }

    private int[] findDigitFrequency(int n) {
        int[] frequency = new int[10];
        while (n > 0) {
            frequency[n % 10]++;
            n /= 10;
        }
        return frequency;
    }
}
