class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 0;
        int i = 2;
        while (i <= Math.sqrt(num)) {
            if (num%i == 0) {
                sum += i + num/i;
            }
            i++;
        }
        sum++;
        
        return sum == num;
    }
}
