package CODEWAY.Task_01.task_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Atmapp {
    private JFrame frame;
    private JTextField amountField;
    private JPasswordField pinField;
    private JLabel resultLabel;
    private Atm atm;

    public Atmapp(Atm atm) {
        this.atm = atm;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("ATM Machine");
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon background = createResizedImageIcon("D:\\foododerapp\\src\\CODEWAY\\Task_01\\task3\\bank.jpg", frame.getWidth(), frame.getHeight());
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0,0 ,frame.getWidth(), frame.getHeight());

        JLayeredPane layeredPane = new JLayeredPane();

        layeredPane.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
        layeredPane.add(backgroundLabel,JLayeredPane.DEFAULT_LAYER);


        frame.setContentPane(layeredPane);
        placeComponents(layeredPane);

        frame.setVisible(true);
    }

    private void placeComponents(JLayeredPane layeredPane) {
        layeredPane.setLayout(null);

        //amount
        JLabel amountLabel = new JLabel("Enter amount:");
        amountLabel.setBounds(270, 370, 100, 25);
        layeredPane.add(amountLabel,JLayeredPane.PALETTE_LAYER);


        amountField = new JTextField(20);
        amountField.setBounds(360, 370, 165, 25);
        layeredPane.add(amountField,JLayeredPane.PALETTE_LAYER);

        //pin
        JLabel pinLabel = new JLabel("Enter PIN:");
        pinLabel.setBounds(290, 430, 100, 25);
        layeredPane.add(pinLabel,JLayeredPane.PALETTE_LAYER);

        pinField = new JPasswordField(4);
        pinField.setBounds(360, 430, 80, 25);
        layeredPane.add(pinField,JLayeredPane.PALETTE_LAYER);

        //withdraw
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(10, 520, 120, 25);
        layeredPane.add(withdrawButton,JLayeredPane.PALETTE_LAYER);

        //deposit
        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(620, 500, 120, 25);
        layeredPane.add(depositButton,JLayeredPane.PALETTE_LAYER);

        //checkbalance
        JButton balanceButton = new JButton("Check Balance");
        balanceButton.setBounds(10, 380, 120, 25);
        layeredPane.add(balanceButton,JLayeredPane.PALETTE_LAYER);

        //transfer
        JButton transferButton = new JButton("Transfer");
        transferButton.setBounds(620, 370, 120, 25);
        layeredPane.add(transferButton,JLayeredPane.PALETTE_LAYER);

        //result
        resultLabel = new JLabel("");
        resultLabel.setBounds(290, 330, 580, 25);
        layeredPane.add(resultLabel,JLayeredPane.PALETTE_LAYER);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTransaction("withdraw");
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTransaction("deposit");
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTransaction("balance");
            }
        });

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTransaction("transfer");
            }
        });
    }

    private void handleTransaction(String transactionType) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            int enteredPin = Integer.parseInt(new String(pinField.getPassword()));

            if (!atm.validatePin(enteredPin)) {
                resultLabel.setText("Invalid PIN. Please try again.");
                return;
            }

            switch (transactionType) {
                case "withdraw":
                    boolean successWithdraw = atm.withdraw(amount);
                    if (successWithdraw) {
                        resultLabel.setText("Withdrawal successful. New balance: " + atm.checkBalance());
                    } else {
                        resultLabel.setText("Insufficient funds!");
                    }
                    break;
                case "deposit":
                    atm.deposits(amount);
                    resultLabel.setText("Deposit successful. New balance: " + atm.checkBalance());
                    break;
                case "balance":
                    resultLabel.setText("Current balance: " + atm.checkBalance());
                    break;
                case "transfer":
                    BankAccount recipientAccount = new BankAccount(0,1234); // Replace with the actual recipient account
                    atm.transfer(amount, recipientAccount);
                    resultLabel.setText("Transfer successful. Your balance: " + atm.checkBalance());
                    break;
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Enter a valid number.");
        }
    }
    private ImageIcon createResizedImageIcon(String imagePath, int width, int height){
        ImageIcon originalImageIcon = new ImageIcon(imagePath);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}