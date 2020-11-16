import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Bank implements ActionListener {
    public JFrame main_frame;
    private ArrayList<Customer> c_list;
    public static boolean is_numeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public Bank() {
        this.c_list = new ArrayList<Customer>();
    }
    private void add_to_acc_list(Customer some_customer, String dollar_val,
                                 String acc_type,String rate_val){
        if (acc_type.equals("Checking")){
            int cents_val = Integer.parseInt(dollar_val) * 100;
            some_customer.add_account(new Checking(new Currency(cents_val)));
        }else if(acc_type)

    }

    public Customer get_customer(String first_name, String pass) {
        assert (this.c_list.size() > 0) : "There is no customer in the db";

        for (Customer i : this.c_list) {
            if (i.get_first_name() == first_name && i.get_pass() == pass) {
                return i;
            }
        }
        return null;
    }

    public void init() {
//         this.main_frame = new JFrame();
//         main_frame.setLocationRelativeTo(null);
//         main_frame.setTitle("The Bank : We will take your money");
//         main_frame.setSize(400, 400);
//         main_frame.setLayout(new BorderLayout());
//         main_frame.setVisible(true);
//        this.first_prompt();
//        main_frame.pack();
        dash_board(new Customer("Hiro","Kuda","Scum"));

    }

    private boolean check_customer(String first_name, String last_name, String pass) {
        return false;
    }

    private boolean check_login(String name, String pass) {
        return false;
    }

    private boolean add_to_list(String first_name, String last_name, String pass) {
        if (check_customer(first_name, last_name, pass) == true) {
            this.c_list.add(new Customer(first_name, last_name, pass));
            return true;
        } else {
            return false;
        }
    }

    void first_prompt() {
        JPanel return_panel = new JPanel();
        JButton new_user = new JButton(" New User?");
        JButton login = new JButton("Log In");
        return_panel.setLayout(new BoxLayout(return_panel, BoxLayout.PAGE_AXIS));
        // return_panel.setSize(780, 480);
        return_panel.add(new_user);
        return_panel.add(login);
        login.addActionListener(e -> {
            JComponent cmp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(cmp);
            win.dispose();
            System.out.println("Closed -> Login ");
            login();

        });
        new_user.addActionListener(e -> {
            // main_frame.dispose();
            JComponent cmp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(cmp);
            win.dispose();
            System.out.println("Closed -> new user");
            add_customer();
        });
        return_panel.setVisible(true);
        this.main_frame.add(return_panel);
    }

    void login() {
        JFrame new_frame = new JFrame();
        new_frame.setLocationRelativeTo(null);
        JPanel add_panel = new JPanel();
        Box title_text = Box.createHorizontalBox();
        JPanel header = new JPanel();
        JLabel title = new JLabel("LOGIN");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        title_text.add(title);
        // title_text.setAlignmentX(header.getWidth()/2);
        add_panel.setBackground(Color.WHITE);
        header.setBackground(Color.WHITE);
        JLabel f_n = new JLabel("First Name");
        JLabel p_n = new JLabel("Password");
        JTextField f_f = new JTextField();
        JPasswordField p_f = new JPasswordField();
        JButton submit = new JButton("Submit");
        GridLayout layout = new GridLayout(3, 2);
        layout.setHgap(10);
        layout.setVgap(10);
        add_panel.setLayout(layout);
        add_panel.add(f_n);
        add_panel.add(f_f);
        add_panel.add(p_n);
        add_panel.add(p_f);
        add_panel.add(submit);
        submit.addActionListener(e -> {
            if (check_login(f_f.getText(), String.valueOf(p_f.getPassword())) == true) {
                JComponent cmp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(cmp);
                win.dispose();

                dash_board(get_customer(f_f.getText(), String.valueOf(p_f.getPassword())));
            } else {
                JOptionPane.showMessageDialog(null, "Something didn't quite " + "add up, try again!");
            }
        });
        header.setBorder(new EmptyBorder(10, 0, 10, 0));
        add_panel.setBorder(new EmptyBorder(2, 15, 5, 15));
        header.add(title_text);
        GridLayout main_layout = new GridLayout(2, 0);
        main_layout.setVgap(2);
        new_frame.setLayout(main_layout);
        new_frame.add(header);
        new_frame.add(add_panel);
        new_frame.setVisible(true);
        new_frame.pack();

    }

    void add_customer() {
        // returns a Jframe prompt
        JFrame new_frame = new JFrame();
        new_frame.setLocationRelativeTo(null);
        Container n_p = new_frame.getContentPane();
        GroupLayout group = new GroupLayout(n_p);
        JLabel f_n = new JLabel("First Name");
        JTextField f_f = new JTextField("some first name");
        JLabel l_n = new JLabel("Last Name");
        JTextField l_f = new JTextField("some last name");
        new_frame.setLayout(group);
        JLabel p_n = new JLabel("Password");
        JPasswordField p_f = new JPasswordField("some first name");
        JButton submit = new JButton("Create Me");
        Box title_text = Box.createHorizontalBox();
        JLabel title = new JLabel("<html><span style='color: black;" + "'>New Customer!!</span></html>");
        title.setFont(title.getFont().deriveFont(20.0f));
        title_text.add(title);
        submit.addActionListener(e -> {
            // System.out.println(f_f.getText());
            if (add_to_list(f_f.getText(), l_f.getText(), String.valueOf(p_f.getPassword())) != true) {
                JOptionPane.showMessageDialog(null, "The User is " + "already in the database.");
            } else {
                JOptionPane.showMessageDialog(null, "Sucessfully " + "added customers to the database");
            }
        });

        group.setAutoCreateContainerGaps(true);
        group.setAutoCreateGaps(true);
        group.setHorizontalGroup(group.createSequentialGroup()
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(title_text)
                        .addComponent(f_n).addComponent(l_n).addComponent(p_n))
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(f_f).addComponent(l_f)
                        .addComponent(p_f).addComponent(submit)));

        group.setVerticalGroup(group.createSequentialGroup()
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(title_text))
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(f_n).addGap(30)
                        .addComponent(f_f))
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(l_n).addGap(30)
                        .addComponent(l_f))
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(p_n).addGap(30)
                        .addComponent(p_f))
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(submit)));
        new_frame.pack();
        new_frame.setVisible(true);

        // this.main_frame = new_frame;

    }
    JPanel get_home(Customer some_customer){
        JPanel home = new JPanel();
        GridLayout layout = new GridLayout(4, 2);
        layout.setHgap(10);
        layout.setVgap(3);
        home.setLayout(layout);
        JLabel top = new JLabel("Customer Information");
        JLabel first_name = new JLabel("First Name : ");
        JLabel f_n = new JLabel(String.format("%s",
                some_customer.get_first_name()));
        JLabel last_name = new JLabel("Last Name :");
        JLabel l_n = new JLabel(String.format("%s",
                some_customer.get_last_name()));
        JLabel no_acc = new JLabel("Total Number of Accounts : ");
        JLabel no_acc_i = new JLabel(String.format("%d",
                some_customer.get_acc_no()));
        home.add(top);
        home.add(Box.createHorizontalBox());
        home.add(first_name);
        home.add(f_n);
        home.add(last_name);
        home.add(l_n);
        home.add(no_acc);
        home.add(no_acc_i);
        return home;
    }

    JPanel add_acc(Customer some_customer){
        JPanel main_panel = new JPanel();
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.PAGE_AXIS));
        JPanel add_form = new JPanel();
        add_form.setLayout(new BoxLayout(add_form, BoxLayout.PAGE_AXIS));
        add_form.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.black), new EmptyBorder(10, 10, 10, 10)));
        JLabel info = new JLabel("Please select the type of account you " +
                "would like to open.");
        JRadioButton acc_check = new JRadioButton("Checking");
        JRadioButton acc_save = new JRadioButton("Savings");
        JRadioButton acc_cd = new JRadioButton("CD");
        ButtonGroup acc_group = new ButtonGroup();
        acc_group.add(acc_check);acc_group.add(acc_save);acc_group.add(acc_cd);
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Double.class);
        formatter.setMinimum(1.0);
        formatter.setMaximum(Double.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField d_f = new JFormattedTextField(formatter);
        JLabel d_l = new JLabel("Deposit Amount :   $");
        JLabel r_l = new JLabel("Rate : %");
        JFormattedTextField r_f = new JFormattedTextField(formatter);
        JButton c_a_b = new JButton("Create Account");
        add_form.add(info);add_form.add(acc_check);add_form.add(acc_save);add_form.add(acc_cd);add_form.add(d_l);
        add_form.add(d_f);add_form.add(r_l);add_form.add(r_f);
        main_panel.add(add_form);
        main_panel.add(Box.createVerticalStrut(5));
        main_panel.add(Box.createHorizontalStrut(350));
        main_panel.add(c_a_b);
        String[] curr_selection={"null"};
        class AccItemListener implements ItemListener {
            public void itemStateChanged(ItemEvent ex) {
                String item = ((AbstractButton) ex.getItemSelectable()).getActionCommand();
                boolean selected = (ex.getStateChange() == ItemEvent.SELECTED);

                if( selected == true){
                    curr_selection[0] = item;
                    System.out.println(item);
                }
            }
        }
        ItemListener il = new AccItemListener();
        acc_check.addItemListener(il);
        acc_save.addItemListener(il);
        acc_cd.addItemListener(il);

        c_a_b.addActionListener(e->{
            if(curr_selection[0]!="null"){
                if(curr_selection.equals("Checking")){
                    JOptionPane.showMessageDialog(null, "Success, Rates will " +
                            "be" + " ignored");
                    this.add_to_acc_list(some_customer,d_f.getText(),
                            curr_selection[0],r_f.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "Success!!!");
                    this.add_to_acc_list(some_customer,d_f.getText(),
                            curr_selection[0],r_f.getText());
                }
            }else{
                JOptionPane.showMessageDialog(null, "Check the account " +
                        "type!!!");
            }
        });
        return main_panel;
    }
    JPanel show_acc (Customer some_customer){
        JPanel acc_panel = new JPanel();
        if( some_customer.get_acc_no()==0){
            acc_panel.add(new JLabel("There is no open account. Try opening " +
                    "one !!!"));
        }
        return acc_panel;
    }
    void dash_board(Customer some_customer) {

        JFrame new_frame = new JFrame();
        new_frame.setTitle("The Bank : We will take your money");
        new_frame.setLocationRelativeTo(null);
        final boolean[] home_bool = {true};
        final boolean[] add_bool = {false};
        final boolean[] acc_bool = {false};
        GridBagLayout layout = new GridBagLayout();
        new_frame.setLayout(layout);
        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.NORTHWEST;
        new_frame.setSize(900, 350);
        JPanel up = new JPanel();
        up.setBackground(Color.CYAN);
        JPanel side = new JPanel();
        side.setBackground(Color.LIGHT_GRAY);
        JPanel view = new JPanel();
        view.setBackground(Color.WHITE);
        JLabel up_head = new JLabel(String.format("Hello, %s", some_customer.get_first_name()));
        up_head.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        up.add(up_head);
        JLabel side_l = new JLabel("Dashboard");
        JButton home = new JButton("Home");
        JButton add_acc_b = new JButton("Add New Account");
        JButton show_all_acc = new JButton("Show All Account");
        up.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.black), new EmptyBorder(10, 10, 10, 10)));
        side.setLayout(new BoxLayout(side, BoxLayout.PAGE_AXIS));
        side.setBorder( new CompoundBorder(BorderFactory.createLineBorder(Color.black), new EmptyBorder(10, 10, 10, 10)));
        side_l.setFont(new Font("Courier", Font.BOLD, 20));
        side_l.setBorder(
                new CompoundBorder(BorderFactory.createLineBorder(Color.black), new EmptyBorder(10, 10, 10, 10)));
        side.add(Box.createVerticalStrut(2));
        side.add(side_l);
        home.setBackground(Color.LIGHT_GRAY);
        add_acc_b.setBackground(Color.LIGHT_GRAY);
        show_all_acc.setBackground(Color.LIGHT_GRAY);
        side.add(home);side.add(add_acc_b);side.add(show_all_acc);

        view.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.black), new EmptyBorder(10, 10, 10, 10)));
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridwidth= GridBagConstraints.REMAINDER;
        cons.weighty = 1.0;
        cons.weightx = 1.0;
        cons.gridx = 0;
        cons.gridy = 0;
        new_frame.add(up, cons);
        cons.fill = GridBagConstraints.VERTICAL;
        cons.weighty = 1.0;
        cons.weightx = 1.0;
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridheight= GridBagConstraints.REMAINDER;
        new_frame.add(side, cons);
        cons.fill = GridBagConstraints.BOTH;
        cons.weighty = 1.0;
        cons.weightx = 1.0;
        cons.gridx = 4;
        cons.gridy = 1;
        cons.gridwidth= GridBagConstraints.REMAINDER;
        cons.gridheight=GridBagConstraints.REMAINDER;
        JPanel home_panel = get_home(some_customer);
        view.add(home_panel);
        home_panel.setVisible(true);
        new_frame.add(view, cons);
        JPanel acc_panel = show_acc(some_customer);
        JPanel add_panel = add_acc(some_customer);
        view.add(acc_panel);view.add(add_panel);
        add_panel.setVisible(false);
        acc_panel.setVisible(false);
        home.addActionListener(e->{
                if(home_bool[0] == false && add_bool[0]==true && acc_bool[0]==
                        false){
                    add_bool[0] = false;
                    home_bool[0] = true;
                    acc_panel.setVisible(false);
                    add_panel.setVisible(false);
                    home_panel.setVisible(true);

                }else if(home_bool[0] ==false && add_bool[0] ==false && acc_bool[0] == true){
                    acc_bool[0] = false;
                    home_bool[0] = true;
                    acc_panel.setVisible(false);
                    add_panel.setVisible(false);
                    home_panel.setVisible(true);
                }else{

                }
        });

        add_acc_b.addActionListener(e-> {

                if(home_bool[0] == true && add_bool[0]==false && acc_bool[0]==
                        false){
                    add_bool[0] = true;
                    home_bool[0] = false;
                    acc_panel.setVisible(false);
                    add_panel.setVisible(true);
                    home_panel.setVisible(false);

                }else if(home_bool[0] ==false && add_bool[0] ==false && acc_bool[0] == true){
                    acc_bool[0] = false;
                    add_bool[0] = true;
                    acc_panel.setVisible(false);
                    add_panel.setVisible(true);
                    home_panel.setVisible(false);
                }else{

                }
        });

        show_all_acc.addActionListener(e->{
            if(home_bool[0] == true && add_bool[0]==false && acc_bool[0]==
                    false){
                acc_bool[0] = true;
                home_bool[0] = false;
                acc_panel.setVisible(true);
                add_panel.setVisible(false);
                home_panel.setVisible(false);
            }else if(home_bool[0] ==false && add_bool[0] ==true && acc_bool[0] == false){
                add_bool[0] = false;
                acc_bool[0] = true;
                acc_panel.setVisible(true);
                add_panel.setVisible(false);
                home_panel.setVisible(false);
            }else{

            }
        });
        new_frame.setVisible(true);
//         new_frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Bank new_b = new Bank();
        new_b.init();
    }

}
