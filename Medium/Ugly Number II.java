class Solution {
    public static int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        int mul2 = 2;
        int mul3 = 3;
        int mul5 = 5;

        int ugly = 1;

        for (int i=1; i<n; i++) {
            ugly = Math.min(mul2, Math.min(mul3, mul5));
            arr[i] = ugly;

            if (ugly == mul2) {
                i2++;
                mul2 = arr[i2]*2;
            }
            if (ugly == mul3) {
                i3++;
                mul3 = arr[i3]*3;
            }
            if (ugly == mul5) {
                i5++;
                mul5 = arr[i5]*5;
            }
        }

        return ugly;
    }
}
