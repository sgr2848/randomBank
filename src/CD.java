public class CD extends Account {
    private double rate;

    public CD(Currency some_money, double rate) {
        super(some_money);
        this.rate = rate;
    }

    public void deposit(Currency some_money) {

    }

    public void withdraw(Currency some_money) {

    }

    public Currency get_balance() {
        return this.amount;
    }
}
