class ProductOfNumbers {

  private List<Integer> list;
  
  public ProductOfNumbers() {
    this.list = new ArrayList<>();
    add(0);
  }

  public void add(int num) {
    if (num > 0) {
      list.add(list.get(list.size() - 1) * num);
    } else {
      list = new ArrayList<>();
      list.add(1);
    }
  }

  public int getProduct(int k) {
    int n = list.size();
    return k < n ? list.get(n - 1) / list.get(n - k - 1) : 0;
  }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
