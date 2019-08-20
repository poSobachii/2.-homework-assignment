package webshop.entities;

import webshop.ware.templates.BasicWare;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SHIRTSTWO")
public class TShirtsv2 extends BasicWare {

    TShirtsv2() {
    }

    public TShirtsv2(Long id, String wareName, Double warePrice, String priceQuantity, String description) {
        super(id, wareName, warePrice, priceQuantity, description);
    }

    public TShirtsv2(String wareName, Double warePrice, String priceQuantity, String description) {
        super(wareName, warePrice, priceQuantity, description);
    }

}