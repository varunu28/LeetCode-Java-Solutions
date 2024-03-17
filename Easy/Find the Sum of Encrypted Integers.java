class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += getEncryptedSum(num);
        }
        return sum;
    }
    
    private static int getEncryptedSum(int num) {
        int count = 0;
        int max = 0;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            count++;
            max = Math.max(digit, max);
        }
        return Integer.parseInt(String.join("", Collections.nCopies(count, String.valueOf(max))));
    }
}
