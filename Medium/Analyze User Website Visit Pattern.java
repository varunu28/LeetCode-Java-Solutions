class Solution {
  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    Map<String, List<WebEntry>> map = new HashMap<>();
    for (int i = 0; i < timestamp.length; i++) {
      map.computeIfAbsent(username[i], k -> new ArrayList<>()).add(
        new WebEntry(website[i], timestamp[i], username[i])
      );
    }
    Map<String, Set<String>> visitMap = new HashMap<>();
    Set<String> threeSequenceSet = new HashSet<>(); 
    for (String key : map.keySet()) {
      List<WebEntry> webentries = map.get(key);
      Collections.sort(webentries, new Comparator<WebEntry>(){
        public int compare(WebEntry w1, WebEntry w2) {
          return w1.timestamp - w2.timestamp;
        }
      });
      for (int i = 0; i < webentries.size(); i++) {
        for (int j = i + 1; j < webentries.size(); j++) {
          for (int k = j + 1; k < webentries.size(); k++) {
            String websiteKey = (
              webentries.get(i).website + " " + 
              webentries.get(j).website + " " + 
              webentries.get(k).website
            );
            visitMap.computeIfAbsent(websiteKey, m -> new HashSet<>()).add(key);
            threeSequenceSet.add(websiteKey);
          }
        }
      }
    }
    List<String> threeSequenceList = new ArrayList<>(threeSequenceSet);
    Collections.sort(threeSequenceList, new Comparator<String>(){
      public int compare(String s1, String s2) {
        int c = visitMap.get(s2).size() - visitMap.get(s1).size();
        if (c != 0) {
          return c;
        }
        return s1.compareTo(s2);
      }
    });
    String[] ansArr = threeSequenceList.get(0).split("\\s+");
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < ansArr.length; i++) {
      ans.add(ansArr[i]);
    }
    return ans;
  }
}


class WebEntry {
  String website;
  int timestamp;
  String username;
  
  public WebEntry(String website, int timestamp, String username) {
    this.website = website;
    this.timestamp = timestamp;
    this.username = username;
  }
}
