import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldInput;
    private JTextField textFieldResult;
    private JButton prüfenButton;
    private JButton beendenButton;
    private JButton buttonOK;

    private int randomNumber = this.getRandomNumber();

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        prüfenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkNumber();
            }
        });
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private int getInput() {
        return Integer.parseInt(textFieldInput.getText());
    }

    private void checkNumber() {
        int input = this.getInput();

        if(input > this.randomNumber) {
            textFieldResult.setText("Zahl zu gross!");
        } else if(input < this.randomNumber) {
            textFieldResult.setText("Zahl zu klein!");
        } else if(input == this.randomNumber) {
            textFieldResult.setText("Zahl stimmt!");
        }
    }

    private int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 100 + 1);
    }
}
