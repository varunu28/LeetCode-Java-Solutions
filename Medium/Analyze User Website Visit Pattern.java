class Solution {
  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    Map<String, List<Integer>> userToVisitMapping = new HashMap<>();
    for (int i = 0; i < username.length; i++) {
      userToVisitMapping.computeIfAbsent(username[i], k -> new ArrayList<>()).add(i);
    }
    Map<String, Set<String>> patternToUserMapping = new HashMap<>();
    int maxCount = 0;
    String resultingPattern = null;
    for (String key : userToVisitMapping.keySet()) {
      List<String> visitedWebsiteInOrder =
          userToVisitMapping.get(key).stream()
              .sorted(Comparator.comparingInt(a -> timestamp[a]))
              .map(i -> website[i])
              .collect(Collectors.toList());
      for (int i = 0; i < visitedWebsiteInOrder.size() - 2; i++) {
        for (int j = i + 1; j < visitedWebsiteInOrder.size() - 1; j++) {
          for (int k = j + 1; k < visitedWebsiteInOrder.size(); k++) {
            String pattern =
                visitedWebsiteInOrder.get(i)
                    + " "
                    + visitedWebsiteInOrder.get(j)
                    + " "
                    + visitedWebsiteInOrder.get(k);
            patternToUserMapping.computeIfAbsent(pattern, l -> new HashSet<>()).add(key);
            if (maxCount <= patternToUserMapping.get(pattern).size()) {
              if (maxCount < patternToUserMapping.get(pattern).size()) {
                resultingPattern = pattern;
                maxCount = patternToUserMapping.get(pattern).size();
              } else if (pattern.compareTo(resultingPattern) < 0) {
                resultingPattern = pattern;
              }
            }
            maxCount = Math.max(maxCount, patternToUserMapping.get(pattern).size());
          }
        }
      }
    }
    return Arrays.stream(resultingPattern.split("\\s+")).collect(Collectors.toList());
  }
}
