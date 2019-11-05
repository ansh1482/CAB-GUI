package com.main;

import javax.swing.*;
import com.signUp.*;
import java.net.*;


public class LoginPage {
    public static Socket sk;
    public static void main(String arg[]) {
        try {
            JFrame frame = new JFrame();
            Login login = new Login(frame);
            frame.setSize(500,300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}


