package Webshop.BasketPack;

import Webshop.WareTemplates.BasicWare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;


public class BasketOrderTest {

    @InjectMocks
    BasketOrder basketOrder;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void addOrderTest(){

    }

    @Test
    void writeTest(){

    }

    @Test
    void getWareListTest(){
        List<BasicWare> basicWareList = basketOrder.getWareList();
        assertNotNull(basicWareList);
    }
}

