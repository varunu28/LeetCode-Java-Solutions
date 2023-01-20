class Solution {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i] == 0 ? 1 : 0;
        }
        int idxOne = arr.length - 1;
        int idxTwo = arr.length + count - 1;
        while (idxOne != idxTwo) {
            insertAtEnd(arr, idxOne, idxTwo--);
            if (arr[idxOne] == 0) {
                insertAtEnd(arr, idxOne, idxTwo--);
            }
            idxOne--;
        }
    }
    
    private void insertAtEnd(int[] arr, int idxOne, int idxTwo) {
        if (idxTwo < arr.length) {
            arr[idxTwo] = arr[idxOne];
        }
    }
}
