class SeatManager {

    private PriorityQueue<Integer> seats;

    public SeatManager(int n) {
        this.seats = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            this.seats.add(i);
        }
    }
    
    public int reserve() {
        return this.seats.poll();
    }
    
    public void unreserve(int seatNumber) {
        this.seats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
