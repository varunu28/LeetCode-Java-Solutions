class Solution {
  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, Set<String>> map = new HashMap<>();
    for (String path : paths) {
      String[] splitPath = path.split("\\s+");
      String directory = splitPath[0];
      for (int i = 1; i < splitPath.length; i++) {
        String fileName = splitPath[i].substring(0, splitPath[i].indexOf('('));
        String fileContent = splitPath[i]
            .substring(splitPath[i].indexOf('(') + 1, splitPath[i].indexOf(')'));
        map.computeIfAbsent(fileContent, k -> new HashSet<>()).add(directory + "/" + fileName);
      }
    }
    return map.values().stream().filter(entry -> entry.size() > 1).map(ArrayList::new)
        .collect(Collectors.toList());
  }
}
