class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Long> map = new HashMap<>();
    for (String cpdomain : cpdomains) {
      int spaceIdx = cpdomain.indexOf(' ');
      int count = Integer.parseInt(cpdomain.substring(0, spaceIdx));
      String[] subdomains = cpdomain.substring(spaceIdx + 1).split("\\.");
      StringBuilder sb = new StringBuilder();
      for (int i = subdomains.length - 1; i >= 0; i--) {
        sb.insert(0, subdomains[i]);
        String currDomain = sb.toString();
        map.put(currDomain, map.getOrDefault(currDomain, 0L) + count);
        sb.insert(0, ".");
      }
    }
    List<String> result = new ArrayList<>();
    for (String key : map.keySet()) {
      result.add(map.get(key) + " " + key);
    }
    return result;
  }
}
