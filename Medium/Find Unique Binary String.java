class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> decimalNums = new HashSet<>();
        for (String num : nums) {
            decimalNums.add(Integer.parseInt(num, 2));
        }   
        int n = nums.length;
        for (int num = 0; num <= n; num++) {
            if (!decimalNums.contains(num)) {
                String result = Integer.toBinaryString(num);
                while (result.length() < n) {
                    result = "0" + result;
                }
                return result;
            }
        }
        return "";
    }
}
