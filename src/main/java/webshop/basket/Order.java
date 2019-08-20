package webshop.basket;

public class Order {

    private String wareType;
    private Long wareID;

    public Order(String wareGrp, Long wareID) {
        this.wareType = wareGrp;
        this.wareID = wareID;
    }

    public String getWareType() {
        return wareType;
    }

    public void setWareType(String wareType) {
        this.wareType = wareType;
    }

    public Long getWareID() {
        return wareID;
    }

    public void setWareID(Long wareID) {
        this.wareID = wareID;
    }
}
