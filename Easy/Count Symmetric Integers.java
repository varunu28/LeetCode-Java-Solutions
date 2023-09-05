class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int diff = 0;
            int n = s.length();
            for (int j = 0; j < n / 2; j++) {
                diff += s.charAt(j) - s.charAt(n - j - 1);
            }
            if (n % 2 == 0 && diff == 0) {
                result++;
            }
        }
        return result;
    }
}
