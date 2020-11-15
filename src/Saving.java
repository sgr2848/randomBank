public class Saving extends Account{
    private double rate;
    public Saving(Currency init , double rate){
        super(init);
        this.rate = rate;
    }
    public void withdraw(Currency some_money){

    }
    public void deposit(Currency some_money){
    }
    public Currency get_balance(){
        return this.amount;
    }
}
