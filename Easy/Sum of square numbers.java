class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int)Math.sqrt(c);
        
        while (a <= b) {
            int temp = a*a + b*b;
            if (temp < c) {
                a++;
            }
            else if (temp > c) {
                b--;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
