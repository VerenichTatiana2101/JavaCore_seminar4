package MiniMarket.exceptions;

public class NegativBalanceException extends Exception {
    public NegativBalanceException(String msg) {
        super(msg);
    }
}
