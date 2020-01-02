class Solution {
  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    List<List<String>> sessions = new ArrayList<>();
    int n = timestamp.length;
    // Form a session list -> user[i] at timestamp[i] visited website[i]
    for (int i = 0; i < n; i++) {
      sessions.add(new ArrayList<>());
      sessions.get(i).add(username[i]);
      sessions.get(i).add(String.valueOf(timestamp[i]));
      sessions.get(i).add(website[i]);
    }
    // Sort by timestamp
    sessions.sort((a, b) -> Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1)));
    Map<String, List<String>> visited = new HashMap<>();
    // Create a hashmap user -> list of websites visited
    for (int i = 0; i < n; i++) {
      visited.computeIfAbsent(sessions.get(i).get(0), k -> new ArrayList<>()).add(sessions.get(i).get(2));
    }
    Map<String, Integer> sequence = new HashMap<>();
    int maxCount = 0;
    String maxSeq = "";
    for (String name : visited.keySet()) {
      if (visited.get(name).size() >= 3) {
        // Form all possible combination of websites visited of size 3
        Set<String> subseqences = subseqence(visited.get(name));
        for (String seq : subseqences){
          sequence.put(seq, sequence.getOrDefault(seq, 0) + 1);
          if(sequence.get(seq) > maxCount){
            maxCount = sequence.get(seq);
            maxSeq = seq;
          }
          else if (sequence.get(seq) == maxCount && seq.compareTo(maxSeq) < 0) {
            maxSeq = seq;
          }
        }
      }
    }
    String[] strs = maxSeq.split(",");
    List<String> res = new ArrayList<>();
    for (String s : strs) {
      res.add(s);
    }
    return res;
  }
  
  private Set<String> subseqence(List<String> list) {
    Set<String> set = new HashSet<>();
    int n = list.size();
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          set.add(list.get(i) + "," + list.get(j) + "," + list.get(k));
        }
      }
    }
    return set;
  }
}
