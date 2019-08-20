package webshop.ware.templates;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BasicWare {

    private @Id
    @GeneratedValue
    Long id;

    @Column(name = "WARETYPE")
    private String wareName;

    @Column(name = "PRICE")
    private Double warePrice;

    @Column(name = "QTY")
    private String priceQuantity;

    @Column(name = "INFO")
    private String description;

    public BasicWare(){

    }

    public BasicWare(Long id, String wareName, Double warePrice, String priceQuantity, String description) {
        this.id = id;
        this.wareName = wareName;
        this.warePrice = warePrice;
        this.priceQuantity = priceQuantity;
        this.description = description;
    }

    public BasicWare(String wareName, Double warePrice, String priceQuantity, String description) {
        this.wareName = wareName;
        this.warePrice = warePrice;
        this.priceQuantity = priceQuantity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public Double getWarePrice() {
        return warePrice;
    }

    public void setWarePrice(Double warePrice) {
        this.warePrice = warePrice;
    }

    public String getPriceQuantity() {
        return priceQuantity;
    }

    public void setPriceQuantity(String priceQuantity) {
        this.priceQuantity = priceQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
