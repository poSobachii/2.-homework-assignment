package webshop.h2.database;

import webshop.ware.templates.BasicWare;
import org.springframework.stereotype.Service;

@Service
public class OneWareInfoPrint {

    static BasicWare wareToPrint;


    public void oneWareInfo(BasicWare wareTemplate){
        this.wareToPrint = wareTemplate;

    }

    public static StringBuilder write(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("results are: </br>" +
                wareToPrint.getWareName() + "</br>" +
                wareToPrint.getWarePrice() + "</br>" +
                wareToPrint.getPriceQuantity() + "</br>" +
                wareToPrint.getDescription());
        return stringBuilder;
    }

    public BasicWare getWareToPrint() {
        return wareToPrint;
    }
}
