class Solution {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] arr = new int[n+1];
        arr[0] = 1;

        int[] counter = new int[primes.length];

        for (int i=1; i<n; i++) {
            int temp = Integer.MAX_VALUE;
            int idx = -1;

            for (int j=0; j<primes.length; j++) {
                if (primes[j]*arr[counter[j]] < temp) {
                    temp = primes[j]*arr[counter[j]];
                    idx = j;
                }
                else if (primes[j]*arr[counter[j]] == temp) {
                    counter[j]++;
                }
            }

            arr[i] = temp;
            counter[idx]++;
        }

        return arr[n-1];
    }
}
