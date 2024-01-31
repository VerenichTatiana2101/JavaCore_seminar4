package MiniMarket.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import MiniMarket.exceptions.NegativBalanceException;
import MiniMarket.exceptions.NoProductExcepton;

public class Market {
    protected List<Product> listProduct = new ArrayList<>();

    public void initProducts(List<Product> myList) {
        this.listProduct = myList;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public Product getProduct(String name) {
        for (Product product : listProduct) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public Order<Product> createOrder(List<Product> shoppingList, Market thisMarket, Buyer buyer) {
        Order<Product> order = new Order<>();
        try {
            ArrayList<Product> validatedList = new ArrayList<>();
            Product tempProduct;
            double checkList = 0;
            for (Product myProduct : shoppingList) {
                tempProduct = thisMarket.getProduct(myProduct.getProductName());
                if (myProduct.equals(tempProduct)
                        && thisMarket.getProduct(myProduct.getProductName()).getQuantity() > 0) {
                    validatedList.add(tempProduct);
                    checkList += thisMarket.getProduct(myProduct.getProductName()).getPrice();
                    (thisMarket.getProduct(myProduct.getProductName()))
                            .setQuantity((thisMarket.getProduct(myProduct.getProductName())).getQuantity() - 1);
                } else if (myProduct.equals(tempProduct)
                        && thisMarket.getProduct(myProduct.getProductName()).getQuantity() == 0) {
                    throw new NoProductExcepton("Покупатель " + buyer + " -> " + myProduct.getProductName() + " - отсутствует в продаже");
                }
            }
            if (buyer.getMoney() < checkList) {
                throw new NegativBalanceException("Недостаточно средств на счету");
            } else {
                buyer.setTakeOrder(true);
                order = new Order<Product>(validatedList, buyer, thisMarket, checkList);
                buyer.setMoney(buyer.getMoney() - checkList);
                loggingReader("Покупатель " + buyer + "Заказ принят: " + order);
            }
        } catch (NegativBalanceException | NoProductExcepton e) {
            loggingReader(e.getMessage());
        }
        return order;
    }

    public static void loggingReader(String msg) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("OrdersList", true))) {
            bw.write(msg);
            bw.newLine();
            System.out.println(msg + " Date " + LocalDate.now());
            System.out.println("Log записан успешно");
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        String result = " ";
        for (int i = 0; i < listProduct.size(); i++) {
            result += listProduct.get(i);
        }
        return result + "]";
    }
}
