class SnakeGame {
    
    private final Deque<int[]> snake;
    private final Queue<int[]> foodQueue;
    private final Set<String> snakeBody;
    private final int width;
    private final int height;
    private int score;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.snake = new ArrayDeque<>();
        this.snake.addFirst(new int[]{0, 0});
        this.foodQueue = new LinkedList<>();
        this.foodQueue.addAll(Arrays.asList(food));
        this.snakeBody = new HashSet<>();
        this.snakeBody.add(0 + "|" + 0);
        this.width = width;
        this.height = height;
        this.score = 0;
    }
    
    public int move(String direction) {
        int[] nextMove = getNextMove(direction);
        if (!isMoveWithInBound(nextMove)) {
            return -1;
        }
        moveSnake(nextMove);
        if (isBitingItself(nextMove)) {
            return -1;
        }
        this.snakeBody.add(nextMove[0] + "|" + nextMove[1]);
        return score;
    }
    
    private int[] getNextMove(String direction) {
        int[] nextMove = Arrays.copyOf(this.snake.peekFirst(), 2);
        switch (direction) {
            case "L" -> nextMove[1]--;
            case "R" -> nextMove[1]++;
            case "U" -> nextMove[0]--;
            case "D" -> nextMove[0]++;
            default -> {}
        }
        return nextMove;
    }
    
    private boolean isMoveWithInBound(int[] move) {
        int x = move[0];
        int y = move[1];
        return x >= 0 && y >= 0 && x < this.height && y < this.width;
    }
    
    private void moveSnake(int[] move) {
        this.snake.addFirst(move);
        if (snakeEatsFood(move)) {
            this.foodQueue.remove();
            this.score++;
        } else {
            int[] tail = this.snake.removeLast();
            this.snakeBody.remove(tail[0] + "|" + tail[1]);
        }
    }
    
    private boolean snakeEatsFood(int[] move) {
        return !this.foodQueue.isEmpty() && move[0] == this.foodQueue.peek()[0] && move[1] == this.foodQueue.peek()[1];
    }
    
    private boolean isBitingItself(int[] move) {
        String key = move[0] + "|" + move[1];
        return this.snakeBody.contains(key);
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
