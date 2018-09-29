class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int temp = target - (nums[i] + nums[j]);
                int start = j+1;
                int end = nums.length-1;

                while (start < end) {
                    if (nums[start] + nums[end] == temp) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);

                        ans.add(list);
                        start++;
                        end--;
                    }
                    else if (nums[start] + nums[end] < temp) {
                        start++;
                    }
                    else if (nums[start] + nums[end] > temp) {
                        end--;
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
