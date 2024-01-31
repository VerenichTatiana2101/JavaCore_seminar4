package MiniMarket.model;

import java.util.List;

import MiniMarket.exceptions.ErrorBuyerException;

public class BuyerList {
    private List<Buyer> buyers;

    public BuyerList(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    /**
     * не совсем понятно для чего это нужно, ведь покупатель может прийти впервые, а если для скидки проверять,
     * то исключение выбрасывать не нужно наверное
     * @param name принимает имя покупателя
     * @return покупателя, при его отсутствии выбрасывает исключение
     */
    public Buyer getBuyer(String name) {
        try {
            for (Buyer buyer : buyers) {
                if (buyer.getName().equals(name)) {
                    return buyer;
                }
                else {
                    throw new ErrorBuyerException("Покупатель с именем " + name + " отсутствует");
                }
            }
        } catch (ErrorBuyerException e) {
            Market.loggingReader(e.getMessage());
        }
        return null;
    }
}
