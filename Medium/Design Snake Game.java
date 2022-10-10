class SnakeGame {
  
  private final int width;
  private final int height;
  private final Set<Pair<Integer, Integer>> body;
  private final Deque<Pair<Integer, Integer>> bodyQueue;
  private final Queue<Pair<Integer, Integer>> foodQueue;
  private int foodPoint;

  public SnakeGame(int width, int height, int[][] food) {
    this.width = width;
    this.height = height;
    this.body = new HashSet<>();
    this.bodyQueue = new LinkedList<>();
    this.body.add(new Pair<Integer, Integer>(0, 0));
    this.bodyQueue.add(new Pair<Integer, Integer>(0, 0));
    
    this.foodQueue = new LinkedList<>();
    for (int[] fd : food) {
      foodQueue.add(new Pair<Integer, Integer>(fd[0], fd[1]));
    }
    this.foodPoint = 0;
  }

  public int move(String direction) {
    Pair<Integer, Integer> currPosition = bodyQueue.peekLast();
    Pair<Integer, Integer> nextPosition = move(currPosition, direction);
    if (!isSnakeAlive(nextPosition)) {
      return -1;
    }
    if (!snakeAteFood(nextPosition)) {
      body.remove(bodyQueue.pollFirst());
      bodyQueue.addLast(nextPosition);
      body.add(nextPosition);
    }
    return foodPoint;
  }
  
  private Pair<Integer, Integer> move(Pair<Integer, Integer> currPosition, String direction) {
    int row = currPosition.getKey();
    int col = currPosition.getValue();
    switch (direction) {
      case "U":
        row--;
        break;
      case "D":
        row++;
        break;
      case "L":
        col--;
        break;
      case "R":
        col++;
        break;
      default:
        break;
    }
    return new Pair<Integer, Integer>(row, col);
  }
  
  private boolean isSnakeAlive(Pair<Integer, Integer> position) {
    int row = position.getKey();
    int col = position.getValue();
    // Snake touched the boundary
    if (!(row >= 0 && col >= 0 && row < height && col < width)) {
      return false;
    }
    // Snake bit somewhere in middle of the body
    if (!position.equals(this.bodyQueue.peekFirst()) && this.body.contains(position)) {
      return false;
    }
    return true;
  }
  
  private boolean snakeAteFood(Pair<Integer, Integer> position) {
    if (!foodQueue.isEmpty() && position.equals(foodQueue.peek())) {
      bodyQueue.addLast(position);
      body.add(position);
      foodQueue.poll();
      foodPoint++;
      return true;
    }
    return false;
  }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
