package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountPanel extends JPanel {
    private JCheckBox showPassword;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JButton signInButton;
    private JLabel message;
    private JLabel checkLabel;
    private JComboBox costPerTransaction;
    private JTextField phoneNumber;
    private JTextField email;

    public JTextField getPhoneNumber() {
        return this.phoneNumber;
    }

    public JTextField getEmail() {
        return this.email;
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
    }

    public JPasswordField getPasswordField2() {
        return this.passwordField2;
    }

    public CreateAccountPanel() {

        showPassword = new JCheckBox("Show Password");
        passwordField = new JPasswordField(10);
        passwordField2 = new JPasswordField(10);
        signInButton = new JButton("Sign In");
        message = new JLabel("Make sure to use a strong password");
        checkLabel = new JLabel();

        costPerTransaction = new JComboBox();

//      Setting up the message label
        message.setFont(new Font("Courier", Font.PLAIN, 10));

//      Setting up showPassword button
        passwordField.setEchoChar('•');
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('•');
                }
            }
        });

//      Setting up the costPerTransaction combo box
        DefaultComboBoxModel costPerTransactionModel = new DefaultComboBoxModel();
        costPerTransactionModel.addElement("100");
        costPerTransactionModel.addElement("500");
        costPerTransactionModel.addElement("Other");
        costPerTransaction.setModel(costPerTransactionModel);
        costPerTransaction.setSelectedIndex(0);
        costPerTransaction.setEditable(true);

//      Setting the confirm password validation label
        checkLabel.setSize(new Dimension(20, 20));


//      Setting up the confirm password field
        passwordField2.setEchoChar('•');
        if (passwordField2.getPassword().length != 0) {
            if (passwordField2.getText().equals(passwordField.getText())) {
                checkLabel.setVisible(true);
                checkLabel.setIcon(Utils.setLabelIcon("src/main/java/images/Valid.png", checkLabel));
                checkLabel.setSize(20,20);
                checkLabel.setFont(new Font("Courier", Font.PLAIN, 10));

            } else {
                checkLabel.setIcon(Utils.setLabelIcon("src/main/java/images/Invalid.png", checkLabel));
                checkLabel.setSize(20,20);
                checkLabel.setFont(new Font("Courier", Font.PLAIN, 10));
                checkLabel.setVisible(true);
            }
        }

//      Setting up signInButton
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //checkData();
                new MainFrame();
            }
        });

//      Basic setup for the panel
        setBounds(350, 200, 500, 500);
        setBackground(Color.LIGHT_GRAY);
        Border border = BorderFactory.createTitledBorder("Enter your information");
        setBorder(border);
        setSize(new Dimension(500, 450));
        layoutComponents();
    }

    public LayoutManager layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

//      First row-First column
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("First Name"), gc);

//      First row-Second column
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JTextField(10), gc);

//      Second row-First column
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Last Name"), gc);

//      Second row-Second column
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JTextField(10), gc);

//      Third row-First column
        gc.gridy++;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Phone Number"), gc);

//      Third row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(phoneNumber = new JTextField(10), gc);

//      Fourth row-First column
        gc.gridy++;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Email"), gc);

//      Fourth row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(email = new JTextField(10), gc);

//      Fifth row-First column
        gc.gridy++;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Password"), gc);

//      Fifth row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(passwordField, gc);

//      Fifth row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(showPassword, gc);

//      Sixth row-First column
//        gc.gridy++;
//        gc.gridx++;
//        gc.weighty = 0.1;
//        gc.weightx = 1;
//        gc.anchor = GridBagConstraints.LAST_LINE_END;
//        gc.insets = new Insets(0, 0, 0, 0);
//        add(message, gc);

//      Seventh row-First column
        gc.gridy++;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Confirm Password"), gc);

//      Seventh row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(passwordField2, gc);

//      Seventh row-Third column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(checkLabel, gc);

//      Eighth row-First column
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Cost per transaction"), gc);

//      Eighth row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(costPerTransaction, gc);

        return null;
    }

    public void checkPhoneNumber(String number) {
        char[] array = number.toCharArray();
        for (char c: array) {
            if (!Character.isDigit(c)) {
                JOptionPane.showMessageDialog(this, "Please insert a valid phone number",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}