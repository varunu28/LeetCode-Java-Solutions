class StringIterator {
    int letterPointer = 0;
    int numberPointer = letterPointer + 1;
    int counter;
    char c;
    String s;
    StringBuilder num;

    public StringIterator(String compressedString) {
        s = compressedString;
        c = s.charAt(letterPointer);
        
        num = new StringBuilder();
        while (numberPointer<s.length() && Character.isDigit(s.charAt(numberPointer))) {
            num.append(s.charAt(numberPointer));
            numberPointer++;
        }
        counter = Integer.parseInt(num.toString());

        letterPointer = numberPointer;
        numberPointer = letterPointer + 1;
    }

    public char next() {
        if (counter == 0) {
            if (numberPointer <= s.length()-1) {
                c = s.charAt(letterPointer);
                num = new StringBuilder();
                while (numberPointer<s.length() && Character.isDigit(s.charAt(numberPointer))) {
                    num.append(s.charAt(numberPointer));
                    numberPointer++;
                }
                counter = Integer.parseInt(num.toString()) - 1;

                letterPointer = numberPointer;
                numberPointer = letterPointer + 1;
            }
            else {
                c = ' ';
            }
        }
        else {
            counter--;
        }

        return c;
    }

    public boolean hasNext() {
        if (counter == 0) {
            if (numberPointer > s.length()-1) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
