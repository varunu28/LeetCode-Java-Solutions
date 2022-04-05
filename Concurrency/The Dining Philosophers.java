class DiningPhilosophers {
  
  private List<Semaphore> forks;
  private Semaphore dinersOnTable;
  private List<String> state;
  
  public DiningPhilosophers() {
    this.forks = new ArrayList<>();
    this.state = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      this.forks.add(new Semaphore(1));
      this.state.add("idle");
    }
    this.dinersOnTable = new Semaphore(4);
  }

  // call the run() method of any runnable to execute its code
  public void wantsToEat(int philosopher,
                         Runnable pickLeftFork,
                         Runnable pickRightFork,
                         Runnable eat,
                         Runnable putLeftFork,
                         Runnable putRightFork) throws InterruptedException {
    int leftForkIdx = philosopher;
    int rightForkIdx = (philosopher + 4) % 5;
    
    this.dinersOnTable.acquire();
    if (this.state.get(philosopher).equals("eating")) {
      this.dinersOnTable.release();
      return;
    }
    this.state.set(philosopher, "eating");
    pickFork(leftForkIdx, pickLeftFork);
    pickFork(rightForkIdx, pickRightFork);
    eat.run();
    putFork(rightForkIdx, putRightFork);
    putFork(leftForkIdx, putLeftFork);
    this.state.set(philosopher, "idle");
    this.dinersOnTable.release();
  }
  
  private void putFork(int idx, Runnable put) {
    put.run();
    this.forks.get(idx).release();
  }
  
  private void pickFork(int idx, Runnable pick) throws InterruptedException  {
    this.forks.get(idx).acquire();
    pick.run();
  }
}
