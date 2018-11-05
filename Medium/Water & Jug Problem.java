class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == z || y == z || z == x + y) {
            return true;
        }
        
        if (x + y < z) {
            return false;
        }

        int gcd = getGCD(x, y);
        
        return z%gcd == 0;
    }
    
    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return getGCD(b, a%b);
    }
}
