class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<String> permutations = permuteUnique(arr);
        String maxStr = "";

        for (String str : permutations) {
            if (isValid(str)) {
                if (maxStr.length() == 0) {
                    maxStr = str;
                }
                else if (maxStr.compareTo(str) < 0) {
                    maxStr = str;
                }
            }
        }

        return maxStr.length() > 0 ? maxStr.substring(0, 2) + ":" + maxStr.substring(2) : maxStr;
    }

    private boolean isValid(String str) {
        int left = Integer.parseInt(str.substring(0, 2));
        int right = Integer.parseInt(str.substring(2));

        return left >= 0 && left <= 23 && right >= 0 && right <= 59;
    }

    private List<String> permuteUnique(int[] nums) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(nums);
        permuteHelper(nums, new ArrayList<>(), ans, new boolean[nums.length]);
        return new ArrayList<>(ans);
    }

    private void permuteHelper(int[] nums, List<Integer> list, List<String> ans, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(list.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("")));
        }
        else {
            for (int i=0; i<nums.length; i++) {
                // Choose
                if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                    continue;
                }

                used[i] = true;
                list.add(nums[i]);

                // Explore
                permuteHelper(nums, list, ans, used);

                // Un-choose
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
