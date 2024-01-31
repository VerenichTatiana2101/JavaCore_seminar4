package MiniMarket.model;

public class Buyer extends Actor{  
    private double money;
    private Market thisMarket;

    public Buyer(String name, boolean isMadeOrder, boolean isTookOrder, double money) {
        super(name, isMadeOrder, isTookOrder);
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Market getThisMarket() {
        return thisMarket;
    }

    public void setThisMarket(Market thisMarket) {
        this.thisMarket = thisMarket;
    }

    @Override
    public void setMakeOrder(boolean isMade) {
    }

    @Override
    public void setTakeOrder(boolean isTook) {
    }

    @Override
    public boolean getTookOrder() {
        return true;
    }

    @Override
    public boolean getMadeOrder() {
        return true;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + ". Cash: " + money + "; ";
    }



}
