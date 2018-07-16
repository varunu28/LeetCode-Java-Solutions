class Solution {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length; i++) {
            int ascii = (int) chars[i];
            if (ascii >= 65 && ascii <= 90) {
                ascii = 97 + (ascii - 65);
                chars[i] = (char) ascii;
            }
        }
        
        return String.valueOf(chars);
    }
}
