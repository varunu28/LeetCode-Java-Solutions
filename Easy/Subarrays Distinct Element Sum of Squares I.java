class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                int size = set.size();
                sum += size * size;
            }
        }
        return sum;
    }
}
