public class Client {
    private CashBox cashBox;
    private int numFun;
    private int max = 100;
    private int sum;
    public Client(CashBox cashBox, int numFun) {
        this.cashBox = cashBox;
        this.numFun = numFun;
    }
    public void operation(){
        if(numFun == 1){
            sum = rnd(max);
            cashBox.topUp(sum);
        }
        else{
            sum = rnd(max);
            if(cashBox.getMoney() > sum){
                cashBox.withdrow(sum);
            }
            else
                System.out.println("insufficient funds");
        }
    }
    public static int rnd( int max)
    {
        return (int) (Math.random() * ++max);
    }
}
