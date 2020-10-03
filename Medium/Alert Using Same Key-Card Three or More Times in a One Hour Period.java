class Solution {
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < keyName.length; i++) {
      int numOfMinutes = Integer.parseInt(keyTime[i].split(":")[0]) * 60 + Integer.parseInt(keyTime[i].split(":")[1]);
      map.computeIfAbsent(keyName[i], k -> new ArrayList<>()).add(numOfMinutes);
    }
    List<String> ans = new ArrayList<>();
    for (String key : map.keySet()) {
      List<Integer> list = map.get(key);
      Collections.sort(list);
      for (int i = 0; i < list.size() - 2; i++) {
        if (list.get(i + 1) <= (list.get(i) + 60) && list.get(i + 2) <= (list.get(i) + 60)) {
          ans.add(key);
          break;
        }
      }
    }
    Collections.sort(ans);
    return ans;
  }
}
