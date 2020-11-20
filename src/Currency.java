public class Currency {
    private int cents;
    public Currency(){
        this.cents = 0;
    }
    public Currency(int cents){
        this.cents = cents;
    }
    public int get_value(){
        return this.cents;
    }
    public Currency add(Currency rhs){
        this.cents = this.cents + rhs.cents;
        return this;
    }
    public Currency subtract(Currency rhs){
        this.cents = this.cents - rhs.cents;
        return this;
    }
    public String toString(){
        double dollar_value = this.cents/100;
        String string_value = String.format("You have $ %.3f",dollar_value);
        return string_value;
    }
}
