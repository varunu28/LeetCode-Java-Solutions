class ValidWordAbbr {

  private final Map<String, String> abbreviationToWordMap;

  public ValidWordAbbr(String[] dictionary) {
    this.abbreviationToWordMap = new HashMap<>();
    for (String word : dictionary) {
      String abbreviation = buildAbbreviation(word);
      if (this.abbreviationToWordMap.containsKey(abbreviation) && 
          !this.abbreviationToWordMap.get(abbreviation).equals(word)) {
        this.abbreviationToWordMap.put(abbreviation, "");
      } else {
        this.abbreviationToWordMap.put(abbreviation, word);
      }
    }
  }

  public boolean isUnique(String word) {
    String abbreviation = buildAbbreviation(word);
    return !this.abbreviationToWordMap.containsKey(abbreviation) || this.abbreviationToWordMap.get(
        abbreviation).equals(word);
  }

  private String buildAbbreviation(String s) {
    if (s.length() <= 2) {
      return s;
    }
    return s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
  }
}
/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
