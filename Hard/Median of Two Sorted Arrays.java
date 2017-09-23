class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        ArrayList<Integer> arr = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        int k = 0;
        int limit = (n)/2 + 1;
        
        while (i < nums1.length && j < nums2.length && k < limit) {
            if (nums1[i] < nums2[j]) {
                arr.add(nums1[i]);
                i++;
            }
            else {
                arr.add(nums2[j]);
                j++;
            }
            k++;
        }
        
        if (i < nums1.length) {
            while (i < nums1.length && k < limit) {
                arr.add(nums1[i]);
                i++;
                k++;
            }
        }
        else {
            while (j < nums2.length && k < limit) {
                arr.add (nums2[j]);
                j++;
                k++;
            }
        }
        
        k--;
        
        return n%2 == 0 ? (double) (arr.get(k - 1) + arr.get(k)) / 2.0 : (double) arr.get(k);
    }
}
