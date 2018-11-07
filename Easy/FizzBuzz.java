class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        
        for (int i=1; i <= n; i++) {
            list.add((i%3 != 0 && i % 5 != 0) ? String.valueOf(i) : (i % 3 == 0 ? "Fizz" : "") + (i % 5 == 0 ? "Buzz" : ""));
        }

        return list;
    }
}
