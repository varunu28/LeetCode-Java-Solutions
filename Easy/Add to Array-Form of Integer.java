class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int idx = num.length - 1;
        int carry = 0;
        while (idx >= 0 || k > 0 || carry > 0) {
            if (idx >= 0 && k > 0) {
                carry += num[idx--] + k % 10;
                k /= 10;
            } else if (idx >= 0 && k == 0) {
                carry += num[idx--];
            } else if (idx < 0 && k > 0) {
                carry += k % 10;
                k /= 10;
            }
            result.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
