public class CD extends Account {

    private double rate;

    public CD(Currency some_money, double rate) {
        super(some_money);
        this.rate = rate;
    }

    public Result deposit(Currency some_money) {
        return Result.SUCCESS;
    }
    public String get_type(){
        return "CD";
    }

    public Result withdraw(Currency some_money) {
        return Result.SUCCESS;
    }

    @Override
    public String toString() {
        return "CD{" + "rate=" + rate + '}';
    }

    public Currency get_balance() {
        return this.amount;
    }
}
