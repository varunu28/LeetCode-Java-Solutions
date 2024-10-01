class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            if (remainder == 0) {
                if (map.get(remainder) % 2 == 1) {
                    return false;
                }
            } else if (!map.get(remainder).equals(map.get(k - remainder))) {
                return false;
            }
        }
        return true;
    }
}
