class Solution {
    public long splitArray(int[] nums) {
        Set<Integer> primeIndices = getPrimeIndices(nums.length);
        long primeSum = 0;
        long nonPrimeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (primeIndices.contains(i)) {
                primeSum += nums[i];
            } else {
                nonPrimeSum += nums[i];
            }
        }
        return Math.abs(primeSum - nonPrimeSum);
    }

    private Set<Integer> getPrimeIndices(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        Set<Integer> primeIndices = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeIndices.add(i);
            }
        }
        return primeIndices;
    }
}
