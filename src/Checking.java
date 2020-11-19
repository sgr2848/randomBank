public class Checking extends Account {

    public Checking(Currency init_deposit){
        super(init_deposit);
    }
    public Result withdraw(Currency some_money){
        return Result.SUCCESS;
    }
    public Result deposit(Currency some_money){
        return Result.SUCCESS;
    }
    public String get_type(){
        return "Checking";
    }
    public Currency get_balance(){
        return this.amount;
    }
}
