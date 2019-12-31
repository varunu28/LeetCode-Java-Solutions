class Solution {
  public String toGoatLatin(String S) {
    StringBuilder addAString = new StringBuilder("a");
    StringBuilder sb = new StringBuilder();
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    String[] strs = S.split("\\s+");
    for (int i = 0; i < strs.length; i++) {
      if (vowels.contains(Character.toLowerCase(strs[i].charAt(0)))) {
        sb.append(strs[i]);
      }
      else {
        sb.append(strs[i].substring(1)).append(strs[i].charAt(0));
      }
      sb.append("ma").append(addAString.toString()).append(" ");
      addAString.append("a");
    }
    return sb.toString().trim();
  }
}
