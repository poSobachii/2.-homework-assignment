package Webshop.BasketPack;

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
        assertEquals(returned, "wareGrp");
    }

    @Test
    void getId(){
        Long returned = newOrder.getWareID();
        assertEquals(returned, 100);
    }
}
