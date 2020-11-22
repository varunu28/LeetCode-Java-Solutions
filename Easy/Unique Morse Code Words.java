class Solution {
  private final String[] CODE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
  public int uniqueMorseRepresentations(String[] words) {
    return Arrays.stream(words).map(e -> getEncoding(e)).collect(Collectors.toSet()).size();
  }
  
  private String getEncoding(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      sb.append(CODE[c - 'a']);
    }
    return sb.toString();
  }
}
