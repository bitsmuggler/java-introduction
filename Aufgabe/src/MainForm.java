import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JCheckBox checkBox1StelligeQuersummeBerechnen;
    private JTextField textFieldZahl;
    private JTextField textFieldQuersumme;
    private JButton buttonBerechnen;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        buttonBerechnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zahl = textFieldZahl.getText();

                try {
                    int result = Integer.parseInt(zahl);
                    result = calculateQuersumme(result);

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
     * Berechnet die Quersumme der übergebenen Zahl.
     * @param value Zahl
     * @return Quersumme
     */
    private int calculateQuersumme(int value) {

        //Quersummelogik
        Function<Integer, Integer> logic = x -> {
            int summe = 0;

            while(x > 0) {
                summe = summe + x % 10;
                x = x / 10;
            }

            return summe;
        };

        return calculate(value, logic);
    }

    /**
     * Führt die mathematische Operation an der übergebenen Zahl aus.
     * @param value Zahl
     * @param logic Generische Berechnungslogik
     * @return Berechnete Zahl.
     */
    private int calculate(int value, Function<Integer, Integer> logic) {
       return logic.apply(value);
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
