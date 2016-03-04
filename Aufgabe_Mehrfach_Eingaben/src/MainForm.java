import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldNumber;
    private JButton buttonInput;
    private JButton buttonOK;

    private int counter = 0;
    private static final int NUMBER_OF_INPUTS = 10;
    private int[] inputs = new int[NUMBER_OF_INPUTS];

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = textFieldNumber.getText();
                processInput(value);
            }
        });
    }

    /**
     * Validiert den Input und gibt ihn weiter.
     * @param input String Input vom User
     */
    private void processInput(String input) {
        try {
            int number = Integer.parseInt(input);
            if(number >= 0 && number <= 9) {
                inputNumber(number);
            } else {
                showNumberValidationError();
            }
        } catch(NumberFormatException exception) {
            showNumberValidationError();
        }
    }

    /**
     * Zeigt die Validierungsmeldung an.
     */
    private void showNumberValidationError() {
        JOptionPane.showMessageDialog(null, "Ungültige Eingabe.");
    }

    /**
     * Nimmt die Nummer entgegen.
     * @param value Eingabe des Benutzers als Integer
     */
    private void inputNumber(int value) {
        inputs[counter++] = value;

        if(this.checkFinish()) {
            int[] statistic = this.countNumbers();
            String message = this.getMessage(statistic);
            this.cleanUpCounter();
            JOptionPane.showMessageDialog(this, message);
        }
    }

    /**
     * Zählt wieviel mal die Ziffern 1..9 in einem Array vorkommen
     * @return Array mit der Anzahl.
     */
    private int[] countNumbers() {
        int[] statistic = new int[inputs.length];

        for(int i = (NUMBER_OF_INPUTS - 1); i >= 0; i--) {
          statistic[i] = countNumber(i);
        }

        return statistic;
    }

    /**
     * Zählt wieviel eine bestimmte Ziffer im Array vorkommt.
     * @param numerToCount Ziffer die gezählt werden sollte.
     * @return Anzahl vorkommende Ziffern
     */
    private int countNumber(int numerToCount) {
        int count = 0;

        for(int i = 0; i < inputs.length; i++) {
            if(inputs[i] == numerToCount) {
                count++;
            }
        }

        return count;
    }

    /**
     * Gibt die Auswertungsnachricht zurück.
     * @param result Auswertungsarray
     * @return Nachricht
     */
    private String getMessage(int[] result) {
        String text = "Folgende Zahlen wurden mehr als 1x eingegeben: \n";

        for(int i = 0; i < NUMBER_OF_INPUTS; i++){
            if(result[i] > 1) {
                text += i + "->" + result[i] + "\n";
            }
        }

        return text;
    }

    /**
     * Prüft, ob 10 Nummern eingegeben wurden
     * @return true, falls 10 Nummern eingegeben wurden.
     */
    private boolean checkFinish() {
        return counter >= inputs.length;
    }

    /**
     * Setzt den Counter zurück.
     */
    private void cleanUpCounter() {
        counter = 0;
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
