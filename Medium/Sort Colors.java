class Solution {
    public void sortColors(int[] nums) {
        int numZero = 0;
        int numOne = 0;
        int numTwo = 0;
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) numZero++;
            if(nums[i] == 1) numOne++;
            if(nums[i] == 2) numTwo++;
        }
        
        for(int i=0;i<nums.length;i++) {
            if (numZero != 0) {
                nums[i] = 0;
                numZero--;
            }
            else if(numZero == 0 && numOne != 0) {
                nums[i] = 1;
                numOne--;
            }
            else {
                nums[i] = 2;
                numTwo--;
            }
        }
    }
}
