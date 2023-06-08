class Solution {
    
    private static enum Direction {
        LEFT, RIGHT;
    }
    
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = findIndex(nums, target, Direction.LEFT);
        if (firstIndex == -1) {
            return false;
        }
        int lastIndex = findIndex(nums, target, Direction.RIGHT);
        int occurrences = lastIndex - firstIndex + 1;
        return occurrences > nums.length / 2;
    }

    private int findIndex(int[] nums, int target, Direction direction) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                idx = mid;
                if (direction == Direction.LEFT) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }
}
