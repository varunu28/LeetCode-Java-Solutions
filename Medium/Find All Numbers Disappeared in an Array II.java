class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            if (num < lower) {
                continue;
            }
            if (num > upper) {
                break;
            }
            if (num > lower) {
                result.add(List.of(lower, num - 1));
            }
            lower = num + 1;
        }
        if (lower <= upper) {
            result.add(List.of(lower, upper));
        }
        return result;
    }
}
