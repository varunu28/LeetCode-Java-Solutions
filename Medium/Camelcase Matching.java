class Solution {
  public List<Boolean> camelMatch(String[] queries, String pattern) {
    List<Boolean> list = new ArrayList<>();
    for (String query : queries) {
      list.add(isMatch(query, pattern));
    }
    return list;
  }
  
  private boolean isMatch(String query, String pattern) {
    int idxQuery = 0;
    int idxPattern = 0;
    int lenQuery = query.length();
    int lenPattern = pattern.length();
    while (idxQuery < lenQuery && idxPattern < lenPattern) {
      char queryC = query.charAt(idxQuery);
      char patternC = pattern.charAt(idxPattern);
      if (queryC == patternC) {
        idxQuery++;
        idxPattern++;
      }
      else if (Character.isUpperCase(queryC)) {
        return false;
      }
      else {
        idxQuery++;
      }
    }
    while (idxQuery < lenQuery && Character.isLowerCase(query.charAt(idxQuery))) {
      idxQuery++;
    }
    return idxPattern == lenPattern && idxQuery == lenQuery;
  }
}
