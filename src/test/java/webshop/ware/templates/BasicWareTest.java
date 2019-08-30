package webshop.ware.templates;

import org.junit.Test;

public class BasicWareTest {

    @Test
    public void sonarException(){
        BasicWare basicWare = new BasicWare();
        BasicWare basicWare2 = new BasicWare("SomeWareName", 0.99, "3", "desc");
        basicWare.setDescription("new desc");
        basicWare.setId(Long.valueOf(87442));
        basicWare.setPriceQuantity("16");
        basicWare.setWareName("newName");
        basicWare.setWarePrice(1.99);
    }
}
