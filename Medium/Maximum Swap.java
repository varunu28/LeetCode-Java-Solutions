class Solution {
  public int maximumSwap(int num) {
    String stringValue = Integer.toString(num);
    Map<Integer, Integer> valToIndexMap = new HashMap<>();
    int[] digits = new int[String.valueOf(num).length()];
    for (int i = digits.length - 1; i >= 0; i--) {
      int digit = num % 10;
      num /= 10;
      digits[i] = digit;
      valToIndexMap.putIfAbsent(digit, i);
    }
    for (int i = 0; i < digits.length; i++) {
      for (int k = 9; k > digits[i]; k--) {
        if (valToIndexMap.getOrDefault(k, -1) > i) {
          int swapIndex = valToIndexMap.get(k);
          return Integer.parseInt(
              stringValue.substring(0, i) // Digits before swap index
                  + k // Swapped value
                  + stringValue.substring(i + 1, swapIndex) // Digits after original index(i) and before swappedIndex
                  + digits[i] // Digit at original index(i)
                  + ((swapIndex + 1) != stringValue.length() // Check if swapIndex is last digit of num
                      ? stringValue.substring(swapIndex + 1) // If not then add digits that come after the swapIndex
                      : "")); // Else add an empty string
        }
      }
    }
    return Integer.parseInt(stringValue);
  }
}
