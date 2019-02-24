class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        long next = lower;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) {
                continue;
            }
            
            if (nums[i] == next) {
                next++;
                continue;
            }
            
            list.add(getRange(next, ((long) nums[i]) - 1));
            
            next = ((long) nums[i]) + 1;
        }
        
        if (next <= upper) {
            list.add(getRange(next, (long) upper));
        }
        
        return list;
    }
    
    private String getRange(long down, long up) {
        return up == down ? String.valueOf(up) : String.format("%d->%d", down, up);
    }
}
