class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer value : map.values()) {
            if (isPrime(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return num > 1 && true;
    }
}
