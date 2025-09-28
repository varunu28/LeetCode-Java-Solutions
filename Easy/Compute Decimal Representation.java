class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> digits = new ArrayList<>();
        int factor = 1;
        while (n > 0) {
            if (n % 10 != 0) {
                digits.add(n % 10 * factor);
            }
            n /= 10;
            factor *= 10;
        }
        int count = digits.size();
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = digits.get(count - i - 1);
        }
        return result;
    }
}
