class ParkingSystem {
  int[] slots;
  public ParkingSystem(int big, int medium, int small) {
    slots = new int[]{big, medium, small};
  }

  public boolean addCar(int carType) {
    if (slots[carType - 1] == 0) {
      return false;
    }
    slots[carType - 1]--;
    return true;
  }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
