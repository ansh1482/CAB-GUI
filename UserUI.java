package com.mainPage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.signUp.*;
import com.main.*;
import com.wallet.*;

public class UserUI implements ActionListener{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    public JPanel panel;
    String name = "ANSH";
    JLabel welcome;
    JTextField location;
    JButton check, book, wallet, logout;
    JFrame frame;
    public UserUI(JFrame frame) {
        this.frame = frame;
        check = new JButton();
        book = new JButton();
        wallet = new JButton();
        logout = new JButton();
        welcome = new JLabel();
        panel = new JPanel();
        check = new JButton();
        location = new JTextField();
        panel.setLayout(null);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0,0,screenWidth,100);
        p.setBackground(Color.cyan);
        panel.setBackground(Color.yellow);
        panel.add(p);
        welcome.setText("WELCOME " + name);
        welcome.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        welcome.setBounds(20,20,200,50);
        logout.setText("LOGOUT");
        logout.setToolTipText("logout");
        logout.setBounds(screenWidth-150, 20, 130,50);
        wallet.setText("WALLET");
        wallet.setBounds(screenWidth-290,20,130,50);
        wallet.setToolTipText("wallet");
        location.setBounds(20,150,200,50);
        panel.add(location);
        check.setText("CHECK AVAILABILITY");
        check.setToolTipText("checks availability of cabs around you");
        check.setBounds(350,150,200,50);
        panel.add(check);
        p.add(wallet);
        p.add(logout);
        p.add(welcome);
        frame.add(panel);
        frame.setContentPane(panel);
        frame.setTitle("CABBIE");
        wallet.addActionListener(this);
        logout.addActionListener(this);
        check.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("WALLET")) {
            WalletPanel wall = new WalletPanel();
        } else if(e.getActionCommand().equals("LOGOUT")) {
            Login l = new Login(frame);
            frame.add(l.panel,BorderLayout.CENTER);
            frame.setSize(500,300);
            frame.setContentPane(l.panel);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setTitle("LOGIN FORM");
        } else if(e.getActionCommand().equals("check")) {

        }
    }
}
