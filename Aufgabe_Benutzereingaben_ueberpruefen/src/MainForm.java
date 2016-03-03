import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldNumber;
    private JButton buttonValidate;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Eingabe auslesen.
                String value = textFieldNumber.getText();

                try {

                    //Eingabe versuchen in eine Ganzzahl zu konvertieren.
                    int number = Integer.parseInt(value);

                    //Falls OK, erfolgreiche Meldung anzeigen.
                    JOptionPane.showMessageDialog(null, "Alles OK.");
                } catch(NumberFormatException exception) {

                    //Falls nicht OK, Fehler anzeigen.
                    JOptionPane.showMessageDialog(null, "Ungültige Eingabe! Bitte geben Sie eine Ganzzahl ein!");
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
}
