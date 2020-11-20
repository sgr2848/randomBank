public class Currency {
    private int cents;

    public Currency() {
        this.cents = 0;
    }

    public Currency(int cents) {
        this.cents = cents;
    }

    public int get_value() {
        /*
         * Returns cent value
         * 
         * @returns int
         */
        return this.cents;
    }

    public Currency add(Currency rhs) {
        /*
         * Adds currency
         * 
         * @param rhs(Currency)
         * 
         * @returns Currency
         */
        this.cents = this.cents + rhs.cents;
        return this;
    }

    public Currency subtract(Currency rhs) {
        /*
         * Subtracts currency
         * 
         * @param rhs(Currency)
         * 
         * @returns Currency
         */
        this.cents = this.cents - rhs.cents;
        return this;
    }

    public String toString() {
        /*
         * Overridden method to returns String value
         * 
         * @returns String
         */
        double dollar_value = this.cents / 100;
        String string_value = String.format("You have $ %.3f", dollar_value);
        return string_value;
    }
}
