package webshop.database.dao;


import webshop.ware.templates.BasicWare;

import java.util.List;

public interface DatabaseDAO {
    List<?> getAllWares(String wareType);
    BasicWare getOneItem(String wareType, Long id);
}
