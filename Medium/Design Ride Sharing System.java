class RideSharingSystem {

    private final Queue<Integer> riderQueue;
    private final Set<Integer> riderSet;
    private final Queue<Integer> driverQueue;
    private final Set<Integer> cancelledRiders;

    public RideSharingSystem() {
        this.riderQueue = new LinkedList<>();
        this.driverQueue = new LinkedList<>();
        this.cancelledRiders = new HashSet<>();
        this.riderSet = new HashSet<>();
    }
    
    public void addRider(int riderId) {
        riderQueue.add(riderId);
        riderSet.add(riderId);
    }
    
    public void addDriver(int driverId) {
        driverQueue.add(driverId);
    }
    
    public int[] matchDriverWithRider() {
        while (!riderQueue.isEmpty() && cancelledRiders.contains(riderQueue.peek())) {
            cancelledRiders.remove(riderQueue.remove());
        }
        if (riderQueue.isEmpty() || driverQueue.isEmpty()) {
            return new int[]{-1, -1};
        }
        int rider = riderQueue.remove();
        riderSet.remove(rider);
        return new int[]{driverQueue.remove(), rider};
    }
    
    public void cancelRider(int riderId) {
        if (!riderSet.contains(riderId)) {
            return;
        }
        cancelledRiders.add(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */
