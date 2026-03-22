class Solution {
    public boolean uniformArray(int[] nums1) {
        // If all elements in nums1 are either odd or even then you already are 
        // maintaining parity. This is also true if there is only 1 element in nums1
        // If you have both odd & even then also it is always possible to subtract the elements to
        // reach the required parity as odd - even is always equal to odd. 
        // Hence it is always true.
        return true;
    }
}
