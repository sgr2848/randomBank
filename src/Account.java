abstract class Account {
    enum Result{
        SUCCESS,
        OVERDRAFT,
        OP
    }
    protected Currency amount;
    public Account(Currency init_deposit){
        this.amount = init_deposit;
    }
    public abstract Result withdraw(Currency some_money);
    public abstract Result deposit(Currency some_money);
    public abstract Currency get_balance();
    public abstract String get_type();

    @Override
    public String toString() {
        return "Account{" + "amount=" + amount + '}';
    }
}
