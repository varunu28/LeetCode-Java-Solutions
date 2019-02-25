class Solution {
    public boolean circularArrayLoop(int[] nums) {
        boolean hasCycle = false;
        for (int n = 0; n < nums.length; n++) {
            Integer slow = n;
            Integer fast = getUpdatedIdx(nums, 0, n);
            int dir = nums[n];

            while (slow != null && fast != null && slow != fast) {
                slow = getUpdatedIdx(nums, dir, slow);
                fast = getUpdatedIdx(nums, dir, getUpdatedIdx(nums, dir, fast));
            }

            if (slow != null && slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        return hasCycle;
    }

    private Integer getUpdatedIdx(int[] nums, int dir, Integer pos) {
        if (pos == null) {
            return null;
        }

       if (dir * nums[pos] < 0) {
           return null;
       }

        Integer next = (pos + nums[pos]) % nums.length;
        if (next < 0) {
            next += nums.length;
        }

        if (next == pos) {
            next = null;
        }
        
        return next;
    }
}
