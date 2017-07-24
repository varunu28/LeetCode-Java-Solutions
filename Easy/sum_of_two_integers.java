public class Solution {
    public int getSum(int x, int y) {
        if (y == 0)
            return x;
        else
            return getSum( x ^ y, (x & y) << 1);
    }
}