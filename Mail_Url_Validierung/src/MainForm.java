import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldEmail;
    private JTextField textFieldUrl;
    private JButton buttonValidateEmail;
    private JButton buttonValidateUrl;
    private JButton buttonOK;

    /**
     * Validiert die E-Mail Adresse
     */
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    /**
     * Validiert URLs
     */
    private String URL_PATTERN = "((https?:\\/\\/)?(?:www)?.?[a-zA-Z0-9]*.[a-zA-z0-9]{2}?)";

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonValidateEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validateEmail()) {
                    JOptionPane.showMessageDialog(null, "Ungültige E-Mail Adresse.");
                }
            }
        });
        buttonValidateUrl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validateUrl()) {
                    JOptionPane.showMessageDialog(null, "Ungültige URL.");
                }
            }
        });
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    /**
     * Validiert einen übergebenen String gegen ein Regex-Pattern
     * @param regexPattern Regex-Pattern
     * @param input Eingabe
     * @return true, falls Engabe i.O.
     */
    private boolean validateString(String regexPattern, String input) {
        final Pattern pattern = Pattern.compile(regexPattern);
        return pattern.matcher(input).matches();
    }


    /**
     * Validiert die E-Mail Adresse
     * @return true, falls Eingabe i.O.
     */
    private boolean validateEmail() {;
        return validateString(EMAIL_PATTERN, textFieldEmail.getText());
    }

    /**
     * Validiert die URL
     * @return true, falls Eingabe i.O.
     */
    private boolean validateUrl() {
        return validateString(URL_PATTERN, textFieldUrl.getText());
    }
}
