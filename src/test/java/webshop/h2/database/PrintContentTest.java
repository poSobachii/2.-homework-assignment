package webshop.h2.database;

import webshop.entities.TShirtsv2;
import webshop.ware.templates.BasicWare;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;

public class PrintContentTest {

    @InjectMocks
    PrintContent printContent;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        BasicWare basicWare = new TShirtsv2(Long.valueOf(1), "WareName", 10.99, "10", "WareDescription" );
        List<BasicWare> basicWareList = new ArrayList<>();
        basicWareList.add(basicWare);
        ReflectionTestUtils.setField(printContent, "temp", basicWareList);
    }

    @Test
    public void writeTest(){
        String result = printContent.write().toString();
        Assert.assertThat(result, containsString("onclick=\"return add_to_basket('TShirtsv2','WareName',1)"));
    }
}
