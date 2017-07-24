public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> al=new ArrayList<Integer>();
        for (int i=0;i<nums1.length;i++) {
            if(findIndex(nums2, nums1[i]) != -1 && al.contains(nums1[i]) == false) {
                al.add(nums1[i]);
            }
        }
        return convertIntegers(al);
    }
    
    public static int findIndex(int[] nums, int elem) {
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == elem) {
                return i;
            }
        }
        return -1;
    }
    
    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}