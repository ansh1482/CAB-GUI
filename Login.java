package com.signUp;

import LoginMain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener
{
    JButton SUBMIT,SIGNUP;
    JPanel panel;
    JLabel label1,label2;
    final JTextField  text1,text2;
    public Login()
    {
        label1 = new JLabel();
        label1.setText("              Username:");
        label1.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        text1 = new JTextField(30);
        text1.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        label2 = new JLabel();
        label2.setText("              Password:");
        label2.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        text2 = new JPasswordField(30);
        text2.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        SUBMIT=new JButton("SUBMIT");
        SIGNUP=new JButton("SIGNUP");
        panel=new JPanel(new GridLayout(3,1));
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(SUBMIT);
        panel.add(SIGNUP);
        add(panel,BorderLayout.CENTER);
        SUBMIT.addActionListener(this);
        SIGNUP.addActionListener(this);
        setTitle("LOGIN FORM");
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("SUBMIT")) {
            String value1 = text1.getText();
            String value2 = text2.getText();
            if (value1.equals("roseindia") && value2.equals("roseindia")) {
                JPanel panel1 = new JPanel();
                panel1.setBounds(40, 80, 200, 200);
                panel1.setBackground(Color.gray);
                JButton b1 = new JButton("Button 1");
                b1.setBounds(50, 100, 80, 30);
                b1.setBackground(Color.yellow);
                JButton b2 = new JButton("Button 2");
                b2.setBounds(100, 100, 80, 30);
                b2.setBackground(Color.green);
                panel1.add(b1);
                panel1.add(b2);
                add(panel1, BorderLayout.CENTER);
                setExtendedState(Frame.MAXIMIZED_BOTH);
                setContentPane(panel1);
                setVisible(true);
            } else {
                System.out.println("enter a valid username and password");
                JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            SignUp sign = new SignUp();
            sign.signUp();
            add(sign.panel,BorderLayout.CENTER);
            setSize(500,300);
            setContentPane(sign.panel);
            setVisible(true);
            setTitle("SIGNUP FORM");
        }
    }
}

class SignUp extends JFrame implements ActionListener {
    JButton SUBMIT, CANCEL;
    JPanel panel;
    JLabel userid, passwd,name,emailid,phoneno,error;
    JTextField  usertxt, passtxt,nametxt,phonetxt,emailidtxt;
    public void signUp() {
        userid = new JLabel();
        userid.setText("              Username:");
        usertxt = new JTextField(30);
        usertxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        userid.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        passwd = new JLabel();
        passwd.setText("              Password:");
        passtxt = new JPasswordField(30);
        passwd.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        passtxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        name = new JLabel();
        name.setText("              Name:");
        nametxt = new JTextField(30);
        nametxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        name.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        emailid = new JLabel();
        emailid.setText("              EmailId:");
        emailidtxt = new JTextField(30);
        emailidtxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        emailid.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        phoneno = new JLabel();
        phoneno.setText("              Phone No:");
        phonetxt = new JTextField(30);
        phonetxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        phoneno.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        SUBMIT = new JButton("SUBMIT");
        CANCEL = new JButton("CANCEL");
        panel = new JPanel(new GridLayout(7, 1));
        panel.add(name);
        panel.add(nametxt);
        panel.add(emailid);
        panel.add(emailidtxt);
        panel.add(phoneno);
        panel.add(phonetxt);
        panel.add(userid);
        panel.add(usertxt);
        panel.add(passwd);
        panel.add(passtxt);
        panel.add(SUBMIT);
        panel.add(CANCEL);
        SUBMIT.addActionListener(this);
        CANCEL.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

