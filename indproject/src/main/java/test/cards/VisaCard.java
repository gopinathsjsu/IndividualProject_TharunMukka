package test.cards;

public class VisaCard implements Card{
    public Boolean validCard(String cardNumber){
        Integer first = Integer.parseInt(cardNumber.substring(0,1));
        Integer length = cardNumber.length();

        if(first == 4 && (length == 13 || length == 16)){
            // Visa card: has length either 13 or 16. It begins with a 4
            return true;
        }
        return false;
    }
}
