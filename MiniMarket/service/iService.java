package MiniMarket.service;

import MiniMarket.model.Market;
import MiniMarket.model.Product;

public interface iService {
    Market replenishment(Market market, Product product);
}
