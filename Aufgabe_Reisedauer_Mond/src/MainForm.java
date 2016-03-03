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
    private ButtonGroup radioButtonGroup = new ButtonGroup();

    private static final int DURCHSCHNITTLICHE_ENTFERNUNG = 385000;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        reisedauerBerechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String geschwindigkeit = textFieldGeschwindigkeit.getText();
                double geschwindigkeitKmH = convertStringToDouble(geschwindigkeit);
                calculateDuration(geschwindigkeitKmH);
            }
        });

        this.radioButtonGroup.add(this.inTagenRadioButton);
        this.radioButtonGroup.add(this.inStundenRadioButton);
    }


    /**
     * Berechnet die Dauer zum Mond anhand der eingegebenen Geschwindigkeit (Km/h) und der ausgewählten Option (Tage / Stunden).
     * @param geschwindigkeitKmh Geschwindigkeit (Km/h)
     */
    private void calculateDuration(double geschwindigkeitKmh) {
        double result = 0;

        if(this.inStundenRadioButton.isSelected()) {
            result = calculateInStunden(geschwindigkeitKmh);
        }
        else if(this.inTagenRadioButton.isSelected()) {
            result = calculateInTagen(geschwindigkeitKmh);
        }

        textFieldReisedauer.setText(Double.toString(result));
    }

    /**
     * Berechnet die Dauer zum Mond in Stunden (h)
     * @param geschwindigkeitKmH Geschwindigkeit (Km/h)
     * @return Dauer zum Mond in Stunden (h)
     */
    private double calculateInStunden(double geschwindigkeitKmH) {
        return DURCHSCHNITTLICHE_ENTFERNUNG / geschwindigkeitKmH;
    }

    /**
     * Berechnet die Dauer zum Mond in Tagen (d).
     * @param geschwindigkeitKmH Geschwindigkeit (Km/h).
     * @return Dauer zum Mond in Tagen (d)
     */
    private double calculateInTagen(double geschwindigkeitKmH) {
        return this.calculateInStunden(geschwindigkeitKmH) / 24;
    }

    /**
     * Konvertiert einen String in einen Double-Wert.
     * @param value String
     * @return Wert als Double
     */
    private double convertStringToDouble(String value) {
        try {
            String geschwindigkeitString = textFieldGeschwindigkeit.getText();
            return Double.parseDouble(geschwindigkeitString);
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Ganzzahl ein.");
            return 0;
        }
    }

    /**
     * Eintrittspunkt für deine Anwendung
     * @param args Optionale Parameter
     */
    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
