import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JCheckBox checkBox1StelligeQuersummeBerechnen;
    private JTextField textFieldZahl;
    private JTextField textFieldQuersumme;
    private JButton buttonBerechnen;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonBerechnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zahl = textFieldZahl.getText();

                try {
                    int number = Integer.parseInt(zahl);
                    int result = calculateQuersumme(number);

                    if(checkBox1StelligeQuersummeBerechnen.isSelected()) {
                        result = calculateQuersumme(result);
                    }

                    textFieldQuersumme.setText(Integer.toString(result));

                } catch(NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Ganzzahl ein.");
                }
            }
        });
    }

    /**
     * Berchnet die Quersumme
     * @param number Zahl aus der die Quersumme berechnet werden soll.
     * @return Quersumme
     */
    private int calculateQuersumme(int number) {

        int summe = 0;
        while (number > 0) {
            summe = summe + number % 10;
            number = number / 10;
        }
        return summe;
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
