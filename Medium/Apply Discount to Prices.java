class Solution {
  public String discountPrices(String sentence, int discount) {
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    int n = sentence.length();
    while (idx < n) {
      if (sentence.charAt(idx) == '$') {
        if (idx == 0 || sentence.charAt(idx - 1) == ' ') {
          sb.append(sentence.charAt(idx++));
          StringBuilder possibleDigit = new StringBuilder();
          boolean isDigit = true;
          while (idx < n && sentence.charAt(idx) != ' ') {
            if (!Character.isDigit(sentence.charAt(idx))) {
              isDigit = false;
            }
            possibleDigit.append(sentence.charAt(idx++));
          }
          if (possibleDigit.length() == 0) {
            continue;
          }
          if (isDigit) {
            long price = Long.parseLong(possibleDigit.toString());
            long updatedPrice = price * (100 - discount);
            sb.append(getFormattedPrice(updatedPrice));
          } else {
            sb.append(possibleDigit);
          }
        } else {
          sb.append(sentence.charAt(idx++));
        }
      } else {
        sb.append(sentence.charAt(idx++));
      }
    }
    return sb.toString();
  }
  
  private String getFormattedPrice(long price) {
    if (price < 10) {
      return "0.0" + price;
    } else if (price < 100) {
      return "0." + price;
    } else {
      String priceString = String.valueOf(price);
      return priceString.substring(0, priceString.length() - 2) + "." + priceString.substring(priceString.length() - 2);
    }
  }
}
