import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldWidth;
    private JTextField textFieldHeight;
    private JButton buttonCalculate;
    private JTextField textFieldResult;
    private JButton buttonExit;


    /**
     * Konstruktor des Dialogs.
     */
    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCalculate);

        this.buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCalculate();
            }
        });

        this.buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Berechnet die Fläche eines Rechtecks.
     */
    private void onCalculate() {

        //Breite 'Text' vom Textfeld holen
        String textWidth = this.textFieldWidth.getText();

        //Höhe 'Text' vom Textfeld holen
        String textHeight = this.textFieldHeight.getText();

        //Breite 'Text' (String) in ein Double konvertieren.
        double width = Double.parseDouble(textWidth);

        //Höhe 'Text' (String) in ein Double konvertieren.
        double height = Double.parseDouble(textHeight);

        //Fläche berechnen
        double result = width * height;

        //Resultat auf GUI setzen.
        this.textFieldResult.setText(String.valueOf(result));
    }

    /**
     * Schliesst den Dialog.
     */
    private void onExit() {
        this.dispose();
    }

    /**
     * Eintrittspunkt der Anwendung.
     * @param args Optionale Argumente.
     */
    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
