class Cashier {
  int n;
  int discount;
  int currCount;
  Map<Integer, Integer> priceMap;
  public Cashier(int n, int discount, int[] products, int[] prices) {
    this.n = n;
    this.currCount = 0;
    this.discount = discount;
    priceMap = new HashMap<>();
    for (int i = 0; i < products.length; i++) {
      priceMap.put(products[i], prices[i]);
    }
  }

  public double getBill(int[] product, int[] amount) {
    currCount++;
    double totalBill = 0;
    for (int i = 0; i < product.length; i++) {
      totalBill += amount[i] * priceMap.get(product[i]);
    }
    if (currCount % n == 0) {
      totalBill -= getDiscount(totalBill);
    }
    return totalBill;
  }
  
  private double getDiscount(double totalBill) {
    return (totalBill * discount) / 100;
  }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
