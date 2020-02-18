class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> map = new HashMap<>();
    for(String domain : cpdomains) {
      int count = Integer.parseInt(domain.split("\\s+")[0]);
      String[] subDomains = domain.split("\\s+")[1].split("\\.");
      StringBuilder sb = new StringBuilder();
      for (int i = subDomains.length - 1; i >= 0; i--) {
        if (sb.length() != 0) {
          sb.insert(0, ".");
        }
        sb.insert(0, subDomains[i]);
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);
      }
    }
    List<String> list = new ArrayList<>();
    for (String key : map.keySet()) {
      list.add(map.get(key) + " " + key);
    }
    return list;
  }
}
