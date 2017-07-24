public class Solution {
    public String reverseWords(String s) {
        String[] words=s.split("\\s");
        for (int i=0;i<words.length;i++) {
            StringBuilder input1 = new StringBuilder();
            input1.append(words[i]);
            input1 = input1.reverse();
            words[i] = input1.toString();
        }
        return String.join(" ", words);
    }
}