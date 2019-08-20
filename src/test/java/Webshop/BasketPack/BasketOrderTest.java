package Webshop.BasketPack;

import Webshop.Entities.Cups;
import Webshop.H2database.DatabaseCommander;
import Webshop.WareTemplates.BasicWare;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


public class BasketOrderTest {

    List<BasicWare> wareList = new ArrayList<>();
    BasicWare basicWare;

    @InjectMocks
    BasketOrder basketOrder;
    @Mock
    DatabaseCommander databaseCommander;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        basicWare = new Cups(Long.valueOf(1), "WareName", 10.99, "10", "WareDescription" );
    }


    @Test
    void addOrderTest(){
        when(databaseCommander.getOneItem("wareType", Long.parseLong("10"))).thenReturn(basicWare);
        basketOrder.addOrder("wareType", "10");
        assertTrue(!basketOrder.getWareList().isEmpty());

    }

    @Test
    void writeTest(){
        wareList.add(basicWare);
        ReflectionTestUtils.setField(basketOrder, "wareList", wareList);
        String result = basketOrder.write().toString();
        Assert.assertThat(result, containsString("pics/Cups/1.png"));
    }

}

