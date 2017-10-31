class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int l = bits.length;
        int i = 0;
        
        while(i<l-1) {
            if(bits[i] == 0) {
                i++;
            }
            else {
                i += 2;
            }
        }
        return i == l-1;
    }
}
