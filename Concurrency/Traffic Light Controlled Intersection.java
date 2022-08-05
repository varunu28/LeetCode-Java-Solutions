class TrafficLight {

  private boolean greenOnRoadA;
  private ReentrantLock lock;
  
  public TrafficLight() {
    this.greenOnRoadA = true;
    this.lock = new ReentrantLock();
  }

  public void carArrived(
      int carId,           // ID of the car
      int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
      int direction,       // Direction of the car
      Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
      Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
  ) {
    this.lock.lock();
    if(greenOnRoadA && roadId==2 || !greenOnRoadA && roadId==1){
      greenOnRoadA = !greenOnRoadA;
      turnGreen.run();
    }
    crossCar.run();
    this.lock.unlock();     
  }
}
