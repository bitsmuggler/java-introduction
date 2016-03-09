import javax.swing.*;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextArea textAreaText;
    private JTextField textField1;
    private JTextField textField2;
    private JButton einfuegenButton;
    private JButton beendenClose;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
