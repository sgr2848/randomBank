/*
*@author Sagar Shrestha
*@version 0.01
*@since 2020-11-20
*/
public class CD extends Account {

    private double rate;

    public CD(Currency some_money, double rate) {
        super(some_money);
        this.rate = rate;
    }

    public Result deposit(Currency some_money) {
        /*
         * Method that handles withdrawing
         * 
         * @param some_money(Currency)
         * 
         * @returns Result
         */
        return Result.SUCCESS;
    }

    public String get_type() {
        /*
         * Returns the type of account
         * 
         * @returns String
         */
        return "CD";
    }

    public Result withdraw(Currency some_money) {
        /*
         * Does nothing
         * 
         * @param some_money(Currency)
         * 
         * @returns Result
         */
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
