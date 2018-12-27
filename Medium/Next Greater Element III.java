class Solution {
    public int nextGreaterElement(int n) {
        int[] arr = getArr(n);
        int i;
        for (i=arr.length-1; i>0; i--) {
            if (arr[i-1] < arr[i]) {
                break;
            }
        }

        if (i == 0) {
            return -1;
        }

        int num = arr[i-1];
        int small = i;
        for (int j=i+1; j<arr.length; j++) {
            if (arr[j] > num && arr[j] <= arr[small]) {
                small = j;
            }
        }

        int temp = arr[i-1];
        arr[i-1] = arr[small];
        arr[small] = temp;

        Arrays.sort(arr, i, arr.length);
        long ans = getNumber(arr);
        
        return ans <= Integer.MAX_VALUE ? (int) ans : -1;
    }

    private long getNumber(int[] arr) {
        long num = 0;
        for (int i=0; i<arr.length; i++) {
            num = num * 10 + arr[i];
        }

        return num;
    }

    private int[] getArr(int n) {
        int[] arr = new int[String.valueOf(n).length()];
        int i = arr.length - 1;
        while (i >= 0) {
            arr[i] = n % 10;
            n /= 10;
            i--;
        }

        return arr;
    }
}
