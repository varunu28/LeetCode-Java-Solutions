class Solution {
    public static List<List<Integer>> subsets(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> perms = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetsHelper(nums, perms, temp, 0);

        return perms;
    }

    private static void subsetsHelper(int[] nums, List<List<Integer>> perms, List<Integer> temp, int start) {
        perms.add(new ArrayList<>(temp));

        for (int i=start; i<nums.length; i++) {
            temp.add(nums[i]);
            subsetsHelper(nums, perms, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
