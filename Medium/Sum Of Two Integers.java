class Solution {
    public int getSum(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        if (absA < absB) {
            return getSum(b, a);
        }
        int sign = a > 0 ? 1 : -1;
        if (a * b >= 0) {
            while (absB != 0) {
                int result = absA ^ absB;
                int carry = (absA & absB) << 1;
                absA = result;
                absB = carry;
            }
        } else {
            while (absB != 0) {
                int result = absA ^ absB;
                int borrow = ((~absA) & absB) << 1;
                absA = result;
                absB = borrow;
            }
        }
        return absA * sign;
    }
}
