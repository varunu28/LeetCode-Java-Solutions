class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = min; i < max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
