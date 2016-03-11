import javax.swing.*;
import java.awt.*;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JSpinner spinner1;
    private JButton OKButton;
    private JTextArea textAreaResult;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        Font font = new Font("Courier New", Font.PLAIN, 12);
        textAreaResult.setFont(font);
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
