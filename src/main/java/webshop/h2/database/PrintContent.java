package webshop.h2.database;


import webshop.ware.templates.BasicWare;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintContent {

    static List<BasicWare> temp;

    public static void PrintWares( List<?> content){

        temp = (List<BasicWare>) content;
    }


    public static StringBuilder write(){
        StringBuilder stringBuilder = new StringBuilder();
        for (BasicWare e: temp) {
            Long id = e.getId();
            String title = e.getWareName();
            double price = e.getWarePrice();
            stringBuilder.append
                    ("<div class=\"col-sm-4\" style=\"background-color:transparent;\">" +
                            "<form action=\"wareInfo\">" +
                            "<input type=\"hidden\" name=\"wareGroup\" value=\"" + e.getClass().getSimpleName() + "\">" +
                            "<input type=\"hidden\" name=\"wareID\" value=\"" + id + "\">" +
                            "<input type=\"image\" <img src=\"pics/"+ e.getClass().getSimpleName() + "/" + id + ".png\"" +
                            " width=\"250\" height=\"225\" alt=\"there is no picture :(\" />" +
                            "</form>" +
                            "<form action=\"wareInfo\">" +
                            "<input type=\"hidden\" name=\"wareGroup\" value=\"" + e.getClass().getSimpleName() + "\">" +
                            "<input type=\"hidden\" name=\"wareID\" value=\"" + id + "\">" +
                            "<input type=\"submit\" value=\"" + title + "\">" +
                            "</form>" +
                            "</br> Cost: " + price + " EUR." +
                            "</br><form name = \"addToBasket\">" +
                            "<input type=\"hidden\" name=\"basketValue\" value=\"" + id + "\">" +
                            "<input type=\"button\" value=\"Add to basket\"" +
                            " onclick=\"return add_to_basket(" +
                            "\'" + e.getClass().getSimpleName() + "\',\'" + title + "\'," + id +
                            ")\"></form></div>\n");
        }
        return stringBuilder;
    }
}
