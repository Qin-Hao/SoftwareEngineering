package ouc.cs.oceanfish.po;

/**
 * Goods class
 *
 * @author qinhao
 * @date 2019/11/17
 */

public class Goods {
    private int id;
    private int userId;
    private String name;
    private String picture;
    private double price;
    private String contactWay;
    private String address;
    private String describe;
    private String type;
    private String soldStatus;

    public Goods() {
        super();
    }

    public Goods(int id, int userId, String name, String picture, double price, String contactWay,
                 String address, String describe, String type, String soldStatus) {
        super();
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.picture = picture;
        this.price = price;
        this.contactWay = contactWay;
        this.address = address;
        this.describe = describe;
        this.type = type;
        this.soldStatus = soldStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSoldStatus() {
        return soldStatus;
    }

    public void setSoldStatus(String soldStatus) {
        this.soldStatus = soldStatus;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", contactWay='" + contactWay + '\'' +
                ", address='" + address + '\'' +
                ", describe='" + describe + '\'' +
                ", type='" + type + '\'' +
                ", soldStatus='" + soldStatus + '\'' +
                '}';
    }
}
