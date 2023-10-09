class Solution {

    private static enum Position {
        FIRST, LAST;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            search(nums, target, Position.FIRST),
            search(nums, target, Position.LAST)
        };
    }

    private static int search(int[] nums, int target, Position position) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                idx = mid;
                if (position == Position.FIRST) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }
}
