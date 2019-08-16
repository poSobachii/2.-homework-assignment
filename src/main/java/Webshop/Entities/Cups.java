package Webshop.Entities;

import Webshop.WareTemplates.BasicWare;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CUPS")
public class Cups extends BasicWare {

    Cups() {
    }

    public Cups(Long id, String wareName, Double warePrice, String priceQuantity, String description) {
        super(id, wareName, warePrice, priceQuantity, description);
    }

    public Cups(String wareName, Double warePrice, String priceQuantity, String description) {
        super( wareName, warePrice, priceQuantity, description);
    }

}