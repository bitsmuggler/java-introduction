import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JRadioButton inTagenRadioButton;
    private JRadioButton inStundenRadioButton;
    private JTextField textFieldGeschwindigkeit;
    private JButton reisedauerBerechnenButton;
    private JTextField textFieldReisedauer;
    private JRadioButton radioButton1;
    private JButton buttonOK;

    private static final int DURCHSCHNITTLICHE_ENTFERNUNG = 385000;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        reisedauerBerechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateDuration();
            }
        });
    }

    /**
     * Berechnet die Dauer zum Mond.
     * @return
     */
    private int calculateDuration() {
        double dauerInStunden = 0;

        try {
            String geschwindigkeitString = textFieldGeschwindigkeit.getText();
            double geschwindigkeit = Double.parseDouble(geschwindigkeitString);
            dauerInStunden = DURCHSCHNITTLICHE_ENTFERNUNG / geschwindigkeit;
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Ganzzahl ein.");
            return 0;
        }

        textFieldReisedauer.setText(Double.toString(dauerInStunden));

        return 0;
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
