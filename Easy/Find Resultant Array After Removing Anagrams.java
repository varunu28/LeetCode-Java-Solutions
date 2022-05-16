class Solution {
  public List<String> removeAnagrams(String[] words) {
    List<String> result = new ArrayList<>();
    int startIdx = 0;
    for (int i = 1; i < words.length; i++) {
      if (!isAnagram(words[i], words[startIdx])) {
        result.add(words[startIdx]);
        startIdx = i;
      }
    }
    result.add(words[startIdx]);
    return result;
  }
  
  private boolean isAnagram(String wordOne, String wordTwo) {
    if (wordOne.length() != wordTwo.length()) {
      return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < wordOne.length(); i++) {
      counter[wordOne.charAt(i) - 'a']++;
      counter[wordTwo.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (counter[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
