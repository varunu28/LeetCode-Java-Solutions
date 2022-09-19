class Solution {
  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, Set<String>> contentToDirectoryMapping = new HashMap<>();
    for (String path : paths) {
      String[] splits = path.split("\\s+");
      String directoryName = splits[0];
      for (int i = 1; i < splits.length; i++) {
        int contentStartIdx = splits[i].indexOf('(');
        String fileName = splits[i].substring(0, contentStartIdx);
        String content = splits[i].substring(contentStartIdx + 1, splits[i].length() - 1);
        contentToDirectoryMapping.computeIfAbsent(content, k -> new HashSet<>())
          .add(directoryName + "/" + fileName);
      }
    }
    return contentToDirectoryMapping.values().stream()
      .filter(e -> e.size() > 1)
      .map(ArrayList::new)
      .collect(Collectors.toList());
  }
}
