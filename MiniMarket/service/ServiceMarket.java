package MiniMarket.service;

import java.util.List;

import MiniMarket.model.Market;
import MiniMarket.model.Product;

public class ServiceMarket implements iService {

    
    @Override
    public Market replenishment(Market market, Product product) {
        Product addProduct = market.getProduct(product.getProductName());
        List<Product> listProducts = market.getListProduct();
        if (addProduct != null) {
            addProduct.setQuantity(addProduct.getQuantity() + product.getQuantity());
        } else {
            listProducts.add(product);
        }
        market.initProducts(listProducts);
        return market;
    }
    
}
