import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void calculateItem() {
        assertEquals(6, ShoppingCart.calculateItem(2,3));
        assertEquals(0, ShoppingCart.calculateItem(0,3));
        assertEquals(0, ShoppingCart.calculateItem(2,0));
    }
}