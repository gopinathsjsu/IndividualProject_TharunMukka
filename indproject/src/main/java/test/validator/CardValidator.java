package test.validator;

import test.Models.Booking;
import test.Services.OrderService;
import test.cards.*;
import test.storage.OutputStorage;

public class CardValidator extends BaseValidator {

    private Card cardObject;
    public CardValidator(){
        super();
    }

    // strategry pattern to set the card object
    public void setCardObject(Card cardObject){
        this.cardObject = cardObject;
    }

    @Override
    public void isValid(Booking booking){
        OutputStorage outputStorage = OutputStorage.getOutputStorageInstance();
        OrderService orderService = new OrderService();

        if(cardValidationHelper(booking.getCardNumber())){
            // if card is valid, call booking service
            orderService.bookFlight(booking);
        }
        else {
            // write to output error storage
            outputStorage.addError("Please enter correct booking details for " + booking.getBookingName() +
                    ": Invalid Card Details");
        }
    }

    public Boolean cardValidationHelper(String cardNumber){
        Integer first = Integer.parseInt(cardNumber.substring(0,1));
        Integer second = Integer.parseInt(cardNumber.substring(1,2));
        Integer fourDigits = Integer.parseInt(cardNumber.substring(0,4));
        Integer length = cardNumber.length();

        if(first == 4 && (length == 13 || length == 16)){
            // Visa card: has length either 13 or 16. It begins with a 4
            setCardObject(new VisaCard());
            return cardObject.validCard(cardNumber);
        }
        else if (first == 5 && second >= 1 && second <=5 && length == 16){
            // Mastercard: has length 16. Begins with 5 and the 2nd digit begins from 1 to 5 inclusive
            setCardObject(new MasterCard());
            return cardObject.validCard(cardNumber);
        }
        else if(fourDigits == 6011 && length == 16){
            // Discover: length 16, and the first 4 digits begins from 6011
            setCardObject(new DiscoverCard());
            return cardObject.validCard(cardNumber);
        }
        else if(length == 15 && first ==3 && (second == 4 || second == 7)){
            // Amex: has length 15 and starts with 3. 2nd digit must be 4 or 7
            setCardObject(new AmexCard());
            return cardObject.validCard(cardNumber);
        }
        return false;
    }

    public Card getCardObject(){
        return cardObject;
    }
}
