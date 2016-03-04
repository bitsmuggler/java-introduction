import javax.swing.*;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldNumber;
    private JButton buttonInput;
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
