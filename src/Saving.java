public class Saving extends Account{
    private double rate;
    public Saving(Currency init , double rate){
        super(init);
        this.rate = rate;
        System.out.println("Opened one-Savings");
    }
    public String get_type(){
        return "Saving";
    }
    public Result withdraw(Currency some_money){
        if((this.amount.get_value() - some_money.get_value())< 0){
            return Result.OVERDRAFT;
        }else {
            this.amount.subtract(some_money);
            return Result.SUCCESS;
        }
    }
    public Result deposit(Currency some_money){
        this.amount.add(some_money);
        return Result.SUCCESS;
    }

    public Currency get_balance(){
        return this.amount;
    }

    @Override
    public String toString() {
        return "Saving{" + "rate=" + rate + '}';
    }
}
