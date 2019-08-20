package Webshop.BasketPack;

import Webshop.H2database.DatabaseCommander;
import Webshop.Repository.BalloonRepository;
import Webshop.WareTemplates.BasicWare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketOrder {


    private static DatabaseCommander databaseCommander;
    static List<BasicWare> wareList = new ArrayList<>();

    @Autowired
    public BasketOrder(DatabaseCommander dbCommander){
        BasketOrder.databaseCommander = dbCommander;
    }

    @Autowired
    BalloonRepository balloonRepository;

    public static void addOrder(String wareType, String wareCode) {
        wareList.add(databaseCommander.getOneItem(wareType, Long.parseLong(wareCode)));
    }



    public static void printJSBasket(){
        System.out.println("size is: " + wareList.size());
            int order = 1;
            for ( BasicWare r : wareList ) {
            System.out.println("order No:" + order + " - " + r.getWareName()
                    + "," + r.getId());
            ++order;
            }
    }

    public static StringBuilder write() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BasicWare e : wareList) {
            stringBuilder.append("<div class=\"col-sm-4\" style=\"background-color:transparent;\">" +
                    "<img src=\"pics/" + e.getClass().getSimpleName() + "/" + e.getId() + ".png\" +\n" +
                    "                             width=\"250\" height=\"225\" alt=\"there is no picture :(\" />"+
                    e.getWareName() + "</br>" +
                    e.getWarePrice() + "</br>" +
                    e.getPriceQuantity() + "</br>" +
                    e.getDescription() + "</div>");

        }
        return stringBuilder;
    }

    public static List<BasicWare> getWareList() {
        return wareList;
    }
}
