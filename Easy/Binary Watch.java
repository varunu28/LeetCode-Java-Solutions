class Solution {
  public List<String> readBinaryWatch(int turnedOn) {
    return IntStream.range(0, 12)
        .boxed()
        .flatMap(
            h -> IntStream.range(0, 60)
                .boxed()
                .filter(s -> Integer.bitCount(h) + Integer.bitCount(s) == turnedOn)
                .map(m -> String.format("%d:%02d", h, m))
        )
        .collect(Collectors.toList());
  }
}
