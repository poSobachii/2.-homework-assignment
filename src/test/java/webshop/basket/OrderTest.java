package webshop.basket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    Order newOrder;

    @BeforeEach
    void setup(){
        newOrder = new Order("wareGrp", Long.valueOf(100));
    }

    @Test
    void getWaregrp(){
        String returned = newOrder.getWareType();
        assertEquals( "wareGrp", returned);
    }

    @Test
    void getId(){
        Long returned = newOrder.getWareID();
        assertEquals( 100, returned);
    }
}
