package test.cards;

public class DiscoverCard implements Card{
    public Boolean validCard(String cardNumber){
        Integer fourDigits = Integer.parseInt(cardNumber.substring(0,4));
        Integer length = cardNumber.length();

        if(fourDigits == 6011 && length == 16){
            // Discover: length 16, and the first 4 digits begins from 6011
            return true;
        }
        return false;
    }
}
