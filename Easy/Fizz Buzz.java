class Solution {
  public List<String> fizzBuzz(int n) {
    return IntStream.range(1, n + 1)
        .boxed()
        .map(e -> (
                e % 3 == 0 && e % 5 == 0 ? "FizzBuzz"
                    : (e % 3 == 0 ? "Fizz" : (e % 5 == 0 ? "Buzz" : String.valueOf(e)))
            )
        ).collect(Collectors.toList());
  }
}
