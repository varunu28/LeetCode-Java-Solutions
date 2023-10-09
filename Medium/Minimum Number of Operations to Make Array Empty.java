class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums)
        .boxed()
        .collect(
            Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        int operations = 0;
        for (Long value : map.values()) {
            if (value == 1) {
                return -1;
            }
            operations += (int) (value / 3 + (value % 3 != 0 ? 1 : 0));
        }
        return operations;
    }
}
