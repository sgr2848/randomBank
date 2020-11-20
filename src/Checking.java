public class Checking extends Account {

    public Checking(Currency init_deposit){
        super(init_deposit);
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

    @Override
    public String toString() {
        return super.toString();
    }

    public String get_type(){
        return "Checking";
    }
    public Currency get_balance(){
        return this.amount;
    }
}
