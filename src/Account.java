abstract class Account {

    protected Currency amount;
    public Account(Currency init_deposit){
        this.amount = init_deposit;
    }
    public abstract void withdraw(Currency some_money);
    public abstract void deposit(Currency some_money);
    public abstract Currency get_balance();
}
