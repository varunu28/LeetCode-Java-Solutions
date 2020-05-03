class Solution {
  public int numJewelsInStones(String J, String S) {
    Map<Character, Integer> mapJ = getMap(J);
    Map<Character, Integer> mapS = getMap(S);
    int count = 0;
    for (Character key : mapJ.keySet()) {
      count += mapS.getOrDefault(key, 0);
    }
    return count;
  }
  
  private Map<Character, Integer> getMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    return map;
  }
}
