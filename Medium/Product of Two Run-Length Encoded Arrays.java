class Solution {
  public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
    int idxOne = 0;
    int idxTwo = 0;
    List<List<Integer>> result = new ArrayList<>();
    while (idxOne < encoded1.length && idxTwo < encoded2.length) {
      int valueOne = encoded1[idxOne][0];
      int frequencyOne = 0;
      while (idxOne < encoded1.length && encoded1[idxOne][0] == valueOne) {
        frequencyOne += encoded1[idxOne++][1];
      }
      idxOne--;
      encoded1[idxOne][1] = frequencyOne;
      int valueTwo = encoded2[idxTwo][0];
      int frequencyTwo = 0;
      while (idxTwo < encoded2.length && encoded2[idxTwo][0] == valueTwo) {
        frequencyTwo += encoded2[idxTwo++][1];
      }
      idxTwo--;
      encoded2[idxTwo][1] = frequencyTwo;
      int prod = encoded1[idxOne][0] * encoded2[idxTwo][0];
      int frequency = Math.min(encoded1[idxOne][1], encoded2[idxTwo][1]);
      if (result.size() > 0 && result.get(result.size() - 1).get(0) == prod) {
        result.get(result.size() - 1).set(1, result.get(result.size() - 1).get(1) + frequency);
      } else {
        result.add(Arrays.asList(prod, frequency));
      }
      encoded1[idxOne][1] -= frequency;
      encoded2[idxTwo][1] -= frequency;
      if (encoded1[idxOne][1] == 0) {
        idxOne++;
      }
      if (encoded2[idxTwo][1] == 0) {
        idxTwo++;
      }
    }
    return result;
  }
}
