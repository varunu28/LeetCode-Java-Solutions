class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder("");
        
        sb.append(nums[0]);
        
        for(int i=1;i<nums.length;i++) {
            if (i == 1 && nums.length > 2) {
                sb.append("/(").append(nums[i]);
            }
            else {
                sb.append("/").append(nums[i]);
            }
        }
        
        return nums.length > 2 ? sb.append(")").toString() : sb.toString();
    }
}
