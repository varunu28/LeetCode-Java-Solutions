class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int expectedSum = mean * (n + m);
        int remaining = expectedSum - sum;
        if (remaining > 6 * n || remaining < n) {
            return new int[]{};
        }
        int[] result = new int[n];
        Arrays.fill(result, remaining / n);
        remaining = remaining % n;
        for (int i = 0; i < remaining; i++) {
            result[i]++;
        }        
        return result;
    }
}
