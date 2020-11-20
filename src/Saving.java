/*
*@author Sagar Shrestha
*@version 0.01
*@since 2020-11-20
*/
public class Saving extends Account {
    private double rate;

    public Saving(Currency init, double rate) {
        super(init);
        this.rate = rate;
        System.out.println("Opened one-Savings");
    }

    public String get_type() {
        /*
         * Returns the type of account
         * 
         * @returns String
         */
        return "Saving";
    }

    public Result withdraw(Currency some_money) {
        /*
         * Method that handles withdrawing
         * 
         * @param some_money(Currency)
         * 
         * @returns Result
         */
        if ((this.amount.get_value() - some_money.get_value()) < 0) {
            return Result.OVERDRAFT;
        } else {
            this.amount.subtract(some_money);
            return Result.SUCCESS;
        }
    }

    public Result deposit(Currency some_money) {
        /*
         * Method that handles depositing
         * 
         * @param some_money(Currency)
         * 
         * @returns Result
         */
        this.amount.add(some_money);
        return Result.SUCCESS;
    }

    public Currency get_balance() {
        /*
         * Method that handles withdrawing
         * 
         * @param some_money(Currency)
         * 
         * @returns Currency
         */
        return this.amount;
    }

    @Override
    public String toString() {
        return "Saving{" + "rate=" + rate + '}';
    }
}
