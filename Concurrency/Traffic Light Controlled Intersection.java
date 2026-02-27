class TrafficLight {

    private ReentrantLock lock;
    private boolean isGreen;

    public TrafficLight() {
        lock = new ReentrantLock();
        isGreen = true;
    }
    
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) {
        lock.lock();
        try {
            if (!isGreen && roadId == 1 || isGreen && roadId == 2) {
                isGreen = !isGreen;
                turnGreen.run();
            }
            crossCar.run();
        } finally {
            lock.unlock();
        }

    }
}
