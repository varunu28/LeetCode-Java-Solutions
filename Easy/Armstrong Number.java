class Solution {
    public boolean isArmstrong(int N) {
        int n = getLength(N);
        return getNthPowerSum(N, n) == N;
    }

    private int getNthPowerSum(int n, int p) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            sum += (int) Math.pow(temp, p);
        }

        return sum;
    }

    private int getLength(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }

        return count;
    }
}
