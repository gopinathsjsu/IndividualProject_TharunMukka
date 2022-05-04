package test.card;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import test.cards.MasterCard;
import test.validator.CardValidator;

import static org.junit.Assert.*;


public class CardTest {

    @InjectMocks
    private CardValidator cardValidator;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void checkCardObject(){
        String cardNumber = "5410000000000000";

        MasterCard masterCard = new MasterCard();
        Boolean c = cardValidator.cardValidationHelper(cardNumber);
        cardValidator.getCardObject();
        assertEquals(masterCard.getClass(), cardValidator.getCardObject().getClass());
    }
}
