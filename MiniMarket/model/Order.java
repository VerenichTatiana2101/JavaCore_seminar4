package MiniMarket.model;

import java.util.List;

public class Order<T extends Product> {
    private List<T> productList;
    private Market thisMarket;
    private Buyer buyer;
    private double price;

    public Order() {
    }

    public Order(List<T> productList, Buyer buyer, Market thisMarket, double price) {
        this.productList = productList;
        this.buyer = buyer;
        this.thisMarket = thisMarket;
        this.price = price;
    }

    public Market getthisMarket() {
        return thisMarket;
    }

    public void setthisMarket(Market thisMarket) {
        this.thisMarket = thisMarket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setList(List<T> productList) {
        this.productList = productList;
    }

    public List<T> getList() {
        return productList;
    }

    @Override
    public String toString() {
      String result = "Shopper bag: [";
      for (int index = 0; index < productList.size(); index++) {
        result += " Product " + (index + 1) + "=" + productList.get(index).getProductName() + ", ";
      }
      return result + " Name = " + buyer.getName() + ", Total = " + price + "]";
    }
}
