package webshop.entities;

import webshop.ware.templates.BasicWare;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BALLOONS")
public class Balloons extends BasicWare {

    Balloons() {
    }

    public Balloons(Long id, String wareName, Double warePrice, String priceQuantity, String description) {
        super(id, wareName, warePrice, priceQuantity, description);
    }

    public Balloons(String wareName, Double warePrice, String priceQuantity, String description) {
        super(wareName, warePrice, priceQuantity, description);
    }
}