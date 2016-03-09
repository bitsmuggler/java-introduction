import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextArea textAreaText;
    private JTextField textFieldInput;
    private JTextField textFieldPosition;
    private JButton einfuegenButton;
    private JButton beendenClose;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        einfuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Input auslesen
                String input = textFieldInput.getText();

                //Input übergeben
                inputText(input);
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
     * Eingegebener Text an die passende Stelle einfügen
     * @param input Input
     */
    private void inputText(String input) {
        //Position auslesen
        String positionAsString = textFieldPosition.getText();

        //Nach Integer konvertieren
        int position = Integer.parseInt(positionAsString);

        //Aktueller Text auslesen
        String currentText = textAreaText.getText();

        //Neuer Text zusammensetzen
        String newText = getNewText(currentText, input, position);

        //Text auf GUI setzen
        textAreaText.setText(newText);
    }

    /**
     * Gibt den neuen Text zurück.
     * @param currentText Aktueller Text
     * @param input Einzufügender Text
     * @param position Aktuelle Position
     * @return Zusammengesetzter Text
     */
    private String getNewText(String currentText, String input, int position) {
        return currentText.substring(0, position-1) + input + currentText.substring(position-1);
    }
}
