package Webshop.H2database;

import Webshop.WareTemplates.BasicWare;
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
}
