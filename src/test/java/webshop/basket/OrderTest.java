package webshop.basket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OrderTest {

    Order newOrder;

    @Before
    public void setup(){
        newOrder = new Order("wareGrp", Long.valueOf(100));
    }

    @Test
    public void getWaregrp(){
        String returned = newOrder.getWareType();
        assertEquals( "wareGrp", returned);
    }

    @Test
    public void getId(){
        Long returned = newOrder.getWareID();
        assertEquals(100, returned, 0);
    }

    @Test
    public void sonarException(){
        newOrder.setWareID(Long.valueOf(120));
        newOrder.setWareType("Someware");
    }
}
