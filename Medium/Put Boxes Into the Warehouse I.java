class Solution {
  public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
    Arrays.sort(boxes);
    for (int i = 1; i < warehouse.length; i++) {
      warehouse[i] = Math.min(warehouse[i - 1], warehouse[i]);
    }
    int count = 0;
    for (int i = warehouse.length - 1; i >= 0; i--) {
      if (count < boxes.length && boxes[count] <= warehouse[i]) {
        count++;
      }
    }
    return count;
  }
}
