class Solution {

    private final int MOD = 1000_000_007;

    public int valueAfterKSeconds(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        while (k-- > 0) {
            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i] + arr[i - 1]) % MOD;
            }
        }
        return arr[n - 1];
    }
}
