    import java.util.ArrayList;

public class Customer {
    private final String first_name;
    private final String last_name;
    private final String pass_code;
    private int no_of_acc;
    public ArrayList<Account> account_list;
    public Customer(String first_name, String last_name,String pass_code){
        this.first_name = first_name;
        this.last_name = last_name;
        this.no_of_acc = 0;
        this.pass_code = pass_code;
        this.account_list = new ArrayList<Account>();
    }
    public String get_first_name(){
        return this.first_name;
    }
    public String get_last_name(){
        return this.last_name;
    }
    public String get_pass(){
        return this.pass_code;
    }
    public int get_acc_no(){
        return this.no_of_acc;
    }

    @Override
    public String toString() {
        return "Customer{" + "first_name='" + first_name + '\'' + ", " +
                "last_name='" + last_name + '\'' + ", pass_code='" + pass_code + '\'' + ", no_of_acc=" + no_of_acc + ", account_list=" + account_list + '}';
    }

    public void add_account(Account account){
        this.account_list.add(account);
        this.no_of_acc++;
        System.out.println(this.no_of_acc);
    }

}
