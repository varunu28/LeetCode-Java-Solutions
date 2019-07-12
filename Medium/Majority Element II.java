class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        
        int num1 = nums[0];
        int num2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            }
            else if (nums[i] == num2) {
                count2++;
            }
            else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            }
            else if (nums[i] == num2) {
                count2++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        if (count1 > nums.length / 3) {
            ans.add(num1);
        }
        
        if (count2 > nums.length / 3) {
            ans.add(num2);
        }
        
        return ans;
    }
}
