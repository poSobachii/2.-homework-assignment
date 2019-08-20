package webshop.entities;


import webshop.ware.templates.BasicWare;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SHIRTS")
public class TShirts extends BasicWare {

    TShirts() {
    }

    public TShirts(Long id, String wareName, Double warePrice, String priceQuantity, String description) {
        super(id, wareName, warePrice, priceQuantity, description);
    }

    public TShirts(String wareName, Double warePrice, String priceQuantity, String description) {
        super(wareName, warePrice, priceQuantity, description);
    }

}