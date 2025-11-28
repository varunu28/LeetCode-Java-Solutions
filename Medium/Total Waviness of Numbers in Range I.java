class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for (int i = num1; i <= num2; i++) {
            count += calculateWaviness(i);
        }
        return count;
    }

    private static int calculateWaviness(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        if (n < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i - 1) && s.charAt(i) > s.charAt(i + 1)) {
                count++;
            }
            if (s.charAt(i) < s.charAt(i - 1) && s.charAt(i) < s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
