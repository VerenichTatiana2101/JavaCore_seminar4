package MiniMarket.view;

import java.util.ArrayList;
import java.util.List;

import MiniMarket.model.Buyer;
import MiniMarket.model.Market;
import MiniMarket.model.Product;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> myList = new ArrayList<>();
        Product product1 = new Product("Пицца Марти", 150, 0);
        Product product2 = new Product("Пицца Паперони", 150, 6);
        Product product3 = new Product("Кола 2л", 50, 54);
        Product product4 = new Product("Спрайт 1л", 40, 36);
        myList.add(product1);
        myList.add(product2);
        myList.add(product3);
        myList.add(product4);

        Market pizzeria = new Market();
        pizzeria.initProducts(myList);

        Buyer tatiana = new Buyer("Тatiana", false, false, 1020);
        Buyer oleg = new Buyer("Oleg", false, false, 920);
        // tatiana.setThisMarket(pizzeria);
        
        List<Product> buyerList1 = new ArrayList<>();
        buyerList1.add(product2);
        buyerList1.add(product4);

        List<Product> buyerList2 = new ArrayList<>();
        buyerList2.add(product1);
        buyerList2.add(product3);

        System.out.println("Buyer in the pizzeria, " + tatiana.toString());
        System.out.println(pizzeria.createOrder(buyerList1, pizzeria, tatiana));
        System.out.println("\nBuyer " + tatiana.toString());
        System.out.println("\nRemainder: " + pizzeria.toString());

        System.out.println("\nBuyer in the pizzeria, " + oleg.toString());
        System.out.println(pizzeria.createOrder(buyerList2, pizzeria, oleg));
        System.out.println("\nBuyer " + oleg.toString());
        System.out.println("\nRemainder: " + pizzeria.toString());
    }
}
