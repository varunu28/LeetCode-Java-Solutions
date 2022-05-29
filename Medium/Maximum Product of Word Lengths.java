class Solution {
  public int maxProduct(String[] words) {
    int maxProd = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if (noCommonLetters(words[i], words[j])) {
          maxProd = Math.max(maxProd, words[i].length() * words[j].length());
        }
      }
    }
    return maxProd;
  }
  
  private boolean noCommonLetters(String s1, String s2) {
    int bitMaskOne = 0;
    int bitMaskTwo = 0;
    for (char c : s1.toCharArray()) {
      bitMaskOne |= 1 << ((int) c - (int) 'a');
    }
    for (char c : s2.toCharArray()) {
      bitMaskTwo |= 1 << ((int) c - (int) 'a');
    }
    return (bitMaskOne & bitMaskTwo) == 0;
  }
}
