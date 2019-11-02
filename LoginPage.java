import javax.swing.*;
import com.signUp.*;



class LoginPage {
    public static void main(String arg[]) {
        try {
            Login frame = new Login();
            frame.setSize(500,300);
            frame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}


