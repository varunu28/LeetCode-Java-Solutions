class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s.length() < p.length()) {
      return list;
    }
    int[] pArr = new int[26];
    for (char c : p.toCharArray()) {
      pArr[c - 'a']++;
    }
    String pStr = Arrays.toString(pArr);
    int start = 0;
    int end = 0;
    int n = s.length();
    int[] sArr = new int[26];
    while (end < (p.length() - 1)) {
      sArr[s.charAt(end) - 'a']++;
      end++;
    }
    while (end < n) {
      sArr[s.charAt(end) - 'a']++;
      end++;
      if (Arrays.toString(sArr).equals(pStr)) {
        list.add(start);
      }
      sArr[s.charAt(start++) - 'a']--;
    }
    return list;
  }
}
