package MiniMarket.interfaces;

public interface ActorBehaviour {
    void setMakeOrder(boolean isMade);
    void setTakeOrder(boolean isTook);
    boolean getTookOrder();
    boolean getMadeOrder();
}
