class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        
        rotate(nums, 0, nums.length-1);
        rotate(nums,0,k-1);
        rotate(nums, k, nums.length-1);
    }
    
    public void rotate(int[] arr, int start, int end) {
        while(start < end) {
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] =  t;
            start++;
            end--;
        }
    }
}
