package Webshop.DatabaseDAO;


import Webshop.WareTemplates.BasicWare;

import java.util.List;

public interface DatabaseDAO {
    List<?> getAllWares(String wareType);
    BasicWare getOneItem(String wareType, Long id);
}
