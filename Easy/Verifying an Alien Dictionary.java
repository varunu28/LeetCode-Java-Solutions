class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> dictionary = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      dictionary.put(order.charAt(i), i);
    }
    for (int i = 0; i < words.length - 1; i++) {
      if (!hasCorrectOrder(words[i], words[i + 1], dictionary)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean hasCorrectOrder(String firstWord, String secondWord, Map<Character, Integer> dictionary) {
    int idxOne = 0;
    int idxTwo = 0;
    boolean correctOrder = false;
    while (idxOne < firstWord.length() && idxTwo < secondWord.length()) {
      int dictionaryDiff = dictionary.get(firstWord.charAt(idxOne++)) - dictionary.get(secondWord.charAt(idxTwo++));
      if (dictionaryDiff > 0) {
        return false;
      } 
      if (dictionaryDiff < 0) {
        correctOrder = true;
        break;
      }
    }
    return correctOrder || firstWord.length() <= secondWord.length();
  }
}
