class Solution {
    public boolean isPowerOfTwo(int n) {
        // Check 1: n is positive
        // Check 2: If n is a power of 2 then only one bit will be set for n. Eg 4 -> 100, 16 -> 10000
        // Now if we calculate bit representation of n - 1, all the bits will be flipped. Eg 3 -> 001, 15 -> 0111
        // Performing & operation on n & n - 1 should result in 0 as there won't be any index in both bit representations which will be set
        return n > 0 && (n & (n - 1)) == 0;
    }
}
