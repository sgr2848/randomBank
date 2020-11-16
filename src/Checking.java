public class Checking extends Account {

    public Checking(Currency init_deposit){
        super(init_deposit);
    }
    public void withdraw(Currency some_money){}
    public void deposit(Currency some_money){

    }
    public Currency get_balance(){
        return this.amount;
    }
}
