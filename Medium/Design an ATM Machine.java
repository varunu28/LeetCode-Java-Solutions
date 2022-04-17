class ATM {

  private long[] noteCount;
  private int[] noteValue;

  public ATM() {
    this.noteCount = new long[5];
    this.noteValue = new int[]{20, 50, 100, 200, 500};
  }

  public void deposit(int[] banknotesCount) {
    for (int i = 0; i < banknotesCount.length; i++) {
      this.noteCount[i] += banknotesCount[i];
    }
  }

  public int[] withdraw(int amount) {
    int[] resultNoteCount = new int[5];
    for (int i = this.noteValue.length - 1; i >= 0 && amount > 0; i--) {
      if (amount >= this.noteValue[i]) {
        long numOfNotes = Math.min(amount / this.noteValue[i], this.noteCount[i]);
        amount -= this.noteValue[i] * numOfNotes;
        resultNoteCount[i] = (int) numOfNotes;
      }
    }
    if (amount > 0) {
      return new int[]{-1};
    }
    if (amount == 0) {
      for (int i = 0; i < resultNoteCount.length; i++) {
        this.noteCount[i] -= resultNoteCount[i];
      }
    }
    return resultNoteCount;
  }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
