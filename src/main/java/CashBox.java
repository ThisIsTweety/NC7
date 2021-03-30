public class CashBox {
    int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public synchronized void withdrow(int sum) {
        money -= sum;
        System.out.println("  Withdrow money: " + sum + ". Money: " + getMoney());

    }

    public synchronized void topUp(int sum) {
        money += sum;
        System.out.println("  TopUp money: " + sum + ". Money: " + getMoney());
    }
}
