import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldInteger;
    private JTextField textFieldBinar;
    private JButton vearbeitungButton;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        vearbeitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(textFieldInteger.getText());
                String binaryRepresenation = Integer.toBinaryString(number);
                textFieldBinar.setText(binaryRepresenation);
            }
        });
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
