class Solution {
  public int[] findEvenNumbers(int[] digits) {
    List<Integer> list = new ArrayList<>();
    int[] counter = new int[10];
    for (int digit : digits) {
      counter[digit]++;
    }
    for (int digitOne = 1; digitOne <= 9; digitOne++) {
      if (counter[digitOne] > 0) {
        counter[digitOne]--;
        for (int digitTwo = 0; digitTwo <= 9; digitTwo++) {
          if (counter[digitTwo] > 0) {
            counter[digitTwo]--;
            for (int digitThree = 0; digitThree <= 8; digitThree += 2) {
              if (counter[digitThree] > 0) {
                list.add(digitOne * 100 + digitTwo * 10 + digitThree);
              }
            }
            counter[digitTwo]++;
          }
        }
        counter[digitOne]++;
      }
    }
    int[] result = new int[list.size()];
    int idx = 0;
    for (int num : list) {
      result[idx++] = num;
    }
    Arrays.sort(result);
    return result;
  }
}
