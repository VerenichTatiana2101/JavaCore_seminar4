package MiniMarket.model;

import MiniMarket.interfaces.ActorBehaviour;

public abstract class Actor implements ActorBehaviour {
    private String name;
    private String surname;
    private int age;
    private String phone;
    private boolean isMadeOrder;
    private boolean isTookOrder;

    public Actor(String name, boolean isMadeOrder, boolean isTookOrder) {
        this.name = name;
        this.isMadeOrder = isMadeOrder;
        this.isTookOrder = isTookOrder;
    }

    String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isMadeOrder() {
        return isMadeOrder;
    }

    public void setMadeOrder(boolean isMadeOrder) {
        this.isMadeOrder = isMadeOrder;
    }

    public boolean isTookOrder() {
        return isTookOrder;
    }

    public void setTookOrder(boolean isTookOrder) {
        this.isTookOrder = isTookOrder;
    }

    @Override
    public String toString() {
        return "Actor [name=" + name + ", surname=" + surname + ", age=" + age + ", phone=" + phone + ", isMadeOrder="
                + isMadeOrder + ", isTookOrder=" + isTookOrder + "]";
    }

}
