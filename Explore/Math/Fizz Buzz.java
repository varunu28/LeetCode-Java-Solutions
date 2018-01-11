class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            if (i%3 != 0 && i%5 != 0) {
                ans.add(String.valueOf(i));
            }
            else if (i%3 == 0 && i%5 == 0) {
                ans.add("FizzBuzz");
            }
            else if(i%3 == 0) {
                ans.add("Fizz");
            }
            else {
                ans.add("Buzz");
            }
        }
        
        return ans;
    }
}
