class Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    Map<Character, Integer> licenseMap = new HashMap<>();
    for (Character c : licensePlate.toCharArray()) {
      if (Character.isLetter(c)) {
        licenseMap.put(Character.toLowerCase(c), licenseMap.getOrDefault(Character.toLowerCase(c), 0) + 1);
      }
    }
    int minLength = Integer.MAX_VALUE;
    int minLengthIdx = -1;
    for (int i = 0; i < words.length; i++) {
      Map<Character, Integer> copyMap = new HashMap<>(licenseMap);
      boolean found = false;
      for (Character c : words[i].toCharArray()) {
        if (copyMap.containsKey(Character.toLowerCase(c))) {
          copyMap.put(Character.toLowerCase(c), copyMap.get(Character.toLowerCase(c)) - 1);
          if (copyMap.get(Character.toLowerCase(c)) == 0) {
            copyMap.remove(Character.toLowerCase(c));
          }
        }
        if (copyMap.size() == 0) {
          found = true;
          break;
        }
      }
      if (found && words[i].length() < minLength) {
        minLength = words[i].length();
        minLengthIdx = i;
      }
    }
    return words[minLengthIdx];
  }
}
