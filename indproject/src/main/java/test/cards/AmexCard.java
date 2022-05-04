package test.cards;

public class AmexCard implements Card{
    public Boolean validCard(String cardNumber){
        Integer first = Integer.parseInt(cardNumber.substring(0,1));
        Integer second = Integer.parseInt(cardNumber.substring(1,2));
        Integer length = cardNumber.length();

        if(length == 15 && first ==3 && (second == 4 || second == 7)){
            // Amex: has length 15 and starts with 3. 2nd digit must be 4 or 7
            return true;
        }
        return false;
    }
}
