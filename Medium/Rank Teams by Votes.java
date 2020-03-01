class Solution {
  public String rankTeams(String[] votes) {
    Map<Character, int[]> map = new HashMap<>();
    int n = votes[0].length();
    for(String vote : votes) {
      for (int i = 0; i < n; i++) {
        if (!map.containsKey(vote.charAt(i))) {
          map.put(vote.charAt(i), new int[n]);
        }
        map.get(vote.charAt(i))[i]++;
      }
    }
    PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){
      public int compare(Character c1, Character c2) {
        for (int i = 0; i < n; i++) {
          int c = map.get(c2)[i] - map.get(c1)[i];
          if (c != 0) {
            return c;
          }
        }
        return c1 - c2;
      }
    });
    for (char c : votes[0].toCharArray()) {
      pq.add(c);
    }
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      sb.append(pq.poll());
    }
    return sb.toString();
  }
}
