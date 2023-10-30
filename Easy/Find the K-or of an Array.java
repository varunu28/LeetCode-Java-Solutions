class Solution {
    public int findKOr(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            List<Integer> setBits = getSetBits(num);
            for (Integer setBit : setBits) {
                map.put(setBit, map.getOrDefault(setBit, 0) + 1);
            }
        }
        int result = 0;
        for (int i = 0, p = 1; i < 32; i++, p *= 2) {
            if (map.getOrDefault(i, 0) >= k) {
                result += p;
            }
        }
        return result;
    }

    private static List<Integer> getSetBits(int num) {
        List<Integer> bits = new ArrayList<>();
        int bit = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                bits.add(bit);
            }
            num = num / 2;
            bit++;
        }
        return bits;
    }
}
