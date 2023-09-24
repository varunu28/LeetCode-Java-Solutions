class Solution {
    public String maximumOddBinaryNumber(String s) {
        int oneCount = 0;
        for (char c : s.toCharArray()) {
            oneCount += c == '1' ? 1 : 0;
        }
        if (oneCount == 0) {
            return s;
        }
        int zeroCount = s.length() - oneCount;
        return "1".repeat(oneCount - 1) + "0".repeat(zeroCount) + "1";
    }
}
