class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int xor = 0;
        for (int num : nums) {
            if (!set.add(num)) {
                xor = xor ^ num;
            }
        }
        return xor;
    }
}
