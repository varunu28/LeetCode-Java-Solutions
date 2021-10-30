import java.util.Map.Entry;

class Solution {
  public String kthDistinct(String[] arr, int k) {
    return Arrays.stream(arr).collect(
            Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(entry -> entry.getValue().equals(1L)).map(Entry::getKey)
        .skip(k - 1)
        .findFirst().orElse("");
  }
}
