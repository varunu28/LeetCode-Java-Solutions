class Solution {
    public int sumOfMultiples(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(value -> value % 3 == 0 || value % 5 == 0 || value % 7 == 0)
                .sum();
    }
}
