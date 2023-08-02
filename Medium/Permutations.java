class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        permute(nums, result, new ArrayList<>(), visited);
        return result;
    }
    
    private void permute(int[] nums, List<List<Integer>> result, List<Integer> curr, Set<Integer> visited) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            curr.add(nums[i]);
            permute(nums, result, curr, visited);
            visited.remove(nums[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
