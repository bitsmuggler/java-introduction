import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JSpinner spinnerNumberOfCols;
    private JButton OKButton;
    private JTextArea textAreaResult;
    private JButton buttonOK;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        Font font = new Font("Courier New", Font.PLAIN, 12);
        textAreaResult.setFont(font);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawRectangle();
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
     * Zeichnet ein Quadrat in der Textarea
     */
    private void drawRectangle() {
        int cols, rows = cols = Integer.parseInt(spinnerNumberOfCols.getValue().toString());
        System.out.println(cols);

        //Zeilen durchgehen
        for(int r = 0; r < rows; r++) {
            String stars = "";

            //Kolonnen durchgen
            for(int c = 0; c < cols; c++) {

                //Anfang - und Endzeile prüfen
                if(r == 0 || r == (rows - 1)) {
                    stars += "*";
                } else {
                    if(c == 0 || c == (cols - 1)) {
                        stars += "*";
                    } else {
                        stars += " ";
                    }
                }
            }

            //Zeile für Zeile ausgeben
            textAreaResult.append(stars + "\n");
            System.out.println(stars);
        }

    }
}
