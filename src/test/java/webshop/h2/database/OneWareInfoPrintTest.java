package webshop.h2.database;

import webshop.ware.templates.BasicWare;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneWareInfoPrintTest {

    BasicWare basicWare;

    @InjectMocks
    OneWareInfoPrint oneWareInfoPrint;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        basicWare = new BasicWare(Long.valueOf(1), "WareName", 10.99, "10", "WareDescription" );


    }

    @Test
    void oneWareInfoTest(){
        oneWareInfoPrint.oneWareInfo(basicWare);
        BasicWare result = oneWareInfoPrint.getWareToPrint();
        assertEquals("WareName", result.getWareName() );
    }
    @Test
    void writeTest(){
        ReflectionTestUtils.setField(oneWareInfoPrint, "wareToPrint", basicWare);
        String result = oneWareInfoPrint.write().toString();
        Assert.assertThat(result, containsString("</br>WareName</br>"));
    }
}
