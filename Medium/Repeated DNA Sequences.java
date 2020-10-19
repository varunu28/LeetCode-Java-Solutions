class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> seenSequences = new HashSet<>();
    Set<String> duplicateSequences = new HashSet<>();
    for (int idx = 0; idx <= s.length() - 10; idx++) {
      String currentSequence = s.substring(idx, idx + 10);
      if (!seenSequences.add(currentSequence)) {
        duplicateSequences.add(currentSequence);
      }
    }
    return new ArrayList<>(duplicateSequences);
  }
}
