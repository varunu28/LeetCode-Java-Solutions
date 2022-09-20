class Solution {
  public String smallestEquivalentString(String s1, String s2, String baseStr) {
    int[] graph = new int[26];
    for (int i = 0; i < 26; i++) {
      graph[i] = i;
    }
    for (int i = 0; i < s1.length(); i++) {
      int idxOne = s1.charAt(i) - 'a';
      int idxTwo = s2.charAt(i) - 'a';
      int parentOne = find(graph, idxOne);
      int parentTwo = find(graph, idxTwo);
      if(parentOne < parentTwo) {
        graph[parentTwo] = parentOne;
      } else {
        graph[parentOne] = parentTwo;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : baseStr.toCharArray()) {
      sb.append((char) ('a' + find(graph, c - 'a')));
    }
    return sb.toString();
  }
  
  private int find(int[] graph, int idx) {
    while(graph[idx] != idx) {
      idx = graph[idx];
    }
    return idx;
  }
}
