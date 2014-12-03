public class CreditCard{
  
  public boolean verify(String num)
  {
    String mun = ""; 
    int evenSum = 0;
    int oddSum = 0; //instance variables
    
    if (num.length() >= 12 && num.length() <= 16){ //check to make sure card has 12 - 16 digits
      
      for ( int i = num.length() ; i > 0 ; i-- ) //reverse string method
      { 
        mun += num.substring( i - 1, i );
      } 
      
      for (int i = 1; i <= num.length() - 1;i += 2){ //for loop calulation for even number placement
        if (2 * Integer.parseInt(mun.substring(i, i + 1)) >= 10){
          evenSum += 2 * Integer.parseInt(mun.substring(i, i + 1)) - 9;
        }
        else {
          evenSum += 2 * Integer.parseInt(mun.substring(i, i + 1));
        }
      }
      
      for (int i = 0; i <= num.length() - 1;i += 2) { // for loop calculation for odd number placement
        oddSum += Integer.parseInt(mun.substring(i, i + 1));
      }
      
      if ( (evenSum + oddSum) % 10 == 0){
        return true;
      }
    }
    
    return false;
  }
  
  public static int findType(String num)
  {
    if (num.length() >= 12 && num.length() <= 16){
      if (num.substring(0, 2).equals("51") || num.substring(0, 2).equals("52") || num.substring(0, 2).equals("53") ||
          num.substring(0, 2).equals("54") || num.substring(0, 2).equals("55")) {
        return 1;
      }
      
      else if (num.substring(0, 1).equals("4")) {
        return 2;
      }
      
      else if (num.substring(0, 2).equals("34") || num.substring(0, 2).equals("37")){
        return 3;
      }
      
      else if (num.substring(0, 4).equals("6011")) {
        return 4; 
      }
      
      else if (num.substring(0, 2).equals("36") || num.substring(0, 2).equals("38") || num.substring(0, 3).equals("301")
                 || num.substring(0, 3).equals("302") || num.substring(0, 3).equals("303") || num.substring(0, 3).equals("304")
                 || num.substring(0, 3).equals("305")) {
        return 5;
      }
    }
    return 0;
  }
  
}


/*method for determining validity:
 * Determine the length of the credit card number (use s.length())
 * Even:
 *      Take all the numbers with even placement in the credit card number from right to left
 *      Multiply all the numbers by two
 *           If the numbers yield a two-digit number, then add the two numbers together
 *      Add all the single digit numbers
 *      return the sum
 * ----------------------------------------------------------------------------------------
 * Odd:
 *      Take all the numbers with odd placement in the credit card number from right to left
 *      Add all the numbers together
 *      return the sum
 * ----------------------------------------------------------------------------------------
 * Together:
 *      Add the even result and odd result
 *      If the result divided by 10 is zero, set validity to true
 *           Print to the screen that the credit card is valid*/

/*method for card type
 * If first number == 4
 *      Print to the screen that the card is a Visa
 * Else if first two numbers == 51, 52, 53, 54, or 55
 *      Print to the screen that the card is a Master Card
 * Else if first four numbers == 6011
 *      Print to the screen that the card is a Master Card
 * Else if first two numbers == 34 or 37
 *      Print to the screen that the card is an American Express Card
 * Else if first two numbers == 36 or 38 or first three digits == 300, 301, 302, 303, 304, or 305
 *      Print to the screen that the card is a Carte Blanch or Diner's
 */

