class Solution {
  public String restoreString(String s, int[] indices) {
    char[] letters = s.toCharArray();
    for (int i = 0; i < indices.length; i++) {
      while (indices[i] != i) {
        swapLetter(letters, i, indices[i]);
        swapIndex(indices, i, indices[i]); 
      }
    }
    return String.valueOf(letters);
  }

  private void swapLetter(char[] arr, int idxOne, int idxTwo) {
    char temp = arr[idxOne];
    arr[idxOne] = arr[idxTwo];
    arr[idxTwo] = temp;
  }

  private void swapIndex(int[] arr, int idxOne, int idxTwo) {
    int temp = arr[idxOne];
    arr[idxOne] = arr[idxTwo];
    arr[idxTwo] = temp;
  }
}
