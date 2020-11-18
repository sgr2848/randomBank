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

    }
    public Result deposit(Currency some_money){

    }

    public Currency get_balance(){
        return this.amount;
    }
}
