package com.wallet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WalletPanel
{
    public WalletPanel(){
        try{
            JFrame frame =new JFrame();
            frame.setSize(500,300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            DisplayMoney dm = new DisplayMoney(frame);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }}
class DisplayMoney implements ActionListener
{
    JButton AddMoney;
    JFrame frame;
    JPanel panel;
    JLabel amount_disp,amount;
    DisplayMoney(JFrame frame) {
        this.frame=frame;

        amount_disp = new JLabel();
        amount_disp.setText("Amount:");
        amount_disp.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        amount = new JLabel();
        amount.setText("MALAMAL");
        amount.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        AddMoney = new JButton("ADD MONEY");
        AddMoney.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
        panel = new JPanel(null);
        amount_disp.setBounds(110,25,200,130);
        amount.setBounds(220,25,350,130);
        AddMoney.setBounds(145,150,150,40);
        panel.add(amount_disp);
        panel.add(amount);
        panel.add(AddMoney);
        frame.setTitle("WALLET MONEY");
        frame.add(panel,BorderLayout.CENTER);
        frame.setContentPane(panel);
        AddMoney.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        Addmoney am = new Addmoney(frame);
//            frame.add(am.panel,BorderLayout.CENTER);
        frame.setSize(500,300);
        frame.setContentPane(am.panel);
        frame.setVisible(true);
        frame.setTitle("Add Money To Wallet");
    }
}
class Addmoney implements ActionListener {
    JButton Add, Cancel;
    JFrame frame;
    JPanel panel;
    JTextField CardNotxt, amounttxt;
    JLabel CardNo, amount;

    Addmoney(JFrame frame) {
        this.frame = frame;

        amount = new JLabel();
        amount.setText("Amount:");
        amount.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        CardNo = new JLabel();
        CardNo.setText("Card Number : ");
        CardNo.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        CardNotxt = new JTextField();
        CardNotxt.setToolTipText("enter 16 digit of your Card Number");
        CardNotxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));

        amounttxt = new JTextField();
        amounttxt.setToolTipText("Enter amount to enter");
        amounttxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));

        Add = new JButton("ADD");
        Add.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));

        Cancel = new JButton("CANCEL");
        Cancel.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));

        panel = new JPanel(null);
        CardNo.setBounds(80, 40, 150, 30);
        amount.setBounds(80, 80, 300, 30);
        CardNotxt.setBounds(260, 40, 200, 30);
        amounttxt.setBounds(260, 80, 200, 30);
        Add.setBounds(120, 160, 150, 30);
        Cancel.setBounds(280, 160, 150, 30);
        panel.add(CardNo);
        panel.add(amount);
        panel.add(CardNotxt);
        panel.add(amounttxt);
        panel.add(Add);
        panel.add(Cancel);
        frame.add(panel);
        Add.addActionListener(this);
        Cancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ADD")) {
            DisplayMoney dm2 = new DisplayMoney(frame);
            frame.setVisible(true);
            //frame.setTitle("WALLET MONEY");
        } else {
            DisplayMoney dm1 = new DisplayMoney(frame);

            frame.setVisible(true);
            //frame.setTitle("WALLET MONEY");
        }
    }
}
