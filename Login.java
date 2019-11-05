package com.signUp;
import com.mainPage.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import com.main.*;

public class Login implements ActionListener
{
    JFrame frame;
    JButton SUBMIT,SIGNUP;
    public JPanel panel;
    JLabel label1,label2;
    final JTextField  text1,text2;
    public Login(JFrame frame)
    {
        this.frame = frame;
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

        SUBMIT = new JButton("SUBMIT");
        SIGNUP = new JButton("SIGNUP");
        panel = new JPanel(new GridLayout(3,1));
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(SUBMIT);
        panel.add(SIGNUP);
        frame.add(panel,BorderLayout.CENTER);
        SUBMIT.addActionListener(this);
        SIGNUP.addActionListener(this);
        frame.setTitle("LOGIN FORM");
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("SUBMIT")) {
            try {
                PrintWriter out = new PrintWriter(LoginPage.sk.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(LoginPage.sk.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                out.println("login");
                String value1 = text1.getText();
                out.println(value1);
                String value2 = text2.getText();
                out.println(value2);
                if (in.readLine().equals("successful")) {
                    UserUI ui = new UserUI(frame);
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            SignUp sign = new SignUp(frame);
            frame.add(sign.panel,BorderLayout.CENTER);
            frame.setSize(500,300);
            frame.setContentPane(sign.panel);
            frame.setVisible(true);
            frame.setTitle("SIGNUP FORM");
        }
    }
}

class SignUp implements ActionListener {
    JFrame frame;
    JButton SUBMIT, CANCEL;
    JPanel panel;
    JLabel userid, passwd,name,emailid,phoneno;
    JTextField  usertxt, passtxt,nametxt,phonetxt,emailidtxt;
    public SignUp(JFrame frame) {
        this.frame = frame;
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
        panel = new JPanel(new GridLayout(6, 1));
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
        if(e.getActionCommand().equals("CANCEL")) {
            Login l = new Login(frame);
            frame.add(l.panel,BorderLayout.CENTER);
            frame.setSize(500,300);
            frame.setContentPane(l.panel);
            frame.setVisible(true);
            frame.setTitle("LOGIN FORM");
        }
        else {
            try {
                PrintWriter out = new PrintWriter(LoginPage.sk.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(LoginPage.sk.getInputStream()));
                out.println("signup");
                String uid, pass, usn, ph, email;
                uid = usertxt.getText();
                pass = passtxt.getText();
                usn = nametxt.getText();
                ph = phonetxt.getText();
                email = emailidtxt.getText();
                out.println(uid);
                out.println(pass);
                out.println(usn);
                out.println(ph);
                out.println(email);
                String s = in.readLine();
                if (s.equals("successful")) {
                    UserUI ui = new UserUI(frame);
                } else {
                     do {
                         if(s.equals("userid taken"))
                             JOptionPane.showMessageDialog(frame, "Userid already exists", "Error", JOptionPane.ERROR_MESSAGE);
                         if(s.equals("phone number taken"))
                             JOptionPane.showMessageDialog(frame, "phone number already exists", "Error", JOptionPane.ERROR_MESSAGE);
                         if(s.equals("emailid taken"))
                             JOptionPane.showMessageDialog(frame, "email id already exists", "Error", JOptionPane.ERROR_MESSAGE);
                    }while ((s = in.readLine()).equals("errors finished") == false);
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
