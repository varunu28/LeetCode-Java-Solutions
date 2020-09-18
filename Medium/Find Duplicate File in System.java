class Solution {
  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> map = new HashMap<>();
    for (String path : paths) {
      String[] strs = path.split("\\s+");
      String filePath = strs[0];
      for (int i = 1; i < strs.length; i++) {
        int startIdx = strs[i].indexOf('(');
        String fileName = strs[i].substring(0, startIdx);
        String content = strs[i].substring(startIdx, strs[i].length());
        map.computeIfAbsent(content, k -> new ArrayList<>()).add(filePath + "/" + fileName);
      }
    }
    List<List<String>> duplicateFiles = new ArrayList<>();
    for (String key : map.keySet()) {
      if (map.get(key).size() > 1) {
        duplicateFiles.add(map.get(key));
      } 
    }
    return duplicateFiles;
  }
}
