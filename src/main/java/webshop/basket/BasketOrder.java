package webshop.basket;

import webshop.h2.database.DatabaseCommander;
import webshop.repositories.BalloonRepository;
import webshop.ware.templates.BasicWare;
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

    public List<BasicWare> getWareList() {
        return wareList;
    }
}
