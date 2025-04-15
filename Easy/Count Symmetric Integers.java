class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSymmetric(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        for (int i = n / 2; i < n; i++) {
            sum -= Character.getNumericValue(s.charAt(i));
        }
        return sum == 0;
    }
}
