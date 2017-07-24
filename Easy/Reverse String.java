public class Solution {
    public String reverseString(String s) {
        StringBuilder input1 = new StringBuilder();
        input1.append(s);
        input1 = input1.reverse();
        return input1.toString();
    }
}