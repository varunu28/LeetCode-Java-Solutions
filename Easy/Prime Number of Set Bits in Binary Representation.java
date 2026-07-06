class Solution {

    private static final Set<Integer> VALID_PRIMES = Set.of(
        2, 3, 5, 7, 11, 13, 17, 19
    );

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        while (left <= right) {
            int bits = Integer.bitCount(left);
            if (isPrime(bits)) {
                count++;
            }
            left++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        return VALID_PRIMES.contains(num);
    }
}
