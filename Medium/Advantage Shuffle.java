class Solution {
  public int[] advantageCount(int[] A, int[] B) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int num : A) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int[] result = new int[A.length];
    Arrays.fill(result, Integer.MIN_VALUE);
    List<Integer> indexesNotPopulated = new ArrayList<>();
    for (int i = 0; i < B.length; i++) {
      Integer upper = map.higherKey(B[i]);
      if (upper != null) {
        result[i] = upper;
        map.put(upper, map.get(upper) - 1);
        if (map.get(upper) == 0) {
          map.remove(upper);
        }
      } else {
        indexesNotPopulated.add(i);
      }
    }
    Iterator<Integer> iterator = indexesNotPopulated.iterator();
    for (Integer key : map.keySet()) {
      int value = map.get(key);
      while (value-- > 0) {
        result[iterator.next()] = key;
      }
    }
    return result;
  }
}
