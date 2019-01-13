class Solution {
    int[] arr;
    public int fib(int N) {
        arr = new int[N + 1];
        return fibHelper(N);
    }
    
    private int fibHelper(int N) {
        if (N == 0) {
            return 0;
        }
        
        if (N == 1) {
            arr[1] = 1;
            return 1;
        }
        
        if (arr[N] != 0) {
            return arr[N];
        }
        
        arr[N] = fibHelper(N - 1) + fibHelper(N - 2);
        
        return arr[N];
    }
}
