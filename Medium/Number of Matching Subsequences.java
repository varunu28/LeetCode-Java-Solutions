class Solution {
  public int numMatchingSubseq(String s, String[] words) {
    Map<Character, List<Pair>> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.computeIfAbsent(words[i].charAt(0), k -> new ArrayList<>()).add(new Pair(0, i));
    }
    int counter = 0;
    for (char c : s.toCharArray()) {
      List<Pair> existingPairs = map.getOrDefault(c, new ArrayList<>());
      map.put(c, new ArrayList<>());
      for (Pair pair : existingPairs) {
        int currIdx = pair.currIdx;
        if (currIdx + 1 == words[pair.wordIdx].length()) {
          counter++;
        } else {
          map.computeIfAbsent(words[pair.wordIdx].charAt(currIdx + 1), k -> new ArrayList<>())
              .add(new Pair(currIdx + 1, pair.wordIdx));
        }
      }
    }
    return counter;
  }
  
  private static class Pair {
    int currIdx;
    int wordIdx;

    public Pair(int currIdx, int wordIdx) {
      this.currIdx = currIdx;
      this.wordIdx = wordIdx;
    }
  }
}
