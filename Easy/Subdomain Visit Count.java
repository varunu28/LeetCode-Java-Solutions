class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> map = new HashMap<>();
    for (String domain : cpdomains) {
      String[] strs = domain.split("\\s+");
      int count = Integer.parseInt(strs[0]);
      String[] lowerDomains = strs[1].split("\\.");
      StringBuilder sb = new StringBuilder();
      for (int i = lowerDomains.length - 1; i >= 0; i--) {
        sb.insert(0, lowerDomains[i]);
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);
        sb.insert(0, '.');
      }
    }
    List<String> list = new ArrayList<>();
    for (String key : map.keySet()) {
      list.add(map.get(key) + " " + key);
    }
    return list;
  }
}
