class Solution {
    public boolean consecutiveSetBits(int n) {
        boolean found = false;
        int previousBit = 0;
        while (n > 0) {
            int bit = n % 2;
            n /= 2;
            if (bit == 1 && previousBit == 1) {
                if (found) {
                    return false;
                }
                found = true;
            }
            previousBit = bit;
        }    
        return found;
    }
}
