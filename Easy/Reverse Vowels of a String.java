class Solution {
  public String reverseVowels(String s) {
    int left = 0;
    int right = s.length() - 1;
    String vowels = "aeiouAEIOU";
    char[] chars = s.toCharArray();
    while (left < right) {
      int vowelIndexLeft = vowels.indexOf(chars[left]);
      int vowelIndexRight = vowels.indexOf(chars[right]);
      if (vowelIndexLeft != -1 && vowelIndexRight != -1) {
        char temp = chars[left];
        chars[left++] = chars[right];
        chars[right--] = temp;
      }
      else if (vowelIndexRight == -1) {
        right--;
      }
      else {
        left++;
      }
    }
    return String.valueOf(chars);
  }
}
