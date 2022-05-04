package test.cards;

public class MasterCard implements Card{
    public Boolean validCard(String cardNumber){
        Integer first = Integer.parseInt(cardNumber.substring(0,1));
        Integer second = Integer.parseInt(cardNumber.substring(1,2));
        Integer length = cardNumber.length();

        if (first == 5 && second >= 1 && second <=5 && length == 16){
            // Mastercard: has length 16. Begins with 5 and the 2nd digit begins from 1 to 5 inclusive
            return true;
        }
        return false;
    }
}
