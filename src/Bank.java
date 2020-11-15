import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Bank implements ActionListener {
    public JFrame main_frame;
    private ArrayList<Customer> c_list;

    public Bank() {
        this.c_list = new ArrayList<Customer>();
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
        // this.main_frame = new JFrame();
        // main_frame.setLocationRelativeTo(null);
        // main_frame.setTitle("The Bank : We will take your money");
        // main_frame.setSize(400, 400);
        // main_frame.setLayout(new BorderLayout());
        // main_frame.setVisible(true);
        // this.first_prompt();
        // main_frame.pack();
        this.dash_board(new Customer("Sagar", "Shrestha", "right"));

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
        // new_frame.pack();
        new_frame.setVisible(true);
        // this.main_frame = new_frame;

    }
    JPanel home(Customer some_customer){
        JPanel home = new JPanel();
        JLabel top = new JLabel("Customer Information");
        JLabel first_name = new JLabel("First Name");
        JLabel last_name = new JLabel("Last Name");
        JLabel no_acc = new JLabel("Total Number of Accounts");
        return home;
    }
    JPanel add_acc(Customer some_customer){
        JPanel add_form = new JPanel();
        return add_form;
    }
    JPanel show_acc (Customer some_customer){
        JPanel acc_panel = new JPanel();
        return acc_panel;
    }
    void dash_board(Customer some_customer) {

        JFrame new_frame = new JFrame();
        new_frame.setLocationRelativeTo(null);
        boolean home_b = true;
        boolean a_f = true;
        boolean acc_p = true;
        GridBagLayout layout = new GridBagLayout();
        new_frame.setLayout(layout);
        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.NORTHWEST;
        new_frame.setSize(500, 250);
        JPanel up = new JPanel();
        up.setSize(800, 100);
        up.setBackground(Color.CYAN);
        JPanel side = new JPanel();
        side.setSize(100, 700);
        side.setBackground(Color.LIGHT_GRAY);
        JPanel view = new JPanel();
        view.setSize(700, 700);
        view.setBackground(Color.BLUE);
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

        side.add(home);side.add(add_acc_b);side.add(show_all_acc);
        view.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.black), new EmptyBorder(10, 10, 10, 10)));;
        view.add(new JLabel("HERE"));
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
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth= GridBagConstraints.REMAINDER;
        cons.gridheight=GridBagConstraints.REMAINDER;
        new_frame.add(view, cons);
        new_frame.setVisible(true);
        // new_frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] agrs) {
        Bank new_b = new Bank();
        new_b.init();
    }

}
